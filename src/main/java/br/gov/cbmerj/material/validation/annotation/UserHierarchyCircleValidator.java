package br.gov.cbmerj.material.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.gov.cbmerj.material.validation.implement.UserHierarchyCircleValidation;

@Documented
@Constraint(validatedBy = UserHierarchyCircleValidation.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserHierarchyCircleValidator {
	
	String message() default "Hierarquia circular no usuário!";
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
