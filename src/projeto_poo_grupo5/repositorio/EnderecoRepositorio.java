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
import projeto_poo_grupo5.basica.Endereco;
import projeto_poo_grupo5.interfaces.CrudEnderecoInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author Gabriel Augusto
 */
public class EnderecoRepositorio implements CrudEnderecoInterface {
    
    Conexao conexao = null;

    /**
     * Gravar um novo Endereco na tabela endereco no Banco de Dados.
     * @param endereco Objeto com os dados a serem Gravados no Banco de Dados.
     * @return retorna true se o objeto endereco for adicionado no banco de dados.
     * @throws SQLException 
     */
    @Override
    public boolean insert(Endereco endereco) throws SQLException,Exception {
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "INSERT INTO endereco(logradouro,cep,numero,uf,cidade,bairro) VALUES (?,?,?,?,?,?)";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, endereco.getLogradouro());
        preparedStatement.setString(2, endereco.getCep());
        preparedStatement.setString(3, endereco.getNumero());
        preparedStatement.setString(4, endereco.getUf());
        preparedStatement.setString(5, endereco.getCidade());
        preparedStatement.setString(6, endereco.getBairro());
        
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        
        return true;
    }

    /**
     * Atualiza um Endereco no Banco de Dados com id_endereco que foi passado.
     * @param endereco Objeto com os dados que vão substituir na tabela Endereco do Banco de Dados.
     * @return Retorna true se o objeto for atualizado no banco.
     * @throws SQLException 
     */
    @Override
    public boolean update(Endereco endereco) throws SQLException,Exception {
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "UPDATE endereco SET logradouro = ?,cep = ?,numero = ?,uf = ?,cidade = ?,bairro = ? WHERE id_endereco = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setString(1, endereco.getLogradouro());
        preparedStatement.setString(2, endereco.getCep());
        preparedStatement.setString(3, endereco.getNumero());
        preparedStatement.setString(4, endereco.getUf());
        preparedStatement.setString(5, endereco.getCidade());
        preparedStatement.setString(6, endereco.getBairro());
        preparedStatement.setInt(7, endereco.getIdendereco());
        
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        
        
        return true;
    }

    /**
     * Deleta um Endereco da tabela endereco do Banco de Dados no qual foi passado id_endereco .
     * @param endereco Objeto com o id_endereco do endereco a ser deletado do Banco de Dados.
     * @return Retorna true se o endereco for deletado do banco de dados.
     * @throws SQLException 
     */
    @Override
    public boolean delete(Endereco endereco) throws SQLException,Exception {
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "DELETE FROM endereco WHERE id_endereco = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        preparedStatement.setInt(1, endereco.getIdendereco());
        
        preparedStatement.execute();
        
        conexao.Desconectar();
        
        return true;
    }

    /**
     * Lista os Enderecos da tabela endereco do Banco de Dados.
     * @return Retorna a Lista de enderecos.
     * @throws SQLException 
     */
    @Override
    public List<Endereco> select() throws SQLException,Exception {
        
        List<Endereco> endereco = new ArrayList<>();
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "SELECT * FROM endereco";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        ResultSet resultEndereco = preparedStatement.executeQuery();
        
        while (resultEndereco.next()){
            
            Endereco endere = new Endereco();
            
            endere.setIdendereco(resultEndereco.getInt("id_endereco"));
            endere.setLogradouro(resultEndereco.getString("logradouro"));
            endere.setCep(resultEndereco.getString("cep"));
            endere.setNumero(resultEndereco.getString("numero"));
            endere.setUf(resultEndereco.getString("uf"));
            endere.setCidade(resultEndereco.getString("cidade"));
            endere.setBairro(resultEndereco.getString("bairro"));
            endereco.add(endere);
        }
        conexao.Desconectar();
        
        
        
        
        return endereco;
    }
    
    
    public boolean verificarIdEnderecoExiste(Endereco endereco)throws SQLException,Exception {     
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();       
        String sql = "SELECT id_endereco FROM endereco WHERE id_endereco = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,endereco.getIdendereco());
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()){
            
            return true;
    }
        
        conexao.Desconectar();
        return false;
        
    }
    
}

