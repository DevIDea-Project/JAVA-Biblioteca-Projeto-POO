/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_poo_grupo5.validacao;

/**
 *
 * @author Hyago
 */
public interface ExceptionMessage {

    public final static String QUANTIDADE_CARACTERES_PERMITIDOS = " A quantidade de caracteres permitidas para esse campo é : ";

    public final static String ID_IGUAL_ZERO = " não pode ser igual a zero.";
    

    interface ExceptionMessageCategoria {

        /**
         * Mensagem para a exceção caso o nome da categoria seja null ou vazio.
         */
        public final static String NOME_CATEGORIA_NULL_OU_VAZIO = "O nome da categoria não pode ser null ou vazio.";

        /**
         * Mensagem para a exceção caso o id da categoria seja igual a zero.
         */
        public final static String ID_CATEGORIA_IGUAL_ZERO = "O id da categoria não pode ser zero.";

        /**
         * Mensagem para a exceção caso a flag status da categoria seja null ou
         * vazio.
         */
        public final static String STATUS_CATEGORIA_NULL_OU_VAZIO = "A flag ativo (status) da categoria não pode ser null ou vazio.";
    }

    interface ExceptionMessageLivro {

        public final static String CAMPO_LIVRO_VAZIO_NULL = " do livro não pode ser null ou vazio.";

        public final static String LIVRO_LIMITE_CARACTERES_EXCEDIDO = " do livro ultrapassou a quantidade de caracteres permitidos.";

        public final static String ID_IGUAL_ZERO = "O Id de livro não pode ser igual a zero";
    }

    interface ExceptionMessageUsuario {

        /**
         * Mensagem para a exceção caso o id de pessoa seja igual a zero.
         */
        public final static String ID_USUARIO_IGUAL_ZERO = "O id de usuario não pode ser zero.";

        /**
         * Mensagem para a exceção caso o id de pessoa seja igual a zero.
         */
        public final static String ID_PESSOA_IGUAL_ZERO = "O id de pessoa não pode ser zero.";

        /**
         * Mensagem para a exceção caso a flag status da categoria seja null ou
         * vazio.
         */
        public final static String STATUS_CATEGORIA_NULL_OU_VAZIO = "A flag ativo (status) de usuário não pode ser null ou vazio.";

    }

    interface ExceptionMessageEndereco {

        public final static String NULL_OU_VAZIO = " não pode ser nulo ou vazio";
        public final static String ID_IGUAL_ZERO = "O id de endereço não pode ser igual a zero";
        public final static String ID_NAO_EXISTE = "Id endereco não existe";

    }

    interface Pessoa {

        public final static String EMAIL_NULL = "O E-mail de pessoa não pode ser null";
        public final static String EMAIL_VAZIO = "O E-mail de pessoa não pode ser vazio";
        public final static String TELEFONE_NULL = "O Telefone de pessoa não pode ser null";
        public final static String TELEFONE_VAZIO = "O Telefone de pessoa não pode ser vazio";
        public final static String GENERO_NULL = "O Gênero de pessoa não pode ser null";
        public final static String GENERO_VAZIO = "O Gênero de pessoa não pode ser vazio";
        public final static String CPF_TAMANHO_DIFERENTE_QUATORZE = "O CPF de pessoa precisa ter exatamente 14 caracteres";
        public final static String CPF_NULL = "O CPF de pessoa não pode ser null";
        public final static String CPF_VAZIO = "O CPF de pessoa não pode ser vazio";
        public final static String DATA_NASCIMENTO_NULL = "A data de nascimento de pessoa não pode ser null";
        public final static String NOME_VAZIO = "O Nome de pessoa não pode ser vazio";
        public final static String NOME_NULL = "O Nome de pessoa não pode ser null";
        public final static String ID_IGUAL_ZERO = "O Id de pessoa não pode ser igual a zero";
        public final static String CPF_EXISTENTE = "O CPF de pessoa já está cadastrado na base";
    }

    interface Exemplar {

        public final static String ID_IGUAL_ZERO = "O Id de exemplar não pode ser igual a zero";
        public final static String IDIOMA_VAZIO = "O Idioma de exemplar não pode ser vazio";
        public final static String IDIOMA_NULL = "O Idioma de exemplar não pode ser null";
    }
    
    interface Funcionario {
    public final static String MATRICULA_NAO_NULL = "Matricula do funcionario não pode ser Nula.";
    public final static String MATRICULA_NAO_VAZIA = "Matricula do funcionario não pode ser Vazia.";
    public final static String SENHA_NAO_NULL = "Senha do funcionario não pode ser Nula.";
    public final static String SENHA_NAO_VAZIA = "Senha do funcionario nao pode ser Vazia.";
    public final static String TIPO_IGUAL_ZERO = "Senha do funcionario nao pode ser Vazia.";
    public final static String FUNCAO_NAO_NULL = "Senha do funcionario nao pode ser Vazia.";
    public final static String FUNCAO_NAO_VAZIA = "Senha do funcionario nao pode ser Vazia.";
     }
}
