SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";

--
-- Banco de dados: `livraria`
--
-- --------------------------------------------------------
--
-- Estrutura da tabela `cliente`
--
create schema livrarian211;

use livrarian211;

--
-- Estrutura da tabela `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(11) NOT NULL auto_increment primary key,
  `nomeCliente` varchar(45) NOT NULL,
  `cpf` varchar(20) DEFAULT NULL,
  `cnpj` varchar(20) DEFAULT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(20) NOT NULL  
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Estrutura da tabela `editora`
--

CREATE TABLE `editora` (
  `idEditora` int(11) NOT NULL auto_increment primary key,
  `nmEditora` varchar(45) NOT NULL,
  `endereco` varchar(60) NOT NULL,
  `telefone` varchar(11) NOT NULL,
  `gerente` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Estrutura da tabela `livro`
--

CREATE TABLE `livro` (
  `idLivro` int(11) NOT NULL auto_increment primary key,
  `titulo` varchar(45) NOT NULL,
  `autor` varchar(45) NOT NULL,
  `assunto` varchar(45) NOT NULL,
  `isbn` varchar(13) NOT NULL unique,
  `estoque` int(11) NOT NULL,
  `preco` decimal(10,2) NOT NULL,
  `idEditora` int(11) NOT NULL,
  foreign key (idEditora) references editora(idEditora)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Estrutura da tabela `compra`
--

CREATE TABLE `vendaLivro` (
  `idCliente` int(11) NOT NULL auto_increment primary key,
  `idLivro` int(11) NOT NULL,
  `qtd` int(11) NOT NULL,
  `subTotal` decimal(10,2) NOT NULL,
  `dataCompra` date NOT NULL,
foreign key (idCliente) references cliente(idCliente),
foreign key (idLivro) references livro(idLivro)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;




/*
 SELECT * FROM cliente LIMIT 100;
INSERT INTO cliente VALUES (null, 'nome pachio', 'rua do goleiro', '5132658978', '97506761068', '');
INSERT INTO cliente VALUES (null, 'jonatis', '9715482615', 'null', 'Rua yt', '5156895689');

INSERT INTO livro VALUES (null, 'titulo 1', 'robert do 1', 'O livro 1', 124578, 100, 2.0, 0);

INSERT INTO editora VALUES (null, 'Editoras1', 'end da edit 1', '513454578', 'gerente da 1');
INSERT INTO editora VALUES (null, 'Editoras2', 'end da edit 2', '517854578', 'gerente da 2');
INSERT INTO editora VALUES (null, 'Editoras3', 'end da edit 3', '5132654578', 'gerente da 3');

*/
