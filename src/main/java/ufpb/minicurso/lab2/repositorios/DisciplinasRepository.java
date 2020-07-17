package ufpb.minicurso.lab2.repositorios;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ufpb.minicurso.lab2.entidades.Disciplina;


@Repository
public interface DisciplinasRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Integer> {
	
	List<Disciplina> findByDisciplinaContaining(String substring);
	
	
	@Query("SELECT d FROM Disciplina s WHERE d.disciplina LIKE %:expressao%")
	List<Disciplina> searchByDisciplinaContaining(@Param("expressao") String expressao);

}
