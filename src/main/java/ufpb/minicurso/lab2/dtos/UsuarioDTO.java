package ufpb.minicurso.lab2.dtos;

import ufpb.minicurso.lab2.entidades.Usuario;
import lombok.Data;

@Data
public class UsuarioDTO {
	private String email;
	private String nome;

	public UsuarioDTO(Usuario usuario) {
		email = usuario.getEmail();
		nome = usuario.getNome();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}