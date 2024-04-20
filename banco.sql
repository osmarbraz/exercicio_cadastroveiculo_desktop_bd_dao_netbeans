#criar o database chamado exercicio
create database if not exists exercicio;

#entrar no database exercicio
use exercicio;

#remove a tabela para recriá-la
drop table if exists veiculo;

#cria a tabela de veiculo
CREATE TABLE veiculo (
	veiculoID    INTEGER NOT NULL AUTO_INCREMENT,    	 
	placa        VARCHAR(7) NOT NULL,     
	modelo       VARCHAR(50) NOT NULL,     
	marca        VARCHAR(50) NOT NULL,     
	lugares      INTEGER NOT NULL,
	valorAluguel DECIMAL(9,2) NOT NULL,     
	PRIMARY KEY(veiculoID)    
);

#lista a tabela criada
show tables;
