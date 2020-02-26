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

import br.gov.cbmerj.material.model.User;
import br.gov.cbmerj.material.repository.UserRepository;
import br.gov.cbmerj.material.service.UserService;

@RestController
@RequestMapping("/usuarios")
public class UserController {
	
	@Autowired
	UserService service;
	
	@GetMapping
	public List<User> lista(String nomeChefe) {
		
		if (nomeChefe == null) {
			List<User> users = (List<User>) service.findAll();
			return users;
		} else {
			return service.findAllByChefeNomeLike(nomeChefe);
		}
				
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<User> cadastrar(@RequestBody @Valid User form, UriComponentsBuilder uriBuilder){
		service.saveWithSubordinates(form);
		
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(form.getId()).toUri();
		
		return ResponseEntity.created(uri).body(form);
	}

}
