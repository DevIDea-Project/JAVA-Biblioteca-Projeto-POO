/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;

/**
 *
 * @author Hyago
 */
public interface GenericaInterface {
    public boolean updateStatusAtivo(int id) throws SQLException, Exception;
    public boolean updateStatusInativo(int id) throws SQLException, Exception;
}
