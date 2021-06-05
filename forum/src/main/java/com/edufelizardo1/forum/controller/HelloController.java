package com.edufelizardo1.forum.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/")
	@ResponseBody
	public String HelloWord() {
		return "Hello Word!!!";
	}
}
