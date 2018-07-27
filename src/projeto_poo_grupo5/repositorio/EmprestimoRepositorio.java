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
import java.sql.Statement;
import java.util.List;
import projeto_poo_grupo5.basica.Emprestimo;
import projeto_poo_grupo5.interfaces.CrudEmprestimoInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author BrunoTiCaVini
 */
public class EmprestimoRepositorio implements CrudEmprestimoInterface {

    Conexao conexao = null;

    @Override
    public Long insert(Emprestimo emprestimo) throws SQLException {
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "INSERT INTO emprestimo"
                + "(matricula,id_usuario,data_devolucao,data_aquisicao,data_entrega,valor_multa) "
                + "VALUES (?,?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql,
                                      Statement.RETURN_GENERATED_KEYS);


        preparedStatement.setString(1, emprestimo.getFuncionario().getMatricula());
        preparedStatement.setInt(2, emprestimo.getUsuario().getId_usuario());
        preparedStatement.setDate(3, emprestimo.getData_devolucao());
        preparedStatement.setDate(4,emprestimo.getData_aquisicao());
        preparedStatement.setDate(5, emprestimo.getData_entrega());
        preparedStatement.setDouble(6, emprestimo.getMulta());
        
        int affectedRows = preparedStatement.executeUpdate();
        long retorno = 0;
        
        
        if (affectedRows == 0) {
            throw new SQLException("Creating emprestimo failed, no rows affected.");
        }

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                retorno = generatedKeys.getLong(1);
            }
            else {
                throw new SQLException("Creating emprestimo failed, no ID obtained.");
            }
        
        conexao.Desconectar();
        
        return retorno;
    }

    @Override
    public boolean update(Emprestimo emprestimo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Emprestimo emprestimo) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Emprestimo> select() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
