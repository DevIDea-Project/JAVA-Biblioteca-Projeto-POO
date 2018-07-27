/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;
import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.EmprestimoExemplar;
/**
 *
 * @author Hyago
 */
public interface CrudEmprestimoExemplarInterface {
    boolean insert(EmprestimoExemplar emprestimoExemplar,int idEmpresimo) throws SQLException, Exception;
    boolean update(EmprestimoExemplar emprestimoExemplar,int idEmpresimo) throws SQLException, Exception;
    boolean delete(int idEmprestimo,int idExemplar) throws SQLException, Exception;
    List<EmprestimoExemplar> selectAll() throws SQLException, Exception;
    List<EmprestimoExemplar> selectByEmprestimo(int idEmprestimo) throws SQLException, Exception;
}
