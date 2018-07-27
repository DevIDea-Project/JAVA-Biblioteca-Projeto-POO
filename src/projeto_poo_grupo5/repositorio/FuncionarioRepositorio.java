/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.repositorio;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto_poo_grupo5.basica.Funcionario;
import projeto_poo_grupo5.interfaces.CrudFuncionarioInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author BrunoTiCaVini
 */
public class FuncionarioRepositorio implements CrudFuncionarioInterface{

    Conexao conexao = null;
    
    @Override
    public boolean insert(Funcionario funcionario) throws SQLException {
        
        conexao = Conexao.getInstance();
        
        Connection connection = conexao.Conectar();
        
         String sql = "INSERT INTO funcionario(matricula,senha,tipo,funcao,id_pessoa)"
                + " VALUES (?,?,?,?,?)";
         
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, funcionario.getMatricula());
        preparedStatement.setString(2, funcionario.getSenha());
        preparedStatement.setInt(3, funcionario.getTipo());
        preparedStatement.setString(4, funcionario.getFuncao());
        preparedStatement.setInt(5, funcionario.getPessoa().getId_pessoa());
        
        
        preparedStatement.executeUpdate();
        
        conexao.Desconectar();
        return true;
    }

    @Override
    public boolean update(Funcionario funcionario) throws SQLException {
          conexao = Conexao.getInstance();
        
        Connection connection = conexao.Conectar();
        
        String sql = "UPDATE funcionario SET senha = ?, tipo = ?,"
                + "funcao = ? "
                + " WHERE matricula = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        

        preparedStatement.setString(1, funcionario.getSenha());
        preparedStatement.setInt(2, funcionario.getTipo());
        preparedStatement.setString(3, funcionario.getFuncao());
        preparedStatement.setString(4, funcionario.getMatricula());
        
        preparedStatement.executeUpdate();
        
        conexao.Desconectar();
        
        return true; 
    }

    @Override
    public boolean delete(Funcionario funcionario) throws SQLException {
      conexao = Conexao.getInstance();
        
        Connection connection = conexao.Conectar();
        
        String sql = "DELETE FROM funcionario WHERE matricula = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, funcionario.getPessoa().getId_pessoa());
        
        preparedStatement.execute();
                
        conexao.Desconectar();
        
        return true;
    }

    @Override
    public List<Funcionario> select() throws SQLException {
      
        List<Funcionario> Funcionarios = new ArrayList<>();
        
        conexao = Conexao.getInstance();
        
        Connection connection = conexao.Conectar();
        
        String sql = "SELECT * FROM funcionario";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
                
        ResultSet resultFuncionario = preparedStatement.executeQuery();
        
        while(resultFuncionario.next()){
        
            Funcionario f = new Funcionario();
            
            
            f.setMatricula(resultFuncionario.getString("matricula"));  
            
            f.setSenha(resultFuncionario.getString("senha"));
            
            f.setTipo(resultFuncionario.getInt("tipo"));
            
            f.setFuncao(resultFuncionario.getString("funcao"));
            
            f.getPessoa().setId_pessoa(resultFuncionario.getInt("id_pessoa"));
            
            Funcionarios.add(f);
            
        }
        conexao.Desconectar();
                
        return Funcionarios;

    }

    public List<Funcionario> selectAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updateStatusAtivo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public boolean updateStatusInativo() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
}
