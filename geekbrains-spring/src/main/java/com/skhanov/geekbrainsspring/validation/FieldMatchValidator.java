package com.skhanov.geekbrainsspring.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;


public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>{
	
	private String firstFieldName;
	private String secondFieldName;
	private String message;
	
	@Override
	public void initialize(FieldMatch constraintAnnotation) {
		firstFieldName = constraintAnnotation.first();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.message();
	}

	@Override
	public boolean isValid(Object value, ConstraintValidatorContext context) {
		boolean valid = true;
		
		try {
			final Object firstObject = BeanUtils.getProperty(value, firstFieldName);
			final Object secondObject = BeanUtils.getProperty(value, secondFieldName);
			valid = (firstObject == null && secondObject == null) || firstObject != null && secondObject.equals(firstObject);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(!valid) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(message)
			.addPropertyNode(firstFieldName)
			.addConstraintViolation();
		}
		
		return valid;
	}

}
