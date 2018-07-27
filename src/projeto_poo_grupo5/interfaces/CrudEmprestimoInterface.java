/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Emprestimo;


/**
 *
 * @author BrunoTiCaVini
 */
public interface CrudEmprestimoInterface {
      
    public Long insert(Emprestimo emprestimo) throws SQLException;
    public boolean update(Emprestimo emprestimo) throws SQLException;
    public boolean delete(Emprestimo emprestimo) throws SQLException;
    public List<Emprestimo> select() throws SQLException;
}
