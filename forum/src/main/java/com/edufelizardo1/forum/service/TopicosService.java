package com.edufelizardo1.forum.service;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import com.edufelizardo1.forum.model.Topico;
import com.edufelizardo1.forum.repository.CursoRepository;
import com.edufelizardo1.forum.repository.TopicoRepository;
import com.edufelizardo1.forum.service.dto.DetalhesDoTopicoDTO;
import com.edufelizardo1.forum.service.dto.TopicoDTO;
import com.edufelizardo1.forum.service.form.AtualizacaoTopicoForm;
import com.edufelizardo1.forum.service.form.TopicoForm;

@Service
public class TopicosService {

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;

	public List<TopicoDTO> listar(String nomeCurso) {
		if(nomeCurso == null) {
			List<Topico> topico = topicoRepository.findAll();
			return TopicoDTO.converter(topico);
		} else {
			List<Topico> topico = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDTO.converter(topico);
		}
	}
	
	public ResponseEntity<TopicoDTO> cadastrar(TopicoForm topicoForm,
			UriComponentsBuilder uriBuilder) {
		Topico topico = topicoForm.converter(cursoRepository);
		topicoRepository.save(topico);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
	
	@SuppressWarnings("deprecation")
	public DetalhesDoTopicoDTO detalhar(Long id) {
		Topico topico = topicoRepository.getOne(id);
		return new DetalhesDoTopicoDTO(topico);
	}
	
	public ResponseEntity<TopicoDTO> atualizar(Long id, AtualizacaoTopicoForm form) {
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			Topico topico = form.atualizar(id, topicoRepository);
			return ResponseEntity.ok(new TopicoDTO(topico));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	public ResponseEntity<?> remover(Long id) {
		Optional<Topico> optional = topicoRepository.findById(id);
		if (optional.isPresent()) {
			topicoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}
}
