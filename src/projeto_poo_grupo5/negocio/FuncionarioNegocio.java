/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Funcionario;
import projeto_poo_grupo5.basica.Pessoa;
import projeto_poo_grupo5.interfaces.CrudFuncionarioInterface;
import projeto_poo_grupo5.interfaces.GenericaInterface;
import projeto_poo_grupo5.repositorio.FuncionarioRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 * @author BrunoTiCaVini
 */
public class FuncionarioNegocio implements CrudFuncionarioInterface, GenericaInterface {

    FuncionarioRepositorio repositorio = null;
     
    public FuncionarioNegocio(){
    
    }
    
    @Override
    public boolean insert(Funcionario funcionario) throws SQLException, Exception{
        
         validarAtributos(funcionario);
         
        repositorio = new FuncionarioRepositorio();
        
        repositorio.insert(funcionario);
        return true;
            
    }

    @Override
    public boolean update(Funcionario funcionario) throws SQLException, Exception {
        
        //Metodo para validar campos excedendo quantidade de caracteres
        validarAtributos(funcionario);
        
        //chamando a classe de repositorio
        repositorio = new FuncionarioRepositorio();
        repositorio.update(funcionario);
        return true;
    }

    @Override
    public boolean delete(Funcionario funcionario) throws SQLException, Exception {
        
        //Metodo para validar campo nulos ou vazios
         validarAtributos(funcionario);
       
        //Metodo para validar campos excedendo quantidade de caracteres
        
        
        //chamando a classe de repositorio
        repositorio = new FuncionarioRepositorio();
        repositorio.delete(funcionario);
        
        return true;
    }

    @Override
    public List<Funcionario> select() throws SQLException, Exception {
       //aplicando a regra de negocio / validações dos campos
        
        //chamando a classe de repositorio
        
        repositorio = new FuncionarioRepositorio();
        
        return repositorio.selectAll(); 
    }

    @Override
    public boolean updateStatusAtivo(int id) throws SQLException, Exception {
        
        repositorio = new FuncionarioRepositorio();
        
        return repositorio.updateStatusAtivo();
    }

    @Override
    public boolean updateStatusInativo(int id) throws SQLException, Exception {
        repositorio = new FuncionarioRepositorio();
        
        return repositorio.updateStatusInativo();
    }
    
   
    
    public void validarAtributos(Funcionario funcionario) throws Exception {
    
        validarMatricula(funcionario.getMatricula());
        validarSenha(funcionario.getSenha());
        validarTipo(funcionario.getTipo());
        validarFuncao(funcionario.getFuncao());
        
        if(funcionario.getMatricula()== null){
         throw new Exception(ExceptionMessage.Funcionario.MATRICULA_NAO_NULL);
        }
        if(funcionario.getMatricula().isEmpty()){
         throw new Exception(ExceptionMessage.Funcionario.MATRICULA_NAO_VAZIA);
        }
        if(funcionario.getSenha() == null){
         throw new Exception(ExceptionMessage.Funcionario.SENHA_NAO_NULL);
        }
        if(funcionario.getSenha().isEmpty()){
            throw  new Exception(ExceptionMessage.Funcionario.SENHA_NAO_VAZIA);
        }
        if(funcionario.getTipo() == 0){
            throw new Exception(ExceptionMessage.Funcionario.TIPO_IGUAL_ZERO);
        }
        if(funcionario.getFuncao() == null){
         throw new Exception(ExceptionMessage.Funcionario.FUNCAO_NAO_NULL);
        }
        if(funcionario.getFuncao().isEmpty()){
        throw new Exception(ExceptionMessage.Funcionario.FUNCAO_NAO_VAZIA);
        }
    
    }
    
    
    
    private void validarMatricula(String matricula) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarSenha(String senha) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarTipo(int tipo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void validarFuncao(String funcao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
