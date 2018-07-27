/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Hyago
 */
public interface ConexaoInterface {
    
    public Connection Conectar() throws SQLException ;
    public void Desconectar() throws SQLException ;
    
}
