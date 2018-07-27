/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import projeto_poo_grupo5.basica.Pessoa;
import projeto_poo_grupo5.interfaces.CrudPessoaInterface;
import projeto_poo_grupo5.util.banco.Conexao;

/**
 *
 * @author Beto
 */
public class PessoaRepositorio implements CrudPessoaInterface {

    Conexao conexao = null;

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
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "INSERT INTO pessoa(cpf,nome,data_nascimento,email,genero,telefone,id_endereco)"
                + " VALUES (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pessoa.getCpf());
        preparedStatement.setString(2, pessoa.getNome());
        preparedStatement.setDate(3, pessoa.getData_nascimento());
        preparedStatement.setString(4, pessoa.getEmail());
        preparedStatement.setString(5, pessoa.getGenero());
        preparedStatement.setString(6, pessoa.getTelefone());
        preparedStatement.setInt(7, pessoa.getEndereco().getIdendereco());

        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
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
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "UPDATE pessoa SET cpf = ?, nome = ?, data_nascimento = ?,"
                + "email = ? ,genero = ? ,telefone = ? ,id_endereco= ?"
                + " WHERE id_pessoa = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, pessoa.getCpf());
        preparedStatement.setString(2, pessoa.getNome());
        preparedStatement.setDate(3, pessoa.getData_nascimento());
        preparedStatement.setString(4, pessoa.getEmail());
        preparedStatement.setString(5, pessoa.getGenero());
        preparedStatement.setString(6, pessoa.getTelefone());
        preparedStatement.setInt(7, pessoa.getEndereco().getIdendereco());
        preparedStatement.setInt(8, pessoa.getId_pessoa());

        preparedStatement.executeUpdate();
        conexao.Desconectar();
        return true;
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
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "DELETE FROM pessoa WHERE id_pessoa = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        preparedStatement.execute();
        conexao.Desconectar();
        return true;

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
        List<Pessoa> pessoas = new ArrayList<>();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT "
                + "p.id_pessoa,p.cpf,p.nome,p.data_nascimento,p.email,p.genero,p.telefone,"
                + "e.id_endereco,e.logradouro,e.cep,e.numero,e.uf,e.cidade,e.bairro "
                + "FROM pessoa AS p "
                + "INNER JOIN endereco AS e ON "
                + "e.id_endereco = p.id_endereco";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultPessoa = preparedStatement.executeQuery();
        while (resultPessoa.next()) {
            Pessoa p = new Pessoa();
            p.setCpf(resultPessoa.getString("cpf"));
            p.setEmail(resultPessoa.getString("email"));
            p.setGenero(resultPessoa.getString("genero"));
            p.setId_pessoa(resultPessoa.getInt("id_pessoa"));
            p.setNome(resultPessoa.getString("nome"));
            p.setTelefone(resultPessoa.getString("telefone"));
            p.getEndereco().setIdendereco(resultPessoa.getInt("id_endereco"));
            p.getEndereco().setLogradouro(resultPessoa.getString("logradouro"));
            p.getEndereco().setNumero(resultPessoa.getString("numero"));
            p.getEndereco().setBairro(resultPessoa.getString("bairro"));
            p.getEndereco().setCep(resultPessoa.getString("cep"));
            p.getEndereco().setCidade(resultPessoa.getString("cidade"));
            p.getEndereco().setUf(resultPessoa.getString("uf"));
            pessoas.add(p);
        }

        conexao.Desconectar();
        return pessoas;
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
        List<Pessoa> pessoas = new ArrayList<>();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT "
                + "p.id_pessoa,p.cpf,p.nome,p.data_nascimento,p.email,p.genero,p.telefone,"
                + "e.id_endereco,e.logradouro,e.cep,e.numero,e.uf,e.cidade,e.bairro "
                + "FROM pessoa AS p "
                + "INNER JOIN endereco AS e ON "
                + "e.id_endereco = p.id_endereco"
                + "WHERE p.nome LIKE ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + nome + "%");

        ResultSet resultPessoa = preparedStatement.executeQuery();
        while (resultPessoa.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setCpf(resultPessoa.getString("cpf"));
            pessoa.setEmail(resultPessoa.getString("email"));
            pessoa.setGenero(resultPessoa.getString("genero"));
            pessoa.setId_pessoa(resultPessoa.getInt("id_pessoa"));
            pessoa.setNome(resultPessoa.getString("nome"));
            pessoa.setTelefone(resultPessoa.getString("telefone"));
            pessoa.getEndereco().setIdendereco(resultPessoa.getInt("id_endereco"));
            pessoa.getEndereco().setLogradouro(resultPessoa.getString("logradouro"));
            pessoa.getEndereco().setNumero(resultPessoa.getString("numero"));
            pessoa.getEndereco().setBairro(resultPessoa.getString("bairro"));
            pessoa.getEndereco().setCep(resultPessoa.getString("cep"));
            pessoa.getEndereco().setCidade(resultPessoa.getString("cidade"));
            pessoa.getEndereco().setUf(resultPessoa.getString("uf"));

            pessoas.add(pessoa);
        }

        conexao.Desconectar();
        return pessoas;
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
        List<Pessoa> pessoas = new ArrayList<>();
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT "
                + "p.id_pessoa,p.cpf,p.nome,p.data_nascimento,p.email,p.genero,p.telefone,"
                + "e.id_endereco,e.logradouro,e.cep,e.numero,e.uf,e.cidade,e.bairro "
                + "FROM pessoa AS p "
                + "INNER JOIN endereco AS e ON "
                + "e.id_endereco = p.id_endereco"
                + "WHERE p.nome LIKE ? AND genero = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, "%" + pessoa.getNome() + "%");
        preparedStatement.setString(2, pessoa.getGenero());

        ResultSet resultPessoa = preparedStatement.executeQuery();
        while (resultPessoa.next()) {
            Pessoa p = new Pessoa();
            p.setCpf(resultPessoa.getString("cpf"));
            p.setEmail(resultPessoa.getString("email"));
            p.setGenero(resultPessoa.getString("genero"));
            p.setId_pessoa(resultPessoa.getInt("id_pessoa"));
            p.setNome(resultPessoa.getString("nome"));
            p.setTelefone(resultPessoa.getString("telefone"));
            p.getEndereco().setIdendereco(resultPessoa.getInt("id_endereco"));
            p.getEndereco().setLogradouro(resultPessoa.getString("logradouro"));
            p.getEndereco().setNumero(resultPessoa.getString("numero"));
            p.getEndereco().setBairro(resultPessoa.getString("bairro"));
            p.getEndereco().setCep(resultPessoa.getString("cep"));
            p.getEndereco().setCidade(resultPessoa.getString("cidade"));
            p.getEndereco().setUf(resultPessoa.getString("uf"));

            pessoas.add(p);
        }

        conexao.Desconectar();
        return pessoas;
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
        boolean exists = false;
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT cpf FROM pessoa WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet resultPessoa = preparedStatement.executeQuery();
        if (resultPessoa.next()) {
            if (resultPessoa.getString("cpf") != null) {
                exists = true;
            }
        }

        conexao.Desconectar();
        return exists;
    }

    /**
     * Método responsável por retornar o id de uma entidade pessoa inserida no
     * banco de dados com base em seu cpf
     *
     * @param cpf - sequência de caracteres que representam o cpf a ser inserido.
     * @return número do tipo inteiro contendo o id da entidade pessoa que possui o cpf informado.
     * @throws SQLException
     * @throws Exception
     */
    @Override
    public int selectIdByCpf(String cpf) throws SQLException, Exception {
        int id = 0;
        conexao = Conexao.getInstance();
        Connection connection = conexao.Conectar();

        String sql = "SELECT id_pessoa FROM pessoa WHERE cpf = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, cpf);

        ResultSet resultPessoa = preparedStatement.executeQuery();
        if (resultPessoa.next()) {
            id = resultPessoa.getInt("id");
        }
        conexao.Desconectar();
        return id;
    }

}
