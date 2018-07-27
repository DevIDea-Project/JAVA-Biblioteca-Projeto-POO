/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.negocio;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Pessoa;
import projeto_poo_grupo5.interfaces.CrudPessoaInterface;
import projeto_poo_grupo5.repositorio.PessoaRepositorio;
import projeto_poo_grupo5.validacao.ExceptionMessage;

/**
 *
 * @author Hyago
 */
public class PessoaNegocio implements CrudPessoaInterface {

    private final PessoaRepositorio pessoaRepositorio;

    public PessoaNegocio() {
        pessoaRepositorio = new PessoaRepositorio();
    }

    /**
     * Método responsável por realizar um novo registro do objeto pessoa.
     *
     * @param pessoa - objeto pessoa com as informações a serem inseridas.
     * @return - true caso tenha sucesso e false ccaso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public boolean insert(Pessoa pessoa) throws SQLException, Exception {
        if (pessoa.getEmail() == null) {
            throw new Exception(ExceptionMessage.Pessoa.EMAIL_NULL);
        }
        if (pessoa.getEmail().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.EMAIL_VAZIO);
        }
        if (pessoa.getGenero() == null) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_NULL);
        }
        if (pessoa.getGenero().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_VAZIO);
        }
        if (pessoa.getTelefone() == null) {
            throw new Exception(ExceptionMessage.Pessoa.TELEFONE_NULL);
        }
        if (pessoa.getTelefone().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.TELEFONE_VAZIO);
        }
        if (pessoa.getCpf() == null) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_NULL);
        }
        if (pessoa.getCpf().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_VAZIO);
        }
        if (pessoa.getCpf().length() != 14) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_TAMANHO_DIFERENTE_QUATORZE);
        }
        if (pessoa.getData_nascimento() == null) {
            throw new Exception(ExceptionMessage.Pessoa.DATA_NASCIMENTO_NULL);
        }
        if (pessoa.getEndereco().getIdendereco() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageEndereco.ID_IGUAL_ZERO);
        }
        if (pessoa.getNome() == null) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_NULL);
        }
        if (pessoa.getNome().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_VAZIO);
        }
        if (isCpfExistente(pessoa.getCpf())) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_EXISTENTE);
        }
        return pessoaRepositorio.insert(pessoa);
    }

    /**
     * Método responsável por atualizar as informações de um registro do objeto
     * pessoa.
     *
     * @param pessoa - objeto pessoa com as novas informações a serem
     * atualizadas.
     * @return - true caso tenha sucesso e false ccaso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public boolean update(Pessoa pessoa) throws SQLException, Exception {
        if (pessoa.getEmail() == null) {
            throw new Exception(ExceptionMessage.Pessoa.EMAIL_NULL);
        }
        if (pessoa.getEmail().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.EMAIL_VAZIO);
        }
        if (pessoa.getGenero() == null) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_NULL);
        }
        if (pessoa.getGenero().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_VAZIO);
        }
        if (pessoa.getTelefone() == null) {
            throw new Exception(ExceptionMessage.Pessoa.TELEFONE_NULL);
        }
        if (pessoa.getTelefone().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.TELEFONE_VAZIO);
        }
        if (pessoa.getCpf() == null) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_NULL);
        }
        if (pessoa.getCpf().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_VAZIO);
        }
        if (pessoa.getCpf().length() != 14) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_TAMANHO_DIFERENTE_QUATORZE);
        }
        if (pessoa.getData_nascimento() == null) {
            throw new Exception(ExceptionMessage.Pessoa.DATA_NASCIMENTO_NULL);
        }
        if (pessoa.getEndereco().getIdendereco() == 0) {
            throw new Exception(ExceptionMessage.ExceptionMessageEndereco.ID_IGUAL_ZERO);
        }
        if (pessoa.getNome() == null) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_NULL);
        }
        if (pessoa.getNome().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_VAZIO);
        }
        if (pessoa.getId_pessoa() == 0) {
            throw new Exception(ExceptionMessage.Pessoa.ID_IGUAL_ZERO);
        }
        if (isCpfExistente(pessoa.getCpf())) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_EXISTENTE);
        }
        return pessoaRepositorio.update(pessoa);
    }

    /**
     * Método responsável por remover as informações de um registro do objeto
     * pessoa.
     *
     * @param id - código identificador do registro do objeto no banco de dados.
     * @return - true caso tenha sucesso e false ccaso ocorra algum problema.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public boolean delete(int id) throws SQLException, Exception {
        if (id == 0) {
            throw new Exception(ExceptionMessage.Pessoa.ID_IGUAL_ZERO);
        }
        return pessoaRepositorio.delete(id);
    }

    /**
     * Método responsável por retornar uma lista contendo todos os registros de
     * objetos Pessoa no banco de dados.
     *
     * @return - Lista de objetos pessoa com base no resultado da consulta no
     * banco de dados.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public List<Pessoa> selectAll() throws SQLException, Exception {
        return pessoaRepositorio.selectAll();
    }

    /**
     * Método responsável por retornar uma lista contendo um ou mais objetos do
     * tipo Pessoa que contenham no nome a sequência de caracteres.
     *
     * @param nome - sequência de caracteres que representa o nome da pessoa a
     * ser buscada.
     * @return - Lista de objetos pessoa com base no resultado da consulta no
     * banco de dados.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public List<Pessoa> selectByNome(String nome) throws SQLException, Exception {
        if (nome == null) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_NULL);
        }
        if (nome.isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_VAZIO);
        }
        return pessoaRepositorio.selectByNome(nome);
    }

    /**
     * Método responsável por retornar uma lista contendo um ou mais objetos do
     * tipo Pessoa que contenham no nome a sequência de caracteres passada no
     * atributo nome do objeto e que tenham o gênero de acordo com o parâmetro
     * passado no atributo genero do objeto.
     *
     * @param pessoa - Objeto do tipo pessoa contendo o nome e o gênero para
     * utilizar como parâmetros da consulta.
     * @return - Lista de objetos pessoa com base no resultado da consulta no
     * banco de dados.
     * @throws SQLException - caso ocorra alguma exeção a mesma será levantada
     * para tratamento.
     */
    @Override
    public List<Pessoa> selectByNomeAndGenero(Pessoa pessoa) throws SQLException, Exception {
        if (pessoa.getNome() == null) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_NULL);
        }
        if (pessoa.getNome().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.NOME_VAZIO);
        }
        if (pessoa.getGenero() == null) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_NULL);
        }
        if (pessoa.getGenero().isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.GENERO_VAZIO);
        }
        return pessoaRepositorio.selectByNomeAndGenero(pessoa);
    }

    /**
     * Método responsável por verificar se um determinado cpf é existente na
     * base.
     *
     * @param cpf - sequência de caracteres que representam o cpf a ser
     * inserido.
     * @return caso o cpf passado por parâmetro exista na base será retornado o
     * valor boleano true, caso contrário retornará o false
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public boolean isCpfExistente(String cpf) throws SQLException, Exception {
        if (cpf != null) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_NULL);
        }
        if (cpf.isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_VAZIO);
        }
        return pessoaRepositorio.isCpfExistente(cpf);
    }

    /**
     * Método responsável por retornar o id de uma entidade pessoa inserida no
     * banco de dados com base em seu cpf
     *
     * @param cpf - sequência de caracteres que representam o cpf a ser
     * inserido.
     * @return número do tipo inteiro contendo o id da entidade pessoa que
     * possui o cpf informado.
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public int selectIdByCpf(String cpf) throws SQLException, Exception {
        if (cpf != null) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_NULL);
        }
        if (cpf.isEmpty()) {
            throw new Exception(ExceptionMessage.Pessoa.CPF_VAZIO);
        }
        return pessoaRepositorio.selectIdByCpf(cpf);
    }

}
