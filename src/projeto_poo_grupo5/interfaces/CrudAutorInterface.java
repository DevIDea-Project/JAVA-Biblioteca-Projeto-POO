/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Autor;

/**
 *
 * @author Beto
 */
public interface CrudAutorInterface {
    
    public boolean insert(Autor autor) throws SQLException;
    public boolean update(Autor autor)throws SQLException;
    public boolean delete(Autor autor) throws SQLException;
    public List<Autor> select() throws SQLException;

}
