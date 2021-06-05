package com.edufelizardo1.forum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.edufelizardo1.forum.model.Topico;

@RestController
public class TopicosController {

	@RequestMapping(value = "/topicos")
	@ResponseBody
	public Topico lista() {
		return null;
	}
}
