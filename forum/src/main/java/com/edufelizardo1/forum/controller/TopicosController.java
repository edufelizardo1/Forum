package com.edufelizardo1.forum.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.edufelizardo1.forum.service.TopicosService;
import com.edufelizardo1.forum.service.dto.DetalhesDoTopicoDTO;
import com.edufelizardo1.forum.service.dto.TopicoDTO;
import com.edufelizardo1.forum.service.form.AtualizacaoTopicoForm;
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
	@Transactional
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm topicoForm,
			UriComponentsBuilder uriBuilder) {
		return topicosService.cadastrar(topicoForm, uriBuilder);
	}

	@GetMapping(value = "/{id}")
	public DetalhesDoTopicoDTO detalhar(@PathVariable Long id) {
		return topicosService.detalhar(id);
	}

	@PutMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<TopicoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoTopicoForm form) {
		return topicosService.atualizar(id, form);
	}
	
	@DeleteMapping(value = "/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		return topicosService.remover(id);
	}
}
