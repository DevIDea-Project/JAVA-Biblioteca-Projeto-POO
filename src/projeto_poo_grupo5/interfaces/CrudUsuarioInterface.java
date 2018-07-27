package projeto_poo_grupo5.interfaces;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Usuario;

/**
 *
 * @author João Gilberto
 */
public interface CrudUsuarioInterface {
    
    /**
     * Grava um usuario no banco de dados;
     * @param usuario - objeto com os dados validos;
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    public boolean insert(Usuario usuario) throws SQLException, Exception;
    
    /**
     * Grava as alterações feitas em usuario no banco de dados;
     * @param usuario - objeto com os dados;
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */    
    public boolean update(Usuario usuario)throws SQLException, Exception;
    
    /**
     * Apaga um registro no banco de dados;
     * @param id - objeto contendo a identificação para exclusão;
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    public boolean delete(int id) throws SQLException, Exception;
    
     /**
     * Lista todos os registros do banco de dados;
     * @return - retorna usuários registrados no banco de dados;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    public List<Usuario> selectAll() throws SQLException, Exception;
    
    /**
     * Lista os usuarios registrados por identificação no banco de dados;
     * @param id - identificação gerada no banco e que será utilizada para seleção;
     * @return - retorna usuários por identificação gerada no banco de dados;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    public Usuario selectById(int id) throws SQLException, Exception;
    
    /**
     * Atualiza status ativos;
     * @param id - identificação do status do objeto;
     * @return - true caso a alteração tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */ 
    public boolean updateStatusAtivo(int id) throws SQLException, Exception;
    
     /**
     * Atualiza status inativos;
     * @param id - identificação do status do objeto;
     * @return - true caso a alteração tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    public boolean updateStatusInativo(int id) throws SQLException, Exception;
    
}
