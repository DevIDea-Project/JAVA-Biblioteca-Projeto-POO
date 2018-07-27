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
import projeto_poo_grupo5.basica.Livro;
import projeto_poo_grupo5.util.banco.Conexao;
import projeto_poo_grupo5.interfaces.CrudLivroInterface;

/**
 *
 * @author Beto
 */
public class LivroRepositorio implements CrudLivroInterface{
    
    Conexao conexao = null;

    
    @Override
    public boolean insert(Livro livro) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "INSERT INTO livro(id_categoria,id_autor,titulo,lancamento,edicao,isbn,editora,paginas,descricao)"
                + " VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, livro.getCategoria().getId());
        preparedStatement.setInt(2, livro.getAutor().getId_autor());
        preparedStatement.setString(3, livro.getTitulo());
        preparedStatement.setDate(4, livro.getLancamento());
        preparedStatement.setString(5, livro.getEdicao());
        preparedStatement.setString(6, livro.getIsbn());
        preparedStatement.setString(7, livro.getEditora());
        preparedStatement.setInt(8, livro.getPaginas());
        preparedStatement.setString(9, livro.getDescricao());

        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
    }

    @Override
    public boolean update(Livro livro) throws SQLException {

        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "UPDATE livro SET id_categoria = ? ,id_autor = ? , "
                + " titulo = ? ,lancamento = ? ,edicao = ?,isbn = ?,editora = ?,paginas = ?,descricao = ? "
                + " WHERE id_livro = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, livro.getCategoria().getId());
        preparedStatement.setInt(2, livro.getAutor().getId_autor());
        preparedStatement.setString(3, livro.getTitulo());
        preparedStatement.setDate(4, livro.getLancamento());
        preparedStatement.setString(5, livro.getEdicao());
        preparedStatement.setString(6, livro.getIsbn());
        preparedStatement.setString(7, livro.getEditora());
        preparedStatement.setInt(8, livro.getPaginas());
        preparedStatement.setString(9, livro.getDescricao());
        preparedStatement.setInt(10, livro.getId_livro());
        
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
        
    }

    @Override
    public boolean delete(Livro livro) throws SQLException {
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "DELETE FROM livro WHERE id_livro = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, livro.getId_livro());

        preparedStatement.execute();
        conexao.Desconectar();
        return true;    
    
    }

    @Override
    public List<Livro> selectAll() throws SQLException {

        List<Livro> livros = new ArrayList<>();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT l.id_livro,"
                //categoria do livro
                + " c.id_categoria , c.nome nome_categoria , c.ativo ,"
                //autor do livro
                + " a.id_autor, a.nome nome_autor , a.biografia , a.nacionalidade ,"
                //livro
                + " l.titulo, l.lancamento, l.edicao, l.isbn, l.editora, l.paginas, l.descricao "
                + "FROM livro AS l "
                + "INNER JOIN categoria c ON (l.id_categoria = c.id_categoria) "
                + "INNER JOIN autor a ON (l.id_autor = a.id_autor);" ;
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        ResultSet resultLivro = preparedStatement.executeQuery();
        
        while (resultLivro.next()) {
            Livro l = new Livro();
                      
            l.setId_livro(resultLivro.getInt("id_livro"));
            
            // categoria
            l.getCategoria().setId(resultLivro.getInt("id_categoria"));
            l.getCategoria().setNome(resultLivro.getString("nome_categoria"));
            l.getCategoria().setAtivo(resultLivro.getString("ativo").charAt(0));
            
            //autor
            l.getAutor().setId_autor(resultLivro.getInt("id_autor"));
            l.getAutor().setNome(resultLivro.getString("nome_autor"));
            l.getAutor().setBiografia(resultLivro.getString("biografia"));
            l.getAutor().setNacionalidade(resultLivro.getString("nacionalidade"));
          
            //livro
            l.setTitulo(resultLivro.getString("titulo"));
            l.setLancamento(resultLivro.getDate("lancamento"));
            l.setEdicao(resultLivro.getString("edicao"));
            l.setIsbn(resultLivro.getString("isbn"));
            l.setEditora(resultLivro.getString("editora"));
            l.setPaginas(resultLivro.getInt("paginas"));
            l.setDescricao(resultLivro.getString("descricao"));
           
            livros.add(l);
        }

        conexao.Desconectar();
        return livros;
        
    }

    @Override
    public List<Livro> selectByTitulo(Livro livro) throws SQLException {
        
        List<Livro> livros = new ArrayList<>();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT l.id_livro,"
                //categoria do livro
                + " c.id_categoria , c.nome nome_categoria , c.ativo ,"
                //autor do livro
                + " a.id_autor, a.nome nome_autor , a.biografia , a.nacionalidade ,"
                //livro
                + " l.titulo, l.lancamento, l.edicao, l.isbn, l.editora, l.paginas, l.descricao "
                + "FROM livro AS l "
                + "INNER JOIN categoria c ON (l.id_categoria = c.id_categoria) "
                + "INNER JOIN autor a ON (l.id_autor = a.id_autor)"
                + " WHERE l.titulo LIKE ? ";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        
        String like = new StringBuilder().append("%")
                .append(livro.getTitulo())
                .append("%").toString();
        
        preparedStatement.setString(1, like);
        
        ResultSet resultLivro = preparedStatement.executeQuery();
        
        while (resultLivro.next()) {
            Livro l = new Livro();
                      
            l.setId_livro(resultLivro.getInt("id_livro"));
            
            // categoria
            l.getCategoria().setId(resultLivro.getInt("id_categoria"));
            l.getCategoria().setNome(resultLivro.getString("nome_categoria"));
            l.getCategoria().setAtivo(resultLivro.getString("ativo").charAt(0));
            
            //autor
            l.getAutor().setId_autor(resultLivro.getInt("id_autor"));
            l.getAutor().setNome(resultLivro.getString("nome_autor"));
            l.getAutor().setBiografia(resultLivro.getString("biografia"));
            l.getAutor().setNacionalidade(resultLivro.getString("nacionalidade"));
          
            //livro
            l.setTitulo(resultLivro.getString("titulo"));
            l.setLancamento(resultLivro.getDate("lancamento"));
            l.setEdicao(resultLivro.getString("edicao"));
            l.setIsbn(resultLivro.getString("isbn"));
            l.setEditora(resultLivro.getString("editora"));
            l.setPaginas(resultLivro.getInt("paginas"));
            l.setDescricao(resultLivro.getString("descricao"));
           
            livros.add(l);
        }

        conexao.Desconectar();
        return livros;
        
    }

    @Override
    public boolean verificarDuplicidade(Livro livro) throws SQLException {
        
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT * FROM livro WHERE titulo = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
               
        preparedStatement.setString(1, livro.getTitulo());
        
        ResultSet resultLivro = preparedStatement.executeQuery();
        
        while (resultLivro.next()) {
            return true;
        }

        conexao.Desconectar();
        return false;

    }
    
    
    
}
