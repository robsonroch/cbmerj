package br.gov.cbmerj.material.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.gov.cbmerj.material.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	List<User> findAllByChefeNomeLike(String nomeChefe);

	Set<User> findByIdIn(List<Long> ids);

}
