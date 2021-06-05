package com.edufelizardo1.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edufelizardo1.forum.model.Topico;


public interface TopicoRepository extends JpaRepository<Topico, Long>{

	List<Topico> findByCursoNome(String nomeCurso);

}
