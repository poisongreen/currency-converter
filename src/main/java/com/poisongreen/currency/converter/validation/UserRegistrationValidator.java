package com.poisongreen.currency.converter.validation;

import com.poisongreen.currency.converter.model.UserRegistration;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserRegistrationValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return UserRegistration.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(final Object obj, final Errors errors) {

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "message.surname.required", "Surname is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "message.firstName.required", "First name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "message.login.required", "Login name is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "message.password.required", "Password is required.");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirm", "message.passwordConfirm.required", "Password confirm is required.");

        UserRegistration userRegistration = (UserRegistration) obj;

        if (StringUtils.isNoneBlank(userRegistration.getPassword(), userRegistration.getPasswordConfirm()) &&
                !userRegistration.getPassword().equals(userRegistration.getPasswordConfirm())) {
            errors.rejectValue("passwordConfirm", "message.passwordConfirm.dont.match", "Passwords don't match");
        }
    }

}
