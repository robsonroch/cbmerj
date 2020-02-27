package br.gov.cbmerj.material.validation.implement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.gov.cbmerj.material.model.User;
import br.gov.cbmerj.material.validation.annotation.UserHierarchyCircleValidator;
import br.gov.cbmerj.material.validation.annotation.UserHierarchyLevelValidator;

public class UserHierarchyLevelValidation implements ConstraintValidator<UserHierarchyLevelValidator, User> {

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		
		User firstUser = user.getSubordinates().stream()
        .peek(u -> System.out.println("Nível " + u.getNivelHirarquivo()))
        .filter(u -> u.getNivelHirarquivo() >= user.getNivelHirarquivo())
        .findFirst()
        .get();
		
		return firstUser == null;	
		
	}

}
