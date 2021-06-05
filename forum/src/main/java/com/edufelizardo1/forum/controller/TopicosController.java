package com.edufelizardo1.forum.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edufelizardo1.forum.controller.dto.TopicoDTO;
import com.edufelizardo1.forum.model.Curso;
import com.edufelizardo1.forum.model.Topico;

@RestController
@RequestMapping(value = "/topicos")
public class TopicosController {

	@GetMapping
	public List<TopicoDTO> lista() {
		
		Topico topico = new Topico("Dúvida", "Dúvida com Spring", new Curso("Spring", "Programação"));
		return TopicoDTO.converter(Arrays.asList(topico, topico, topico));
	}
}
