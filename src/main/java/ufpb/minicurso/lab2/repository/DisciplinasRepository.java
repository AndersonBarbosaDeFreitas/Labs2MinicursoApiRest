package ufpb.minicurso.lab2.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ufpb.minicurso.lab2.entidades.Disciplina;

@Repository
public interface DisciplinasRepository<T, ID extends Serializable> extends JpaRepository<Disciplina, Integer> {

}
