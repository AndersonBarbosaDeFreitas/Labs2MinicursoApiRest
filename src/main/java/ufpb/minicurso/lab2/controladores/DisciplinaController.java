package ufpb.minicurso.lab2.controladores;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ufpb.minicurso.lab2.entidades.Disciplina;
import ufpb.minicurso.lab2.services.DisciplinaService;

@RestController
public class DisciplinaController {
	
  @Autowired
  private DisciplinaService disciplinaService;
  
  @GetMapping("/disciplinas")
  public ResponseEntity<List<Disciplina>> getDisciplina() {
	  return new ResponseEntity<List<Disciplina>>(disciplinaService.getDisciplina(), HttpStatus.OK);
  }
  
  @GetMapping("/disciplinas/{id}")
  public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Integer id) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaById(id), HttpStatus.OK);
	} catch(NoSuchElementException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @GetMapping("/disciplinas/ranking/notas")
  public ResponseEntity<List<Disciplina>> getRankingDisciplinasByNotas() {
	  return new ResponseEntity<List<Disciplina>>(disciplinaService.getRankingDisciplinasByNotas(), HttpStatus.OK);
  }
  
  @GetMapping("/disciplinas/ranking/likes")
  public ResponseEntity<List<Disciplina>> getRankingDisciplinasByLikes() {
	  return new ResponseEntity<List<Disciplina>>(disciplinaService.getRankingDisciplinasByLikes(), HttpStatus.OK);
  }
  
  @PostMapping("/disciplinas")
  public ResponseEntity<Disciplina> setNovaDisciplina(@RequestBody Disciplina novaDisciplina) {
	  return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(novaDisciplina), HttpStatus.CREATED);
  }
  
  @PutMapping("/disciplinas/{id}/nome")
  public ResponseEntity<Disciplina> setNomeDisciplinaById(@PathVariable Integer id, @RequestParam(value = "nome", defaultValue = "disciplina") String nome) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.setNomeDisciplinaById(id,nome), HttpStatus.OK);
	} catch(NoSuchElementException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @PutMapping("/disciplinas/likes/{id}")
  public ResponseEntity<Disciplina> incrementaLikesDisciplinaById(@PathVariable Integer id) {
	  try {
		return new ResponseEntity<Disciplina>(disciplinaService.incrementaLikesDisciplinaById(id), HttpStatus.OK);
	} catch(NoSuchElementException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @PutMapping("/disciplinas/nota/{id}")
  public ResponseEntity<Disciplina> setNotaDisciplinaById(@PathVariable Integer id, @RequestBody String nota) {
	  try {
		  return new ResponseEntity<Disciplina>(disciplinaService.setNotaDisciplinaById(id,nota), HttpStatus.OK);
	  } catch(NoSuchElementException aiobe) {
		  return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	  }
  }
  
  @PutMapping("/disciplinas/comentarios/{id}")
  public ResponseEntity<Disciplina> inserirComentarioDisciplinaById(@PathVariable Integer id, @RequestBody String comentario) {
	  try {
		return new ResponseEntity<Disciplina>(disciplinaService.inserirComentarioDisciplinaById(id, comentario), HttpStatus.OK);
	} catch(NoSuchElementException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @DeleteMapping("/disciplinas/{id}")
  public ResponseEntity<Disciplina> removeDisciplinaById(@PathVariable Integer id) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.removeDisciplinaById(id), HttpStatus.OK);
	} catch(NoSuchElementException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
}
