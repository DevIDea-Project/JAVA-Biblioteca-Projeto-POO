package projeto_poo_grupo5.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto_poo_grupo5.basica.Usuario;
import projeto_poo_grupo5.interfaces.CrudUsuarioInterface;
import projeto_poo_grupo5.interfaces.GenericaInterface;
import projeto_poo_grupo5.util.banco.Conexao;


/**
 *
 * @author João Gilberto
 */
public class UsuarioRepositorio implements CrudUsuarioInterface, GenericaInterface{
    
    Conexao conexao = null;
    
    public UsuarioRepositorio(){
        
    }
    /**
     * Método responsável por realizar a inserção do objeto usuario;
     * @param usuario - objeto usuario a ser inserido;
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    @Override
    public boolean insert(Usuario usuario) throws SQLException {     
        
        conexao = Conexao.getInstance();        
        Connection connection = conexao.Conectar();
        
        String sql = "INSERT INTO usuario(id_pessoa, status) VALUES (?,?)";        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);        
        preparedStatement.setInt(1, usuario.getPessoa().getId_pessoa());
        preparedStatement.setInt(2, usuario.getStatus());        
        preparedStatement.executeUpdate(); 
        
        conexao.Desconectar();                
        return true;
    }
    /**
     * Método responsável por realizar a atualização de informações do objeto usuario;
     * @param usuario - objeto usuario a ser atualizado, necessário o id da usuario informado para identificação;
     * @return - true caso a atualização tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    @Override
    public boolean update(Usuario usuario) throws SQLException {
        
        conexao = Conexao.getInstance();        
        Connection connection = conexao.Conectar();  
        
        String sql = "UPDATE usuario SET id_pessoa = ?, status = ? WHERE id_usuario = ?";         
        PreparedStatement preparedStatement = connection.prepareStatement(sql);        
        preparedStatement.setInt(1, usuario.getPessoa().getId_pessoa());
        preparedStatement.setInt(2, usuario.getStatus());
        preparedStatement.setInt(3, usuario.getId_usuario());        
        preparedStatement.executeUpdate(); 
        
        conexao.Desconectar();        
        return true;
    }
    /**
     * método responsável por realizar a remoção do registro de um usuario específico;
     * @param id - código identificador de usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - true caso seja removido com sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean delete (int id) throws SQLException { 
        
        conexao = Conexao.getInstance();        
        Connection connection = conexao.Conectar();   
        
        String sql = "DELETE FROM usuario WHERE id_usuario = ?";        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);        
        preparedStatement.setInt(1, id);        
        preparedStatement.execute();
        
        conexao.Desconectar();
        return true;
    }
    /**
     * Método responsável por realizar a consulta de todos os usuarios registrados no banco de dados, independentemente de status;
     * @return - lista com todos os objetos Usuarios contidos no banco de dados;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Usuario> selectAll() throws SQLException {  
        
        List<Usuario> usuario = new ArrayList<>(); 
        
        conexao = Conexao.getInstance();        
        Connection connection = conexao.Conectar(); 
        
        String sql = "SELECT * FROM usuario";        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);                
        ResultSet resultUsuario = preparedStatement.executeQuery();
        
        while(resultUsuario.next()){        
            Usuario u = new Usuario();            
            u.setId_usuario(resultUsuario.getInt("id_usuario"));
            u.getPessoa().setId_pessoa(resultUsuario.getInt("id_pessoa"));
            u.setStatus(resultUsuario.getString("status").charAt(0));            
            usuario.add(u);            
        }        
        conexao.Desconectar();        
        return usuario;
    }    
    /**
     * Método responsável por realizar a consulta de um usuario específico com base no id passado;
     * @param id - código identificador do usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - objeto Usuario com as informações obtidas da consulta;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public Usuario selectById(int id) throws SQLException {
        
        Usuario usuario = null;
        
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        
        String sql = "SELECT id_usuario,id_pessoa,status FROM usuario WHERE id_usuario = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        
        while (rs.next()) {
            Usuario u = new Usuario();            
            u.setId_usuario(rs.getInt("id_usuario"));
            u.getPessoa().setId_pessoa(rs.getInt("id_pessoa"));
            u.setStatus(rs.getString("status").charAt(0)); 
        }
        conexao.Desconectar();
        return usuario;
    }    
     /**
     * Método responsável por atualizar o status da usuario para ativo;
     * @param id - código identificador do usuario, pode ser obtido pelo método getId do objeto usuario;
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusAtivo(int id) throws SQLException {
        
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        
        String sql = "UPDATE usuario SET ativo = ? WHERE id_usuario = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf('S'));
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        
        conexao.Desconectar();
        return true;
    }     
     /**
     * Método responsável por atualizar o status do usuario para inativo.
     * @param id - código identificador do usuartio, pode ser obtido pelo método getId do objeto Usuario;
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */           
    @Override
    public boolean updateStatusInativo(int id) throws SQLException {
        
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        
        String sql = "UPDATE usuario SET ativo = ? WHERE id_usuario = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf('N'));
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        
        conexao.Desconectar();
        return true;
    }  
   
    
}
