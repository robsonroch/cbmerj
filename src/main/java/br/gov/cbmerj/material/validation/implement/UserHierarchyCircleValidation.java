package br.gov.cbmerj.material.validation.implement;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.gov.cbmerj.material.model.User;
import br.gov.cbmerj.material.validation.annotation.UserHierarchyCircleValidator;

public class UserHierarchyCircleValidation implements ConstraintValidator<UserHierarchyCircleValidator, User> {

	@Override
	public boolean isValid(User user, ConstraintValidatorContext context) {
		
		return !user.getSubordinates().contains(user);	
		
	}

}
