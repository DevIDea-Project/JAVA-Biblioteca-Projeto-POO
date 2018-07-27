/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Exemplar;

/**
 *
 * @author Hyago
 */
public interface CrudExemplarInterface {
    boolean insert(Exemplar exemplar) throws SQLException,Exception;
    boolean update(Exemplar exemplar) throws SQLException,Exception;
    boolean delete(int id) throws SQLException,Exception;
    List<Exemplar> selectAll() throws SQLException,Exception;
    List<Exemplar> selectByLivro(int idLivro) throws SQLException,Exception;
    List<Exemplar> selectByIdioma(String idioma) throws SQLException,Exception;
}
