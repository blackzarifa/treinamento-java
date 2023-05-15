# Queries para criar o banco de dados
## Tabela estudante
CREATE TABLE estudante (
	id INT AUTO_INCREMENT,
	nome VARCHAR(64),
	matricula VARCHAR(8),
	aniversario DATE,
	FK_curso INT,
	semestre TINYINT,
	presencial BOOL,
	PRIMARY KEY (id),
	FOREIGN KEY(FK_curso) REFERENCES curso (id)
);
## Tabela curso
CREATE TABLE curso (
	id int,
	nome varchar(32),
	PRIMARY KEY (id)
);
