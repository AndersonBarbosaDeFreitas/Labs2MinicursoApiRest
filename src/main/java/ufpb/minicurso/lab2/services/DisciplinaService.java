package ufpb.minicurso.lab2.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufpb.minicurso.lab2.entidades.Disciplina;
import ufpb.minicurso.lab2.repository.DisciplinasRepository;

@Service
public class DisciplinaService {

	@Autowired
	private DisciplinasRepository<Disciplina, Integer> disciplinasDAO;

	public List<Disciplina> getDisciplina() {
		return disciplinasDAO.findAll();
	}

	public Disciplina getDisciplinaById(Integer id) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}
		
		if (!disciplinasDAO.findById(id).isPresent())
			throw new NoSuchElementException();

		Disciplina disciplina = disciplinasDAO.findById(id).get();
		return disciplina;
	}
	
	public List<Disciplina> getRankingDisciplinasByNotas() {
		List<Disciplina> disciplinasRankingByNotas = disciplinasDAO.findAll();
		Collections.sort(disciplinasRankingByNotas, Comparator.comparing(Disciplina::getNota));
		Collections.reverse(disciplinasRankingByNotas);
		return disciplinasRankingByNotas;
	}
	
	public List<Disciplina> getRankingDisciplinasByLikes() {
		List<Disciplina> disciplinasRankingByLikes = disciplinasDAO.findAll();
		Collections.sort(disciplinasRankingByLikes, Comparator.comparing(Disciplina::getLikes));
		Collections.reverse(disciplinasRankingByLikes);
		return disciplinasRankingByLikes;
	}

	public Disciplina setNovaDisciplina(Disciplina novaDisciplina) {
		disciplinasDAO.save(novaDisciplina);
		return disciplinasDAO.findById((int) disciplinasDAO.count()).get();
	}

	public Disciplina setNomeDisciplinaById(Integer id, String nome) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}

		if (!disciplinasDAO.findById(id).isPresent())
			throw new NoSuchElementException();
			

		Disciplina disciplina = disciplinasDAO.findById(id).get();
		disciplina.setNome(nome);
		disciplinasDAO.save(disciplina);
		return disciplinasDAO.findById(id).get();
	}
	
	public Disciplina setNotaDisciplinaById(Integer id, String nota) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}

		if (!disciplinasDAO.findById(id).isPresent())
			throw new NoSuchElementException();

		JSONObject jsonObj = new JSONObject(nota);
		Disciplina disciplina = disciplinasDAO.findById(id).get();
		disciplina.setNota((jsonObj.getDouble("nota") + disciplina.getNota()) / 2);
		disciplinasDAO.save(disciplina);
		return disciplinasDAO.findById(id).get();
	}
	
	public Disciplina removeDisciplinaById(Integer id) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}
		Disciplina disciplina = disciplinasDAO.findById(id).get();
		disciplinasDAO.delete(disciplina);
		return disciplina;
	}

	public Disciplina incrementaLikesDisciplinaById(Integer id) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}

		if (!disciplinasDAO.findById(id).isPresent())
			throw new NoSuchElementException();

		Disciplina disciplina = disciplinasDAO.findById(id).get();
		disciplina.setLikes(disciplina.getLikes() + 1);
		disciplinasDAO.save(disciplina);
		return disciplinasDAO.findById(id).get();
	}
	
	public Disciplina inserirComentarioDisciplinaById(Integer id, String comentario) {
		if (disciplinasDAO.count() == 0 || id <= 0 || id > (int) disciplinasDAO.count()) {
			throw new NoSuchElementException();
		}

		if (!disciplinasDAO.findById(id).isPresent())
			throw new NoSuchElementException();
		
		JSONObject jsonObj = new JSONObject(comentario);
		Disciplina disciplina = disciplinasDAO.findById(id).get();
		disciplina.setComentarios(jsonObj.getString("comentarios"));
		disciplinasDAO.save(disciplina);
		return disciplinasDAO.findById(id).get();
	}
}
