package test.test.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;

public class UserValidator implements Validator{
	@Override
	public boolean supports(Class clazz) {
		return UserData.class.isAssignableFrom(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		UserData userData = (UserData)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required");
	}
}
