/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Livro;

/**
 *
 * @author Beto
 */
public interface CrudLivroInterface {

    public boolean insert(Livro livro) throws SQLException ,Exception;
    public boolean update(Livro livro) throws SQLException ,Exception;
    public boolean delete(Livro livro) throws SQLException, Exception;
    public List<Livro> selectAll() throws SQLException, Exception;
    public List<Livro> selectByTitulo(Livro livro) throws SQLException, Exception;
    public boolean verificarDuplicidade(Livro livro) throws SQLException, Exception;

}
