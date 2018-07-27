/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Pessoa;

/**
 *
 * @author Beto
 */
public interface CrudPessoaInterface {
    
    public boolean insert(Pessoa pessoa) throws SQLException, Exception;
    public boolean update(Pessoa pessoa) throws SQLException, Exception;
    public boolean delete(int id) throws SQLException, Exception;
    public List<Pessoa> selectAll() throws SQLException, Exception;
    public List<Pessoa> selectByNome(String nome) throws SQLException, Exception;
    public List<Pessoa> selectByNomeAndGenero(Pessoa pessoa) throws SQLException, Exception;
    public boolean isCpfExistente(String cpf) throws SQLException, Exception;
    public int selectIdByCpf(String cpf) throws SQLException, Exception;
}
