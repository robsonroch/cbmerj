package br.gov.cbmerj.material.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.cbmerj.material.model.User;
import br.gov.cbmerj.material.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository repositoy;
	
	@Override
	@Transactional
	public void saveWithSubordinates(@Valid User chefe) {		
		
		List<Long> ids = chefe.getSubordinados().stream().map(User::getId).collect(Collectors.toList());
		
		Set<User> findByIdIn = repositoy.findByIdIn(ids);
		
		findByIdIn.stream().forEach(user -> user.setChefe(chefe));
		
		chefe.setSubordinados(findByIdIn);
		repositoy.save(chefe);
	}

	@Override
	public List<User> findAllByChefeNomeLike(String nomeChefe) {
		return repositoy.findAllByChefeNomeLike(nomeChefe);
	}

	@Override
	public List<User> findAll() {
		return (List<User>) repositoy.findAll();
	}

}
