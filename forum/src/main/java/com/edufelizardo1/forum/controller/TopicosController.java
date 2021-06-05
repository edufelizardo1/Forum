package com.edufelizardo1.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edufelizardo1.forum.controller.dto.TopicoDTO;
import com.edufelizardo1.forum.service.TopicosService;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@Autowired
	private TopicosService topicosService;
	
	@GetMapping
	public List<TopicoDTO> listarNome(String nomeCurso) {
		return topicosService.listar(nomeCurso);
	}
}
