/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Autor;
import projeto_poo_grupo5.interfaces.CrudAutorInterface;
import projeto_poo_grupo5.repositorio.AutorRepositorio;

/**
 *
 * @author Beto
 */
public class AutorNegocio implements CrudAutorInterface{
    
    AutorRepositorio autorRep = null;

    @Override
    public boolean insert(Autor autor) throws SQLException {
        
        autorRep = new AutorRepositorio();
        autorRep.insert(autor);
        
        return  true;
    }

    @Override
    public boolean update(Autor autor) throws SQLException {
        autorRep = new AutorRepositorio();
        autorRep.update(autor);
        
        return true;
    }

    @Override
    public boolean delete(Autor autor) throws SQLException {
        autorRep = new AutorRepositorio();
        autorRep.delete(autor);
        
        return true;
    }

    @Override
    public List<Autor> select() throws SQLException {
        autorRep = new AutorRepositorio();
        
        return autorRep.select();
    }
    
}
