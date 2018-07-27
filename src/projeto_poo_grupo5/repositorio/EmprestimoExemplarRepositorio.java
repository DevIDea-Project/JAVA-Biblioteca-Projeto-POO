/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.repositorio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.EmprestimoExemplar;
import projeto_poo_grupo5.interfaces.CrudEmprestimoExemplarInterface;

/**
 *
 * @author Hyago
 */
public class EmprestimoExemplarRepositorio implements CrudEmprestimoExemplarInterface{

    @Override
    public boolean insert(EmprestimoExemplar emprestimoExemplar, int idEmpresimo) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(EmprestimoExemplar emprestimoExemplar, int idEmpresimo) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(int idEmprestimo, int idExemplar) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmprestimoExemplar> selectAll() throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmprestimoExemplar> selectByEmprestimo(int idEmprestimo) throws SQLException, Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
