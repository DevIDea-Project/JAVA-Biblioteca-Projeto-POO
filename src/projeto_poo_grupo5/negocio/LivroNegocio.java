/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Livro;
import projeto_poo_grupo5.interfaces.CrudLivroInterface;
import projeto_poo_grupo5.repositorio.LivroRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author Beto
 */
public class LivroNegocio implements CrudLivroInterface{

    LivroRepositorio repositorio = null;
    
    @Override
    public boolean insert(Livro livro) throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos
        
        //Metodo para validar campo nulos ou vazios
        validarCamposNullVazios(livro, true);
        
        //Metodo para validar campos excedendo quantidade de caracteres
        quantidadeCaracteresPermitidos(livro);
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        repositorio.insert(livro);
        return true;
    }

    @Override
    public boolean update(Livro livro) throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos
        
        //Metodo para validar campo nulos ou vazios
        validarCamposNullVazios(livro, false);
        
        //Metodo para validar campos excedendo quantidade de caracteres
        quantidadeCaracteresPermitidos(livro);
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        repositorio.update(livro);
        return true;
    }

    @Override
    public boolean delete(Livro livro) throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos
        
        //Metodo para validar campo nulos ou vazios
        validarCamposNullVazios(livro, true);
        
        //Metodo para validar campos excedendo quantidade de caracteres
        quantidadeCaracteresPermitidos(livro);        
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        repositorio.delete(livro);
        return true;
    }

    @Override
    public List<Livro> selectAll() throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        return repositorio.selectAll();
        
    }

    @Override
    public List<Livro> selectByTitulo(Livro livro) throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos
        
        validarTituloVazioNull(livro);
        validarTituloLivroQtdCaracteres(livro);
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        return repositorio.selectByTitulo(livro);
    }

    @Override
    public boolean verificarDuplicidade(Livro livro) throws SQLException, Exception {
        //aplicando a regra de negocio / validações dos campos

        validarTituloVazioNull(livro);
        validarTituloLivroQtdCaracteres(livro);
        
        //chamando a classe de repositorio
        repositorio = new LivroRepositorio();
        return repositorio.verificarDuplicidade(livro);
    }
    
    private boolean validarCamposNullVazios(Livro livro , boolean insert) throws Exception{
        
        // region validações de valores nulos ou vazios
        
        if (!insert) {
            if(livro.getId_livro() == 0 ) {
                throw new Exception(" Id do livro"+ExceptionMessage.ID_IGUAL_ZERO);
            }
        }
        
        if (livro.getAutor().getId_autor() == 0) {
            throw new Exception(" Id do autor"+ExceptionMessage.ID_IGUAL_ZERO);
        }
        
        if (livro.getCategoria().getId() == 0) {
            throw new Exception(" Id da categoria"+ExceptionMessage.ID_IGUAL_ZERO);
        }
        
        validarTituloVazioNull(livro);
        
        if (livro.getLancamento().equals("") || livro.getLancamento()== null) {
            throw new Exception("Lançamento" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL);
        }
        
        if (livro.getEdicao().equals("") || livro.getEdicao()== null) {
            throw new Exception("Edição" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL);
        }
        
        if (livro.getIsbn().equals("") || livro.getIsbn()== null) {
            throw new Exception("Isbn" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL);
        }
        
        if (livro.getEditora().equals("") || livro.getEditora()== null) {
            throw new Exception("Editora" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL);
        }
        
        if (livro.getPaginas() == 0 ) {
            throw new Exception(" Quantidade de páginas"+ExceptionMessage.ID_IGUAL_ZERO);
        }
        
        if (livro.getDescricao().equals("") || livro.getDescricao()== null) {
            throw new Exception(" Descrição" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL);
        }
        
        return true;
    }
    
    private boolean quantidadeCaracteresPermitidos(Livro livro) throws Exception{
        
        validarTituloLivroQtdCaracteres(livro);
              
        if (livro.getEdicao().length()>2) {
            String msgException = new StringBuilder().append("Edição")
                    .append(ExceptionMessage.ExceptionMessageLivro.LIVRO_LIMITE_CARACTERES_EXCEDIDO)
                    .append(ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS)
                    .append(2).toString();

            throw new Exception(msgException);
        }
        
        if (livro.getIsbn().length()>20) {
            String msgException = new StringBuilder().append("O Isbn")
                    .append(ExceptionMessage.ExceptionMessageLivro.LIVRO_LIMITE_CARACTERES_EXCEDIDO)
                    .append(ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS)
                    .append(20).toString();

            throw new Exception(msgException);
        }
        
        if (livro.getEditora().length()>30) {
            String msgException = new StringBuilder().append("Editora")
                    .append(ExceptionMessage.ExceptionMessageLivro.LIVRO_LIMITE_CARACTERES_EXCEDIDO)
                    .append(ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS)
                    .append(30).toString();

            throw new Exception(msgException);
        }

        if (livro.getDescricao().length()>300) {
            String msgException = new StringBuilder().append("Descrição")
                    .append(ExceptionMessage.ExceptionMessageLivro.LIVRO_LIMITE_CARACTERES_EXCEDIDO)
                    .append(ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS)
                    .append(300).toString();

            throw new Exception(msgException);
        }
        
        return true;
    }
    
    private boolean validarTituloLivroQtdCaracteres(Livro livro) throws Exception{
        
        if (livro.getTitulo().length()>30) {
            
            String msgException = new StringBuilder().append("Título")
                    .append(ExceptionMessage.ExceptionMessageLivro.LIVRO_LIMITE_CARACTERES_EXCEDIDO)
                    .append(ExceptionMessage.QUANTIDADE_CARACTERES_PERMITIDOS)
                    .append(30).toString();

            throw new Exception(msgException);
        }
        
        return true;
    }
    
    private boolean validarTituloVazioNull(Livro livro) throws Exception{
        
        if (livro.getTitulo().equals("") || livro.getTitulo()== null) {
            throw new Exception("Titulo" + ExceptionMessage.ExceptionMessageLivro.CAMPO_LIVRO_VAZIO_NULL );
        }
        
        return true;
    }
}
