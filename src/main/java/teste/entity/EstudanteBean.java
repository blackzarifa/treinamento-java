package teste.entity;

import java.io.Serializable;
import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EstudanteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	// Columns
	private int id;
	private String nome;
	private String matricula;
	private Date aniversario;
	@JsonProperty("FK_curso")
	private int FK_curso;
	private int semestre;
	private boolean presencial;
	
	public EstudanteBean() {}
	public EstudanteBean(String nome, String matricula, Date aniversario, int FK_curso, int semestre, boolean presencial) {
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setAniversario(aniversario);
		this.setFK_curso(FK_curso);
		this.setSemestre(semestre);
		this.setPresencial(presencial);
	}
	public EstudanteBean(int id, String nome, String matricula, Date aniversario, int FK_curso, int semestre, boolean presencial) {
		this.setId(id);
		this.setNome(nome);
		this.setMatricula(matricula);
		this.setAniversario(aniversario);
		this.setFK_curso(FK_curso);
		this.setSemestre(semestre);
		this.setPresencial(presencial);
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
	public void setFK_curso(int FK_curso) {
		this.FK_curso = FK_curso;
	}
	
	
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	
	
	public boolean isPresencial() {
		return presencial;
	}
	public void setPresencial(boolean presencial) {
		this.presencial = presencial;
	}
	
}
