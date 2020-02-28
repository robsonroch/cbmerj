package br.gov.cbmerj.material.config.securityn;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.gov.cbmerj.material.model.User;
import br.gov.cbmerj.material.repository.UserRepository;

@Service
public class AutenticacaoService implements UserDetailsService{
	
	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		 Optional<User> user = repository.findByEmail(username);
		 
		 if(user.isPresent()) {
			 return user.get();
		 }
		 
		throw new UsernameNotFoundException("Dados do usuário inválido");
	}

}
