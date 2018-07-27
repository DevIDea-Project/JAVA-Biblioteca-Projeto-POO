/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Hyago
 * Created: 01/05/2018
 */

CREATE TABLE categoria (
id_categoria int PRIMARY KEY AUTO_INCREMENT,
nome varchar(20) NOT NULL
);

CREATE TABLE autor (
id_autor int PRIMARY KEY AUTO_INCREMENT,
nome varchar(50) NOT NULL,
biografia varchar(300),
nacionalidade varchar(20) NOT NULL
);

CREATE TABLE exemplar (
id_exemplar int PRIMARY KEY AUTO_INCREMENT,
id_livro int NOT NULL,
idioma varchar(10) NOT NULL
);

CREATE TABLE livro (
id_livro int PRIMARY KEY AUTO_INCREMENT,
id_categoria int NOT NULL,
id_autor int NOT NULL,
titulo varchar(30) NOT NULL,
lancamento date NOT NULL,
edicao varchar(2) NOT NULL,
isbn varchar(20) NOT NULL,
editora varchar(30) NOT NULL,
paginas int NOT NULL,
descricao varchar(300),
FOREIGN KEY(id_categoria) REFERENCES categoria (id_categoria),
FOREIGN KEY(id_autor) REFERENCES autor (id_autor)
);

CREATE TABLE usuario (
id_usuario int PRIMARY KEY AUTO_INCREMENT,
id_pessoa int NOT NULL,
status char(1) NOT NULL DEFAULT 'S',
CONSTRAINT CHK_status CHECK (status = 'S' OR status = 'N')
);

CREATE TABLE emprestimo (
id_emprestimo int PRIMARY KEY AUTO_INCREMENT,
matricula varchar(10) NOT NULL,
id_usuario int NOT NULL,
data_devolucao Date NOT NULL,
data_aquisicao Date NOT NULL,
data_entrega Date NOT NULL,
valor_multa decimal(7,2) NOT NULL,
FOREIGN KEY(id_usuario) REFERENCES usuario (id_usuario),
CONSTRAINT CHK_valor_multa CHECK (valor_multa > 0)
);

CREATE TABLE endereco (
id_endereco int PRIMARY KEY AUTO_INCREMENT,
logradouro varchar(100) NOT NULL,
cep varchar(9) NOT NULL,
numero varchar(10) NOT NULL,
uf char(2) NOT NULL,
cidade varchar(20) NOT NULL,
bairro varchar(20) NOT NULL
);

CREATE TABLE pessoa (
id_pessoa int PRIMARY KEY AUTO_INCREMENT,
id_endereco int NOT NULL,
cpf varchar(14) NOT NULL,
nome varchar(50) NOT NULL,
data_nascimento Date NOT NULL,
email varchar(100) NOT NULL,
genero char(1) NOT NULL,
telefone varchar(11) NOT NULL,
FOREIGN KEY(id_endereco) REFERENCES endereco (id_endereco)
);

CREATE TABLE funcionario (
matricula varchar(10) PRIMARY KEY NOT NULL,
senha varchar(50) NOT NULL,
id_pessoa int NOT NULL,
tipo int NOT NULL,
funcao varchar(10) NOT NULL,
FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa),
CONSTRAINT CHK_matricula CHECK (matricula <> '')
);

CREATE TABLE emprestimo_exemplar (
id_exemplar int NOT NULL,
id_emprestimo int NOT NULL,
FOREIGN KEY(id_exemplar) REFERENCES exemplar (id_exemplar),
FOREIGN KEY(id_emprestimo) REFERENCES emprestimo (id_emprestimo)
);

ALTER TABLE exemplar ADD FOREIGN KEY(id_livro) REFERENCES livro (id_livro);
ALTER TABLE usuario ADD FOREIGN KEY(id_pessoa) REFERENCES pessoa (id_pessoa);
ALTER TABLE emprestimo ADD FOREIGN KEY(matricula) REFERENCES funcionario (matricula);