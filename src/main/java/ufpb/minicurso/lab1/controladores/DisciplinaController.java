package ufpb.minicurso.lab1.controladores;

import java.util.List;

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

import ufpb.minicurso.lab1.entidades.Disciplina;
import ufpb.minicurso.lab1.services.DisciplinaService;

@RestController
public class DisciplinaController {
  @Autowired
  private DisciplinaService disciplinaService;
  
  @GetMapping("/v1/api/disciplinas")
  public ResponseEntity<List<Disciplina>> getSaudacao() {
	  return new ResponseEntity<List<Disciplina>>(disciplinaService.getDisciplina(), HttpStatus.OK);
  }
  
  @GetMapping("v1/api/disciplinas/{id}")
  public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Integer id) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.getDisciplinaById(id), HttpStatus.OK);
	} catch(ArrayIndexOutOfBoundsException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @GetMapping("/v1/api/disciplinas/ranking")
  public ResponseEntity<List<Disciplina>> getRankingDisciplinas() {
	  return new ResponseEntity<List<Disciplina>>(disciplinaService.getRankingDisciplinas(), HttpStatus.OK);
  }
  
  @PostMapping("/v1/api/disciplinas")
  public ResponseEntity<Disciplina> setNovaDisciplina(@RequestBody Disciplina novaDisciplina) {
	  return new ResponseEntity<Disciplina>(disciplinaService.setNovaDisciplina(novaDisciplina), HttpStatus.CREATED);
  }
  
  @PutMapping("v1/api/disciplinas/{id}/nome")
  public ResponseEntity<Disciplina> setNomeDisciplinaById(@PathVariable Integer id, @RequestParam(value = "nome", defaultValue = "disciplina") String nome) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.setNomeDisciplinaById(id,nome), HttpStatus.OK);
	} catch(ArrayIndexOutOfBoundsException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @PutMapping("v1/api/disciplinas/{id}/nota")
  public ResponseEntity<Disciplina> setNotaDisciplinaById(@PathVariable Integer id, @RequestParam(value = "nota", defaultValue = "nota") String nota) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.setNotaDisciplinaById(id,nota), HttpStatus.OK);
	} catch(ArrayIndexOutOfBoundsException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
  
  @DeleteMapping("v1/api/disciplinas/{id}")
  public ResponseEntity<Disciplina> removeDisciplinaById(@PathVariable Integer id) {
	try {
		return new ResponseEntity<Disciplina>(disciplinaService.removeDisciplinaById(id), HttpStatus.OK);
	} catch(ArrayIndexOutOfBoundsException aiobe) {
		return new ResponseEntity<Disciplina>(new Disciplina(null, 0), HttpStatus.NOT_FOUND);
	}
  }
}
