package teste.persistence;

import java.io.Serializable;
import java.sql.Date;

public class EstudanteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Columns
	private int id;
	private String nome;
	private String matricula;
	private Date aniversario;
	private int FK_curso;
	
	
	public EstudanteBean(int id, String nome, String matricula, Date aniversario, int FK_curso) {
		this.setId(id);
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setAniversario(aniversario);
		this.setFK_curso(FK_curso);
	}


	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}


	public Date getAniversario() {
		return aniversario;
	}

	public void setAniversario(Date aniversario) {
		this.aniversario = aniversario;
	}


	public int getFK_curso() {
		return FK_curso;
	}

	public void setFK_curso(int fK_curso) {
		FK_curso = fK_curso;
	}
	
}
