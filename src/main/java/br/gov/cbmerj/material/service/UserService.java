package br.gov.cbmerj.material.service;

import java.util.List;

import javax.validation.Valid;

import br.gov.cbmerj.material.model.User;

public interface UserService {

	List<User> findAllByChefeNomeLike(String nomeChefe);

	List<User> findAll();

	void saveWithSubordinates(@Valid User form);

}
