package ufpb.minicurso.lab2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.lab2.dtos.UsuarioDTO;
import ufpb.minicurso.lab2.entidades.Usuario;
import ufpb.minicurso.lab2.exceptions.UsuarioInvalidoException;
import ufpb.minicurso.lab2.exceptions.UsuarioJaExisteException;
import ufpb.minicurso.lab2.services.UsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping("/usuarios")
	public ResponseEntity<UsuarioDTO> criaUsuario(@RequestBody Usuario usuario) {
		try {
			return new ResponseEntity<UsuarioDTO>(usuarioService.criaUsuario(usuario), HttpStatus.CREATED);
		} catch (UsuarioJaExisteException uee) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (UsuarioInvalidoException uie) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
	}

	@DeleteMapping("/auth/usuarios")
	public ResponseEntity<UsuarioDTO> deletaUsuario(@RequestHeader("Authorization") String token) {
		try {
			return new ResponseEntity<>(usuarioService.deletaUsuario(token), HttpStatus.OK);
		} catch (UsuarioJaExisteException uee) {
			return new ResponseEntity<>(HttpStatus.CONFLICT);
		} catch (UsuarioInvalidoException uie) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}

}