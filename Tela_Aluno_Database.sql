CREATE DATABASE appEscola;
USE appEscola;

CREATE TABLE endereco(
	idEndereco INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	endereco VARCHAR(255) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    bairro VARCHAR(255) NOT NULL,
    cidade VARCHAR(255) NOT NULL,
    numero INT NOT NULL);

CREATE TABLE pessoa(
	idPessoa INT NOT NULL AUTO_INCREMENT,
    idEndereco INT NOT NULL,
	nome VARCHAR(255) NOT NULL UNIQUE,
    cpf VARCHAR(14) NOT NULL UNIQUE, # XXX.XXX.XXX-XX
    rg CHAR(50) NOT NULL UNIQUE, 
    telefone VARCHAR(19) NOT NULL UNIQUE, # XX (XXX) XXXXX-XXXX
    email VARCHAR(255) NOT NULL UNIQUE,
    deficiencia VARCHAR(255),
    nacionalidade VARCHAR(255) NOT NULL,
	genero ENUM("MASCULINO", "FEMININO", "OUTRO") NOT NULL,
    estadoCivil ENUM("SOLTEIRO", "CASADO", "DIVORCIADO") NOT NULL,
    cor ENUM("PRETO", "PARDO", "BRANCO", "INDIGENA", "AMARELO") NOT NULL,
    PRIMARY KEY(idPessoa, cpf, email, rg),
    FOREIGN KEY(idEndereco) REFERENCES endereco (idEndereco));
    
CREATE TABLE login(
	idLogin INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipoLogin ENUM("PROFESSOR", "ESTUDANTE", "ADMINISTRADOR") NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL);

CREATE TABLE estudante(
	idLogin INT NOT NULL,
	idPessoa INT NOT NULL,
    idEndereco INT NOT NULL,
	idEstudante INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    curso VARCHAR(255) NOT NULL,
    periodo ENUM("MATUTINO", "VESPERTINO", "NOTURNO") NOT NULL,
    escolaridade ENUM("FUNDAMENTAL", "MEDIO", "SUPERIOR") NOT NULL,
    dataInscricao DATE NOT NULL,
    dataNascimento DATE NOT NULL,
    trabalha BOOL NOT NULL,
    nomeResponsavel VARCHAR(255),
    frequencia DOUBLE,
    FOREIGN KEY (idPessoa) REFERENCES pessoa (idPessoa),
    FOREIGN KEY (idLogin) REFERENCES login (idLogin),
    FOREIGN KEY (idEndereco) REFERENCES endereco (idEndereco));

CREATE TABLE trimestre(
	idTrimestre INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	p1 DOUBLE,
    p2 DOUBLE,
    media DOUBLE);

CREATE TABLE boletim(
	idBoletim INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idEstudante INT NOT NULL,
	idTrimestre1 INT NOT NULL,
    idTrimestre2 INT NOT NULL,
    idTrimestre3 INT NOT NULL,
    mediaFinal DOUBLE,
    FOREIGN KEY (idEstudante) REFERENCES estudante(idEstudante),
    FOREIGN KEY (idTrimestre1) REFERENCES trimestre(idTrimestre),
    FOREIGN KEY (idTrimestre2) REFERENCES trimestre(idTrimestre),
    FOREIGN KEY (idTrimestre3) REFERENCES trimestre(idTrimestre));

CREATE TABLE professor(
	idLogin INT NOT NULL,
	idPessoa INT NOT NULL,
	idProfessor INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    formacao VARCHAR(512) NOT NULL,
    historicoProfissional VARCHAR(512) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES pessoa (idPessoa),
    FOREIGN KEY (idLogin) REFERENCES login (idLogin));

CREATE TABLE turma(
	idTurma INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	periodo ENUM("MATUTINO", "VESPERTINO", "NOTURNO") NOT NULL,
    idProfessor INT NOT NULL,
    idEstudante INT NOT NULL,
    FOREIGN KEY (idProfessor) REFERENCES professor (idProfessor),
    FOREIGN KEY (idEstudante) REFERENCES estudante (idEstudante));
        
CREATE TABLE ocorrencia(
	idOcorrencia INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    tipoOcorrencia VARCHAR(255) NOT NULL,
	idPessoa INT NOT NULL,
    mostrarNome BOOL NOT NULL,
    dataBO DATE NOT NULL,
    horaBO VARCHAR(50) NOT NULL,
    dataOcorrencia VARCHAR(255) NOT NULL,
    localOcorrencia VARCHAR(255) NOT NULL,
    autorOcorrencia VARCHAR(255) NOT NULL,
    vitimaOcorrencia VARCHAR(255) NOT NULL,
    descricao VARCHAR(512) NOT NULL,
    FOREIGN KEY (idPessoa) REFERENCES pessoa(idPessoa));
    
CREATE TABLE carteiraEstudante(
	idEstudante INT NOT NULL,
    FOREIGN KEY (idEstudante) REFERENCES estudante (idEstudante));
    
CREATE TABLE solicitacao(
	idSolicitacao INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    dataSolicitacao DATE NOT NULL,
    idEstudante INT NOT NULL,
	descricao VARCHAR(512) NOT NULL,
    FOREIGN KEY (idEstudante) REFERENCES estudante(idEstudante));
    
CREATE TABLE diario(
	idDiario INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    idProfessor INT NOT NULL,
    descricao VARCHAR(512),
    FOREIGN KEY (idProfessor) REFERENCES professor(idProfessor));
    
CREATE TABLE nota (
	idNota INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    idEstudante INT,
	FOREIGN KEY (idEstudante) REFERENCES estudante(idEstudante),
	disciplinaNota ENUM("Artes", "Biologia", "Ed. Física",
		"Filosofia", "Física", "Geografia", "História", "Inglês",
		"Literatura", "Mat", "Português", "Química", "Sociologia") NOT NULL,
	tipoNota ENUM("Trabalho", "Avaliação", "Recuperação", "Bônus") NOT NULL,
    dataNota DATE NOT NULL,
    trimestre ENUM ("1º Tri", "2º Tri", "3º Tri"),
    nota DOUBLE NOT NULL
);

CREATE TABLE faltas (
	idFalta int primary key not null auto_increment,
    idEstudante int,
    disciplinaFalta ENUM("Artes", "Biologia", "Ed. Física",
		"Filosofia", "Física", "Geografia", "História", "Inglês",
		"Literatura", "Mat", "Português", "Química", "Sociologia") NOT NULL,
    dataFalta DATE NOT NULL,
    trimestre ENUM ("1º Tri", "2º Tri", "3º Tri")
);