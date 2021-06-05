package com.edufelizardo1.forum.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edufelizardo1.forum.controller.dto.TopicoDTO;
import com.edufelizardo1.forum.model.Topico;
import com.edufelizardo1.forum.repository.TopicoRepository;

@Service
public class TopicosService {

	@Autowired
	private TopicoRepository topicoRepository;

	public List<TopicoDTO> listar() {
		List<Topico> topico = topicoRepository.findAll();
		return TopicoDTO.converter(topico);
	}
}