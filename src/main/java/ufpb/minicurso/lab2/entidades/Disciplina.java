package ufpb.minicurso.lab2.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Disciplina {
	

	@Id
	@GeneratedValue
	private int id;
	private String nome;
	private double nota;
	private String comentarios = "";
	private int likes;
	
	public Disciplina() {
		super();
	}
	
	public Disciplina( String nome, double nota) {
		super();
		this.nome = nome;
		this.nota = nota;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComentarios() {
		return this.comentarios;
	}

	public void setComentarios(String comentario) {
		this.comentarios += comentario + ";\n";
	}
	
	public int getLikes() {
		return this.likes;
	}

	public void setLikes(int like) {
		this.likes = like;
	}
	
	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
