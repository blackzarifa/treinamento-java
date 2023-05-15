# Queries para criar o banco de dados
## Tabela estudante
CREATE TABLE estudante (\
&nbsp;&nbsp;&nbsp; id INT AUTO_INCREMENT,\
&nbsp;&nbsp;&nbsp; nome VARCHAR(64),\
&nbsp;&nbsp;&nbsp; matricula VARCHAR(8),\
&nbsp;&nbsp;&nbsp; aniversario DATE,\
&nbsp;&nbsp;&nbsp; FK_curso INT,\
&nbsp;&nbsp;&nbsp; semestre TINYINT,\
&nbsp;&nbsp;&nbsp; presencial BOOL,\
&nbsp;&nbsp;&nbsp; PRIMARY KEY (id),\
&nbsp;&nbsp;&nbsp; FOREIGN KEY(FK_curso) REFERENCES curso (id)\
);
## Tabela curso
CREATE TABLE curso (\
&nbsp;&nbsp;&nbsp; id int,\
&nbsp;&nbsp;&nbsp; nome varchar(32),\
&nbsp;&nbsp;&nbsp; PRIMARY KEY (id)\
);
## Diagrama
![image](https://github.com/blackzarifa/treinamento-java/assets/93669938/39abb8e8-91d1-4db8-808a-d76a0e607cf7)
