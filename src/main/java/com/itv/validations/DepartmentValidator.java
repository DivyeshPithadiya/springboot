package com.itv.validations;

import java.util.Arrays;
import java.util.List;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DepartmentValidator implements ConstraintValidator<DepartmentValidation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		List<String> depts = Arrays.asList("IT", "HR", "Accounts");
		
		if(depts.contains(value)) {
			return true;
		}
		return false;
	}

}
