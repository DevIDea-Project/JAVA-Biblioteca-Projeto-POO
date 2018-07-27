/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.util.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;
import projeto_poo_grupo5.interfaces.ConexaoInterface;

/**
 *
 * @author Hyago
 */
public class Conexao implements ConexaoInterface {

    private final String URL_BD;
    private final String USUARIO_BD;
    private final String SENHA_BD;
    private static Conexao instancia;
    private Connection conexaoBd;

    private Conexao() {
        
        //pegando configuração de acesso ao BD pelo arquivo properties
        ResourceBundle rb = ResourceBundle.getBundle("projeto_poo_grupo5.util.banco.configBD");        
        // preenchendo as variaveis
        URL_BD = rb.getString("url");;
        USUARIO_BD  = rb.getString("usuario");
        SENHA_BD    = rb.getString("senha");
    }
    
    /**
     * Metodo para instancia a classe, caso ainda não tem nenhuma instancia.
     * @return instancia
     */
    public static Conexao getInstance(){
        
        if(instancia == null){
            instancia = new Conexao();
        }
        return instancia;
    }
    
    /**
     * Método de abertura de conexão com o banco de dados.
     *
     * @throws java.sql.SQLException
     */
    @Override
    public Connection Conectar() throws SQLException {
        
        //zerando a variavel de conexao
        conexaoBd = null;
        //Estabelecendo a conexao como banco de dados
        conexaoBd = DriverManager.getConnection(URL_BD, USUARIO_BD, SENHA_BD);
        
        return conexaoBd;
    }

    /**
     * Método de fechamento de conexões com o banco de dados.
     *
     * @throws java.sql.SQLException
     */
    @Override
    public void Desconectar() throws SQLException {
        
        if(conexaoBd!=null){
        conexaoBd.close();
        }
        
        
    }
    
}
