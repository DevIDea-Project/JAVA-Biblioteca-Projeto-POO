package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Usuario;
import projeto_poo_grupo5.interfaces.CrudUsuarioInterface;
import projeto_poo_grupo5.interfaces.GenericaInterface;
import projeto_poo_grupo5.repositorio.UsuarioRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author João Gilberto
 */
public class UsuarioNegocio implements CrudUsuarioInterface, GenericaInterface{
       
    private UsuarioRepositorio usuarioRepositorio = null;
    
   /**
     *  Construtor da classe UsuarioNegocio
     */
    public UsuarioNegocio() {
        
        usuarioRepositorio = new UsuarioRepositorio();
    }  
    
    /**
     * Método responsável por realizar a inserção do objeto usuario;
     * @param usuario - objeto usuario a ser inserido;
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    @Override
        public boolean insert (Usuario usuario) throws SQLException, Exception{
            
        if (usuario.getPessoa().getId_pessoa() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_PESSOA_IGUAL_ZERO);
        } else {
            return usuarioRepositorio.insert(usuario);
        }        
    }

    /**
     * Método responsável por realizar a atualização de informações do objeto usuario;
     * @param usuario - objeto usuario a ser atualizado, necessário o id da categoria informado para identificação;
     * @return - true caso a atualização tenha sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento.
     */
    @Override
    public boolean update(Usuario usuario) throws SQLException, Exception {
        
        if (usuario.getPessoa().getId_pessoa() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_PESSOA_IGUAL_ZERO);
        } else if (usuario.getId_usuario() == 0) {
            throw new Exception (ExceptionMessage.ExceptionMessageUsuario.ID_USUARIO_IGUAL_ZERO);
        }
            return usuarioRepositorio.insert(usuario);
        }           

    /**
     * método responsável por realizar a remoção do registro de um usuario específica;
     * @param id - código identificador da usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - true caso seja removido com sucesso e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean delete(int id) throws SQLException, Exception {
        
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_USUARIO_IGUAL_ZERO);
        } else {
            return usuarioRepositorio.delete(id);
        }
    }

    /**
     * Método responsável por realizar a consulta de todos os usuarios registrados no banco de dados, independentemente de status;
     * @return - lista com todos os objetos usuario contidos no banco de dados;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Usuario> selectAll() throws SQLException, Exception {
        
        return usuarioRepositorio.selectAll();
    }

    /**
     * Método responsável por realizar a consulta de um usuario específica com base no id passado;
     * @param id - código identificador da usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - objeto usuario com as informações obtidas da consulta;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public Usuario selectById(int id) throws SQLException, Exception {
        
         if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_USUARIO_IGUAL_ZERO);
        } else {
            return usuarioRepositorio.selectById(id);
        }
    }

    /**
     * Método responsável por atualizar o status do usuario para ativo;
     * @param id - código identificador da usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusAtivo(int id) throws SQLException, Exception {
        
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_USUARIO_IGUAL_ZERO);
        } else {
            return usuarioRepositorio.updateStatusAtivo(id);
        }
    }

    /**
     * Método responsável por atualizar o status do usuario para inativo;
     * @param id - código identificador do usuario, pode ser obtido pelo método getId do objeto Usuario;
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema;
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusInativo(int id) throws SQLException, Exception {
        
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageUsuario.ID_USUARIO_IGUAL_ZERO);
        } else {
            return usuarioRepositorio.updateStatusInativo(id);
        }
    }   
        
}
