/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5;

import java.sql.SQLException;
import java.util.List;
import projeto_poo_grupo5.basica.Categoria;
import projeto_poo_grupo5.repositorio.CategoriaRepositorio;

/**
 *
 * @author Hyago
 */
public class Projeto_POO_Grupo5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        //testarSelectPessoa();
        //testarInsertPessoa();
        //testarUpdatePessoa();
        //testarDeletePessoa();
        //testarInsertCategoria();
        //testarUpdateCategoria();
        testarSelectCategoria();
    }

    /* private static void testarConexao(){
        
        Conexao conexao = Conexao.getInstance();
        
        try {
            
            Connection connection = conexao.Conectar();
            
            System.err.println("Conectou");
            
            conexao.Desconectar();
            
            System.err.println("desconectou");
            
        } catch (SQLException ex) {
            System.err.println("Deu pau");
        }
        
    }*/
 /*private static void testarSelectPessoa(){
        
        Pessoa pessoa = new Pessoa();
        
        pessoa.setId_pessoa(4);
        
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();
        
        try {
            java.util.List<Pessoa> pessoas = new ArrayList<>();
            
            pessoas = pessoaRepositorio.select();
            
            for (Pessoa pessoa1 : pessoas) {
                System.out.println("Nome: "+ pessoa1.getNome());
            }
            
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar selecionar pessoas");
            
        }
        
    }*/
 /*private static void testarInsertPessoa(){
        
        Pessoa pessoa = new Pessoa();
        
        Date d = new Date(100000);
        
        pessoa.setCpf("998887878");
        pessoa.setData_nascimento(d);
        pessoa.setEmail("teste@email.com");
        pessoa.setGenero("M");
        pessoa.setNome("teste123");
        pessoa.setTelefone("12312312");
        // para teste só temos o endereco de id 1
        pessoa.getEndereco().setIdendereco(1);
        
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();
        
        try {
            pessoaRepositorio.insert(pessoa);
            System.out.println("Pessoa inserida com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar inserir pessoa");
        }
        
    }*/
 /*private static void testarUpdatePessoa(){
        
        Pessoa pessoa = new Pessoa();
        
        Date d = new Date(100000);
        
        //sempre colocar um id que existe no banco
        pessoa.setId_pessoa(5);
        pessoa.setCpf("555555555");
        pessoa.setData_nascimento(d);
        pessoa.setEmail("teste5555@email.com");
        pessoa.setGenero("M");
        pessoa.setNome("teste55555555");
        pessoa.setTelefone("52525252");
        // para teste só temos o endereco de id 1
        pessoa.getEndereco().setIdendereco(1);
        
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();
        
        try {
            pessoaRepositorio.update(pessoa);
            System.out.println("Pessoa atualizada com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar atualizar pessoa");
        }
        
    }*/
 /*private static void testarDeletePessoa(){
        
        Pessoa pessoa = new Pessoa();
        
        // *** sempre colocar um id que existe no banco ***
        // precisamos apenas passar id, já que estamos testando apenas o delete
        pessoa.setId_pessoa(5);
        
        PessoaRepositorio pessoaRepositorio = new PessoaRepositorio();
        
        try {
            pessoaRepositorio.delete(pessoa);
            System.out.println("Pessoa deletada com sucesso.");
        } catch (SQLException ex) {
            System.out.println("Erro ao tentar deletar pessoa");
        }
        
    }*/
    private static void testarInsertCategoria() {
        Categoria c = new Categoria();
        c.setNome("Terror");
        CategoriaRepositorio cr = new CategoriaRepositorio();
        try {
            cr.insert(c);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void testarUpdateCategoria() {
        Categoria c = new Categoria();
        c.setId(1);
        c.setNome("Suspense");
        c.setAtivo('N');
        CategoriaRepositorio cr = new CategoriaRepositorio();
        try {
            cr.update(c);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    private static void testarSelectCategoria() {
        CategoriaRepositorio cr = new CategoriaRepositorio();
        try {
            List<Categoria> listc = cr.selectAll();
            listc.forEach((c) -> {
                System.out.println("ID: "+c.getId()+" - Nome: "+c.getNome());
            });
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
