package ufpb.minicurso.lab1.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;
import ufpb.minicurso.lab1.entidades.Disciplina;

@Service
public class DisciplinaService {
	private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	public List<Disciplina> getDisciplina() {
		return disciplinas;
	}

	public Disciplina getDisciplinaById(Integer id) {
		if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}

		return disciplinas.get(id);
	}
	
	public List<Disciplina> getRankingDisciplinas() {
		Collections.sort(disciplinas, Comparator.comparing(Disciplina::getNota));
		Collections.reverse(disciplinas);
		return disciplinas;
	}

	public Disciplina setNovaDisciplina(Disciplina novaDisciplina) {
		novaDisciplina.setId(disciplinas.size());
		disciplinas.add(novaDisciplina);
		return disciplinas.get(disciplinas.size() - 1);
	}

	public Disciplina setNomeDisciplinaById(Integer id, String nome) {
		if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		disciplinas.get(id).setNome(nome);

		return disciplinas.get(id);
	}
	
	public Disciplina setNotaDisciplinaById(Integer id, String nota) {
		if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		disciplinas.get(id).setNota(Double.parseDouble(nota));

		return disciplinas.get(id);
	}

	public Disciplina removeDisciplinaById(Integer id) {
		if (disciplinas.isEmpty() || id < 0 || id >= disciplinas.size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		Disciplina value = disciplinas.get(id);
		disciplinas.remove(value);
		return value;
	}
}
