/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.repositorio;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto_poo_grupo5.basica.Categoria;
import projeto_poo_grupo5.interfaces.CrudCategoriaInterface;
import projeto_poo_grupo5.interfaces.GenericaInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author Hyago
 */
public class CategoriaRepositorio implements CrudCategoriaInterface, GenericaInterface {

    private Conexao conexao = null;

    public CategoriaRepositorio() {

    }

    /**
     * Método responsável por realizar a inserção do objeto categoria.
     * @param categoria - objeto categoria a ser inserido
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento
     */
    @Override
    public boolean insert(Categoria categoria) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "INSERT INTO categoria (nome) VALUES (?)";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.execute();
        conexao.Desconectar();
        return true;
    }

    /**
     * Método responsável por realizar a atualização de informações do objeto categoria.
     * @param categoria - objeto categoria a ser atualizado, necessário o id da categoria informado para identificação
     * @return - true caso a atualização tenha sucesso e false caso ocorra algum problema
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento
     */
    @Override
    public boolean update(Categoria categoria) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "UPDATE categoria SET nome = ?, ativo = ? WHERE id_categoria = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, categoria.getNome());
        preparedStatement.setString(2, String.valueOf(categoria.getAtivo()));
        preparedStatement.setInt(3, categoria.getId());
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
    }

    /**
     * método responsável por realizar a remoção do registro de uma categoria específica.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso seja removido com sucesso e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean delete(int id) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "DELETE FROM categoria WHERE id_categoria = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        conexao.Desconectar();
        return true;
    }

    /**
     * Método responsável por realizar a consulta de todas as categorias registradas no banco de dados, independentemente de status.
     * @return - lista com todos os objetos categoria contidos no banco de dados.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Categoria> selectAll() throws SQLException {
        List<Categoria> categoriaList = new ArrayList();
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "SELECT id_categoria,nome,ativo FROM categoria";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id_categoria"));
            categoria.setNome(rs.getString("nome"));
            categoria.setAtivo(rs.getString("ativo").charAt(0));
            categoriaList.add(categoria);
        }
        conexao.Desconectar();
        return categoriaList;
    }

    /**
     * Método responsável por realizar a consulta de uma categoria específica com base no id passado.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - objeto categoria com as informações obtidas da consulta.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public Categoria selectById(int id) throws SQLException {
        Categoria categoria = null;
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "SELECT id_categoria,nome,ativo FROM categoria WHERE id_categoria = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            categoria = new Categoria();
            categoria.setId(rs.getInt("id_categoria"));
            categoria.setNome(rs.getString("nome"));
            categoria.setAtivo(rs.getString("ativo").charAt(0));
        }
        conexao.Desconectar();
        return categoria;
    }

    /**
     * Método responsável por atualizar o status da categoria para ativo.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusAtivo(int id) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "UPDATE categoria SET ativo = ? WHERE id_categoria = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf('S'));
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
    }
    /**
     * Método responsável por atualizar o status da categoria para inativo.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusInativo(int id) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "UPDATE categoria SET ativo = ? WHERE id_categoria = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf('N'));
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
    }

    /**
     * Método responsável por realizar a consulta de categorias com base no nome e no status passado. 
     * @param categoria - objeto categoria com as informações de nome e status para usar como restrição da consulta.
     * @return - lista de categorias contendo os resultados obtidos da consulta.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Categoria> selectByNameAndStatus(Categoria categoria) throws SQLException {
        List<Categoria> categoriaList = new ArrayList();
        conexao = Conexao.getInstance();
        Connection connection = (Connection) conexao.Conectar();
        String sql = "SELECT id_categoria,nome,ativo FROM categoria "
                + "WHERE nome LIKE ? and status = ?";
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        preparedStatement.setString(1, "%"+categoria.getNome()+"%");
        preparedStatement.setString(2, String.valueOf(categoria.getAtivo()));
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            Categoria cat = new Categoria();
            cat.setId(rs.getInt("id_categoria"));
            cat.setNome(rs.getString("nome"));
            cat.setAtivo(rs.getString("ativo").charAt(0));
            categoriaList.add(cat);
        }
        conexao.Desconectar();
        return categoriaList;
    }

}
