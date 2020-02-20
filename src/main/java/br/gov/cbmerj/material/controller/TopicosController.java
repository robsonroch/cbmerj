package br.gov.cbmerj.material.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicosController {
	
	@GetMapping
	public String lista() {
		return "lista";
	}

}
