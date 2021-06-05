package com.edufelizardo1.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edufelizardo1.forum.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nomeCurso);


}
