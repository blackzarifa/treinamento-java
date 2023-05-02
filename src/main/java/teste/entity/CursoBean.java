package teste.entity;

import java.io.Serializable;

public class CursoBean implements Serializable {

	private static final long serialVersionUID = 2L;
	
	// Columns
	private int id;
	private String nome;
	
	public CursoBean() {}
	public CursoBean(int id, String nome) {
		this.setId(id);
		this.setNome(nome);
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
	
}
