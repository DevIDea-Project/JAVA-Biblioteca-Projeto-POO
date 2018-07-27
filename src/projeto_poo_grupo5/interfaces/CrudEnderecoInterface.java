/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Endereco;

/**
 *
 * @author Gabriel Augusto
 */
public interface CrudEnderecoInterface {
    public boolean insert(Endereco endereco) throws SQLException,Exception;
    public boolean update(Endereco endereco) throws SQLException,Exception;
    public boolean delete(Endereco endereco) throws SQLException,Exception;
    public List<Endereco> select() throws SQLException,Exception;
    
}
