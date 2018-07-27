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
import projeto_poo_grupo5.basica.Exemplar;
import projeto_poo_grupo5.interfaces.CrudExemplarInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author Hyago
 */
public class ExemplarRepositorio implements CrudExemplarInterface {
    
    private Conexao conexao;
    
    public ExemplarRepositorio() {
        
    }
    
    @Override
    public boolean insert(Exemplar exemplar) throws SQLException, Exception {
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "INSERT INTO exemplar(id_livro, idioma) VALUES (?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, exemplar.getLivro().getId_livro());
        preparedStatement.setString(2, exemplar.getIdioma());
        preparedStatement.execute();
        
        conexao.Desconectar();
        return true;
    }
    
    @Override
    public boolean update(Exemplar exemplar) throws SQLException, Exception {
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "UPDATE exemplar SET id_livro = ?, idioma = ? WHERE id_exemplar = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, exemplar.getLivro().getId_livro());
        preparedStatement.setString(2, exemplar.getIdioma());
        preparedStatement.setInt(3, exemplar.getId_exemplar());
        preparedStatement.executeUpdate();
        
        conexao.Desconectar();
        return true;
    }
    
    @Override
    public boolean delete(int id) throws SQLException, Exception {
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "DELETE FROM exemplar WHERE id_exemplar = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        preparedStatement.execute();
        
        conexao.Desconectar();
        return true;
    }
    
    @Override
    public List<Exemplar> selectAll() throws SQLException, Exception {
        List<Exemplar> exemplarList = new ArrayList();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "SELECT id_exemplar,id_livro,idioma FROM exemplar";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSetExemplar = preparedStatement.executeQuery();
        
        while (resultSetExemplar.next()) {
            Exemplar exemplar = new Exemplar();
            exemplar.setId_exemplar(resultSetExemplar.getInt("id_exemplar"));
            exemplar.getLivro().setId_livro(resultSetExemplar.getInt("id_livro"));
            exemplar.setIdioma(resultSetExemplar.getString("idioma"));
            exemplarList.add(exemplar);
        }
        
        conexao.Desconectar();
        
        return exemplarList;
    }
    
    @Override
    public List<Exemplar> selectByLivro(int idLivro) throws SQLException, Exception {
        List<Exemplar> exemplarList = new ArrayList();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "SELECT id_exemplar,id_livro,idioma FROM exemplar WHERE id_livro = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, idLivro);
        ResultSet resultSetExemplar = preparedStatement.executeQuery();
        
        while (resultSetExemplar.next()) {
            Exemplar exemplar = new Exemplar();
            exemplar.setId_exemplar(resultSetExemplar.getInt("id_exemplar"));
            exemplar.getLivro().setId_livro(resultSetExemplar.getInt("id_livro"));
            exemplar.setIdioma(resultSetExemplar.getString("idioma"));
            exemplarList.add(exemplar);
        }
        
        conexao.Desconectar();
        
        return exemplarList;
    }

    @Override
    public List<Exemplar> selectByIdioma(String idioma) throws SQLException, Exception {
        List<Exemplar> exemplarList = new ArrayList();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();
        
        String sql = "SELECT id_exemplar,id_livro,idioma FROM exemplar WHERE idioma = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%"+idioma+"%");
        ResultSet resultSetExemplar = preparedStatement.executeQuery();
        
        while (resultSetExemplar.next()) {
            Exemplar exemplar = new Exemplar();
            exemplar.setId_exemplar(resultSetExemplar.getInt("id_exemplar"));
            exemplar.getLivro().setId_livro(resultSetExemplar.getInt("id_livro"));
            exemplar.setIdioma(resultSetExemplar.getString("idioma"));
            exemplarList.add(exemplar);
        }
        
        conexao.Desconectar();
        
        return exemplarList;
    }
    
}
