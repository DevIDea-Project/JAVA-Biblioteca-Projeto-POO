/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Categoria;
import projeto_poo_grupo5.repositorio.CategoriaRepositorio;
import projeto_poo_grupo5.interfaces.CrudCategoriaInterface;
import projeto_poo_grupo5.interfaces.GenericaInterface;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author Hyago
 */
public class CategoriaNegocio implements CrudCategoriaInterface, GenericaInterface {

    private CategoriaRepositorio categoriaRepositorio = null;

    /**
     *  Construtor da classe CategoriaNegocio
     */
    public CategoriaNegocio() {
        categoriaRepositorio = new CategoriaRepositorio();
    }

    /**
     * Método responsável por realizar a inserção do objeto categoria.
     * @param categoria - objeto categoria a ser inserido
     * @return - true caso a inserção tenha sucesso e false caso ocorra algum problema
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento
     */
    @Override
    public boolean insert(Categoria categoria) throws SQLException, Exception {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.NOME_CATEGORIA_NULL_OU_VAZIO);
        } else {
            return categoriaRepositorio.insert(categoria);
        }
    }

    /**
     * Método responsável por realizar a atualização de informações do objeto categoria.
     * @param categoria - objeto categoria a ser atualizado, necessário o id da categoria informado para identificação
     * @return - true caso a atualização tenha sucesso e false caso ocorra algum problema
     * @throws SQLException - caso ocorra uma exceção ela será levantada para tratamento
     */
    @Override
    public boolean update(Categoria categoria) throws SQLException, Exception {
        if (categoria.getNome() == null || categoria.getNome().isEmpty()) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.NOME_CATEGORIA_NULL_OU_VAZIO);
        } else if (categoria.getId() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.ID_CATEGORIA_IGUAL_ZERO);
        } else {
            return categoriaRepositorio.update(categoria);
        }
    }

    /**
     * método responsável por realizar a remoção do registro de uma categoria específica.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso seja removido com sucesso e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean delete(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.ID_CATEGORIA_IGUAL_ZERO);
        } else {
            return categoriaRepositorio.delete(id);
        }
        
    }

    /**
     * Método responsável por realizar a consulta de todas as categorias registradas no banco de dados, independentemente de status.
     * @return - lista com todos os objetos categoria contidos no banco de dados.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Categoria> selectAll() throws SQLException, Exception {
        return categoriaRepositorio.selectAll();
    }

    /**
     * Método responsável por realizar a consulta de uma categoria específica com base no id passado.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - objeto categoria com as informações obtidas da consulta.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public Categoria selectById(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.ID_CATEGORIA_IGUAL_ZERO);
        } else {
            return categoriaRepositorio.selectById(id);
        }
    }

    /**
     * Método responsável por atualizar o status da categoria para ativo.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusAtivo(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.ID_CATEGORIA_IGUAL_ZERO);
        } else {
            return categoriaRepositorio.updateStatusAtivo(id);
        }
    }

    /**
     * Método responsável por atualizar o status da categoria para inativo.
     * @param id - código identificador da categoria, pode ser obtido pelo método getId do objeto Categoria.
     * @return - true caso tenha sucesso na atualização de status e false caso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public boolean updateStatusInativo(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.ID_CATEGORIA_IGUAL_ZERO);
        } else {
            return categoriaRepositorio.updateStatusInativo(id);
        }
    }

    /**
     * Método responsável por realizar a consulta de categorias com base no nome e no status passado. 
     * @param categoria - objeto categoria com as informações de nome e status para usar como restrição da consulta.
     * @return - lista de categorias contendo os resultados obtidos da consulta.
     * @throws SQLException - caso ocorra alguma exceção, a mesma será levantada para tratamento.
     */
    @Override
    public List<Categoria> selectByNameAndStatus(Categoria categoria) throws SQLException, Exception {
        if(categoria.getNome() == null || categoria.getNome().isEmpty()){
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.NOME_CATEGORIA_NULL_OU_VAZIO);
        }else if (String.valueOf(categoria.getAtivo()) == null || String.valueOf(categoria.getAtivo()).isEmpty()){
            throw new Exception(ExceptionMessage.ExceptionMessageCategoria.STATUS_CATEGORIA_NULL_OU_VAZIO);
        }else{
            return categoriaRepositorio.selectByNameAndStatus(categoria);
        }
    }

}
