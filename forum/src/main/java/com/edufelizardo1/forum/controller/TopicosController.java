package com.edufelizardo1.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.edufelizardo1.forum.service.TopicosService;
import com.edufelizardo1.forum.service.dto.TopicoDTO;
import com.edufelizardo1.forum.service.form.TopicoForm;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

	@Autowired
	private TopicosService topicosService;
	
	@GetMapping
	public List<TopicoDTO> listarNome(String nomeCurso) {
		return topicosService.listar(nomeCurso);
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody TopicoForm topicoForm,
			UriComponentsBuilder uriBuilder) {
		return topicosService.cadastrar(topicoForm, uriBuilder);
	}
}
