package ufpb.minicurso.lab1.entidades;

public class Disciplina {
	private int id = 0;
	private String nome;
	private double nota;
	
	public Disciplina( String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public int getId() {
		return this.id;
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

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}
