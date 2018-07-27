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
import projeto_poo_grupo5.basica.Autor;
import projeto_poo_grupo5.interfaces.CrudAutorInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author Beto
 */
public class AutorRepositorio implements CrudAutorInterface{

    Conexao conexao = null;
    
    @Override
    public boolean insert(Autor autor) throws SQLException {
        
        conexao = Conexao.getInstance();
        
        Connection c = Conexao.getInstance().Conectar();
        
        String sql = "INSERT INTO autor (nome,biografia,nacionalidade) VALUES( ? , ? , ?)";
        
        PreparedStatement statement = c.prepareStatement(sql);
        
        statement.setString(1, autor.getNome());
        statement.setString(2, autor.getBiografia());
        statement.setString(3, autor.getNacionalidade());
        
        statement.executeUpdate();
        
        return true;
    }

    @Override
    public boolean update(Autor autor) throws SQLException {
        
        conexao = Conexao.getInstance();
        
        Connection c = Conexao.getInstance().Conectar();
        
        String sql = "UPDATE autor SET nome = ? , biografia = ? , nacionalidade = ? WHERE id_autor = ?";
        
        PreparedStatement statement = c.prepareStatement(sql);
        
        statement.setString(1, autor.getNome());
        statement.setString(2, autor.getBiografia());
        statement.setString(3, autor.getNacionalidade());
        statement.setInt(4, autor.getId_autor());
        
        statement.executeUpdate();
        
        return true;
    }

    @Override
    public boolean delete(Autor autor) throws SQLException {
        
        conexao = Conexao.getInstance();
        
        Connection c = Conexao.getInstance().Conectar();
        
        String sql = "DELETE FROM autor WHERE id_autor = ?";
        
        PreparedStatement statement = c.prepareStatement(sql);
        
        statement.setInt(1, autor.getId_autor());
        
        statement.execute();
        
        return true;
        
    }

    @Override
    public List<Autor> select() throws SQLException {
        
        conexao = Conexao.getInstance();
        
        List<Autor> listAutor = new ArrayList<Autor>();
        
        Connection c = Conexao.getInstance().Conectar();
        
        String sql = "SELECT id_autor,nome, biografia, nacionalidade FROM autor";
        
        PreparedStatement statement = c.prepareStatement(sql);
        
        ResultSet retorno = statement.executeQuery();
        
        while(retorno.next()){
            
            Autor itemAutor = new Autor();
            
            itemAutor.setId_autor(retorno.getInt("id_autor"));
            itemAutor.setNome(retorno.getString("nome"));
            itemAutor.setBiografia(retorno.getString("biografia"));
            itemAutor.setNacionalidade(retorno.getString("nacionalidade"));
            
            listAutor.add(itemAutor);
        }
        
        return listAutor;
    }
    
}
