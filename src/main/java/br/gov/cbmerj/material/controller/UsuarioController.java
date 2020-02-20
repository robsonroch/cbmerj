package br.gov.cbmerj.material.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.gov.cbmerj.material.model.Usuario;
import br.gov.cbmerj.material.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository repository;
	
	@GetMapping
	public List<Usuario> lista(String nomeChefe) {
		
		return repository.findAllByChefeNomeLike(nomeChefe);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario form, UriComponentsBuilder uriBuilder){
		repository.save(form);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(form.getId()).toUri();
		
		return ResponseEntity.created(uri).body(form);
	}

}
