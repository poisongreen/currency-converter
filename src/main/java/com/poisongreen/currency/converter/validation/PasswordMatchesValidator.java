package com.poisongreen.currency.converter.validation;

import com.poisongreen.currency.converter.model.UserRegistration;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, UserRegistration> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final UserRegistration userRegistration, final ConstraintValidatorContext context) {
        return userRegistration.getPassword().equals(userRegistration.getPasswordConfirm());
    }

}
