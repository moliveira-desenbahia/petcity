DROP SCHEMA IF EXISTS petcity;
CREATE SCHEMA petcity;

USE petcity;

SET NAMES utf8mb4;

-- TABLES
CREATE TABLE usuario (
	id integer NOT NULL AUTO_INCREMENT,
	email  varchar(100) NOT NULL,
	senha  varchar(50) NOT NULL,
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE pessoa (
	id integer NOT NULL AUTO_INCREMENT,
	nome varchar(100),
	tipo varchar(1),
	usuario_id integer,
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
)ENGINE=InnoDB;

/*  Pet */
CREATE TABLE pelagem(
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(255),
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE porte(
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(255),
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)ENGINE=InnoDB; 

CREATE TABLE especie(
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(255),
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id)
)ENGINE=InnoDB;

CREATE TABLE raca(
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(255),
  especie_id integer,
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (especie_id) REFERENCES especie(id)
)ENGINE=InnoDB;
 
CREATE TABLE pet (
  id integer NOT NULL AUTO_INCREMENT,
  nome varchar(255),
  raca_id integer,
  pelagem_id integer,
  porte_id integer,
  situacao varchar(2),
  pessoaresponsavel_id integer,
  disponivel_adocao boolean NOT NULL DEFAULT false,
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (raca_id) REFERENCES raca(id),
  FOREIGN KEY (pelagem_id) REFERENCES pelagem(id),
  FOREIGN KEY (porte_id) REFERENCES porte(id),
  FOREIGN KEY (pessoaresponsavel_id) REFERENCES pessoa(id)
)ENGINE=InnoDB;
/* ^^ Pet ^^*/



CREATE TABLE caracteristicas_adicionais (
  id integer NOT NULL AUTO_INCREMENT,
  pet_id integer NOT NULL,
  descricao varchar(255),
  confirmada boolean NOT NULL DEFAULT false,
  usuario_id integer,
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (pet_id) REFERENCES pet(id),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id)

)ENGINE=InnoDB;

CREATE TABLE tipoocorrencia (
	id integer NOT NULL AUTO_INCREMENT,
	nome varchar(255),
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id)
)ENGINE=InnoDB;

CREATE TABLE alerta (
	id integer NOT NULL AUTO_INCREMENT,
	descricao varchar(255),
	usuario_id integer,
	tipoocorrencia_id integer,
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id),
	FOREIGN KEY (tipoocorrencia_id) REFERENCES tipoocorrencia(id)
)ENGINE=InnoDB;

CREATE TABLE ocorrencia (
	id integer NOT NULL AUTO_INCREMENT,
	descricao varchar(255),
	pet_id integer,
	usuario_id integer,
	tipoocorrencia_id integer,
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id),
	FOREIGN KEY (tipoocorrencia_id) REFERENCES tipoocorrencia(id),
    FOREIGN KEY (pet_id) REFERENCES pet(id)
)ENGINE=InnoDB;

CREATE TABLE localizacaopet (
  id integer NOT NULL AUTO_INCREMENT,
  pet_id integer NOT NULL,
  latitude  decimal NOT NULL,
  longitude  decimal NOT NULL,
  observacao text,
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (pet_id) REFERENCES pet(id)
)ENGINE=InnoDB;

CREATE TABLE localizacaoalerta (
  id integer NOT NULL AUTO_INCREMENT,
  alerta_id integer NOT NULL,
  latitude  decimal NOT NULL,
  longitude  decimal NOT NULL,
  observacao text,
  data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (id),
  FOREIGN KEY (alerta_id) REFERENCES alerta(id)
)ENGINE=InnoDB;

CREATE TABLE instituicao (
	pessoa_id integer,
	tipo varchar(2),
	situacao varchar(2),
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
)ENGINE=InnoDB;

CREATE TABLE contatos (
	id integer NOT NULL AUTO_INCREMENT,
	tipo varchar(1),
	valor varchar(255),
    usuario_id integer,
	pessoa_id integer,
	data_inclusao DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY(id),
	FOREIGN KEY (usuario_id) REFERENCES usuario(id)
)ENGINE=InnoDB;


-- VIEWS

CREATE VIEW vw_pet AS
SELECT 
  pet.id AS pet_id,
  pet.nome AS pet_nome,
  pet.situacao AS pet_situacao,
  raca.nome AS raca_nome,
  especie.nome AS especie_nome,
  pelagem.nome AS pelagem_nome,
  porte.nome AS pet_porte,
  pessoa.nome AS responsavel_nome
FROM pet
JOIN porte ON pet.porte_id = porte.id
JOIN raca ON pet.raca_id = raca.id
JOIN especie ON raca.especie_id = especie.id
JOIN pelagem ON pet.pelagem_id = pelagem.id
JOIN pessoa ON pet.pessoaresponsavel_id = pessoa.id;
  

CREATE VIEW vw_raca AS
SELECT 
  raca.nome AS raca_nome,
  especie.nome AS especie_nome
FROM raca
JOIN especie ON raca.especie_id = especie.id;