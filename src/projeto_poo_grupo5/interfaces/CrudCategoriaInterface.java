/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Categoria;

/**
 *
 * @author Hyago
 */
public interface CrudCategoriaInterface {

    public boolean insert(Categoria categoria) throws SQLException, Exception;

    public boolean update(Categoria categoria) throws SQLException, Exception;

    public boolean delete(int id) throws SQLException, Exception;

    public List<Categoria> selectAll() throws SQLException, Exception;

    public Categoria selectById(int id) throws SQLException, Exception;

    public List<Categoria> selectByNameAndStatus(Categoria categoria) throws SQLException, Exception;
}
