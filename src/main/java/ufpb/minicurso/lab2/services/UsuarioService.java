package ufpb.minicurso.lab2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.minicurso.lab2.dtos.UsuarioDTO;
import ufpb.minicurso.lab2.entidades.Usuario;
import ufpb.minicurso.lab2.exceptions.UsuarioInvalidoException;
import ufpb.minicurso.lab2.exceptions.UsuarioJaExisteException;
import ufpb.minicurso.lab2.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuariosDAO;
	@Autowired
	private JWTService jwtService;

	public UsuarioDTO criaUsuario(Usuario usuario) {
		if (usuariosDAO.findByEmail(usuario.getEmail()).isPresent())
			throw new UsuarioJaExisteException();
		if (!usuario.isValid())
			throw new UsuarioInvalidoException();
		usuariosDAO.save(usuario);
		return new UsuarioDTO(usuario);
	}

	public UsuarioDTO deletaUsuario(String cabecalhoDeAutorizacao) {
		Optional<String> usuarioId = jwtService.recuperaUsuario(cabecalhoDeAutorizacao);
		
		Usuario usuario = validaUsuario(usuarioId);
		
		usuariosDAO.delete(usuario);
		return new UsuarioDTO(usuario);
	}

	private Usuario validaUsuario(Optional<String> id) {
		if(!id.isPresent())
			throw new UsuarioInvalidoException();

		Optional<Usuario> usuario = usuariosDAO.findByEmail(id.get());
		if (!usuario.isPresent())
			throw new UsuarioInvalidoException();
		
		return usuario.get();

	}

}