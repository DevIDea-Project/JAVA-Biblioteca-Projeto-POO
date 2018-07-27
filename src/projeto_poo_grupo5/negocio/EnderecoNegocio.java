/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Endereco;
import projeto_poo_grupo5.interfaces.CrudEnderecoInterface;
import projeto_poo_grupo5.repositorio.EnderecoRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author gaugusto
 */
public class EnderecoNegocio implements CrudEnderecoInterface {
    
    private EnderecoRepositorio enderecoRepositorio = null;
    
    public EnderecoNegocio(){
       enderecoRepositorio = new EnderecoRepositorio();
    }
  /**
   * Metodo usado para verificar antes de inserir se os dados passados
   * não excede o limite de caracteres do campo no banco ou se possui nulo ou branco.
   * @param endereco Objeto a ser adicionado.
   * @return Retorna true caso insira no banco o objeto.
   * @throws SQLException
   * @throws Exception 
   */
    @Override
    public boolean insert(Endereco endereco) throws SQLException,Exception {
        
        validarQtdCaracteresBrancoNulo(endereco);
    
    return enderecoRepositorio.insert(endereco);    
    }

    
    /**
     * Metodo usado para para verificar o Id endereco se é zero antes de atualizar
     * @param endereco objeto a ser inserido no banco
     * @return Retorna true se for feito a alteração.
     * @throws SQLException
     * @throws Exception 
     */
    @Override
    public boolean update(Endereco endereco) throws SQLException,Exception {
    
        if(validarQtdCaracteresBrancoNulo(endereco)){
            if(endereco.getIdendereco() == 0){
                throw new Exception("Id Endereco"+ExceptionMessage.ID_IGUAL_ZERO);
            }
            
            if(enderecoRepositorio.verificarIdEnderecoExiste(endereco) != true){
               throw new Exception(ExceptionMessage.ExceptionMessageEndereco.ID_NAO_EXISTE); 
            }
            
            
        }
       return enderecoRepositorio.update(endereco);    
    }

    /**
     * Metodo usado para verificar se o Id endereco é zero antes de deletar
     * @param endereco objeto que sera deletado.
     * @return retorna true se o id não for zero e for deletado.
     * @throws SQLException
     * @throws Exception 
     */
    @Override
    public boolean delete(Endereco endereco) throws SQLException,Exception {
    
     if(endereco.getIdendereco() == 0){
        throw new Exception("Id Endereco"+ExceptionMessage.ID_IGUAL_ZERO);
     }
     
     if(enderecoRepositorio.verificarIdEnderecoExiste(endereco) != true){
               throw new Exception(ExceptionMessage.ExceptionMessageEndereco.ID_NAO_EXISTE); 
            }
     
     return enderecoRepositorio.delete(endereco);
    }

    @Override
    public List<Endereco> select() throws SQLException,Exception {
        
        return enderecoRepositorio.select();
    }
    
    /**
     * Metodo usado para validar o objeto se possui branco ou nulo.
     * @param endereco objeto a ser validado.
     * @return Retorna true se as condições forem falsas.
     * @throws SQLException
     * @throws Exception 
     */
    public boolean validarQtdCaracteresBrancoNulo(Endereco endereco) throws SQLException,Exception { 
        
        if(endereco.getLogradouro().length() > 100){
            throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"100");   
        }
        
        if (endereco.getLogradouro().equals("") || endereco.getLogradouro().trim().isEmpty()){
            throw new Exception ("Logradouro"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO);   
        }
        
        if(endereco.getCep().length() > 9){
            throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"9");   
        }
        
        if (endereco.getCep().equals("") || endereco.getCep().trim().isEmpty()){
            throw new Exception ("Cep"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO);
        }
        
        if (endereco.getNumero().length() > 10){
            throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"10");
        }
        if (endereco.getNumero().equals("") || endereco.getNumero().trim().isEmpty()){
            throw new Exception ("Numero"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO); 
        }
        
        if (endereco.getUf().length() > 2){
            throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"2");    
        }
        
        if (endereco.getUf().equals("") || endereco.getUf().trim().isEmpty()){
            throw new Exception ("Uf"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO);
        }
        
        if(endereco.getCidade().length() > 20){
          throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"20");    
        }
        
        if(endereco.getCidade().equals("") || endereco.getCidade().trim().isEmpty()){
            throw new Exception ("Cidade"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO);
        }
        
        if(endereco.getBairro().length() > 20){
           throw new Exception (ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS+"20"); 
        }
        
        if(endereco.getBairro().equals("") || endereco.getBairro().trim().isEmpty()){
           throw new Exception ("Bairro"+ExceptionMessage.ExceptionMessageEndereco.NULL_OU_VAZIO);
        }
        
        return true;
    }
    
    
}
