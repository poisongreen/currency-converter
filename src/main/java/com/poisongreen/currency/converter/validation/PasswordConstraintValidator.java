package com.poisongreen.currency.converter.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {

    @Override
    public void initialize(final ValidPassword arg0) {
    }

    @Override
    public boolean isValid(final String password, final ConstraintValidatorContext context) {
        boolean valid = true;
        List<String> validaionMessagesList = new ArrayList<>();
        if (password.length() > 15 || password.length() < 8) {
            validaionMessagesList.add("{message.password.wrong.length}");
            valid = false;
        }
        String upperCaseChars = "(.*[A-Z].*)";
        if (!password.matches(upperCaseChars)) {
            validaionMessagesList.add("{message.password.wrong.upper.case}");
            valid = false;
        }
        String lowerCaseChars = "(.*[a-z].*)";
        if (!password.matches(lowerCaseChars)) {
            validaionMessagesList.add("{message.password.wrong.lower.case}");
            valid = false;
        }
        String numbers = "(.*[0-9].*)";
        if (!password.matches(numbers)) {
            validaionMessagesList.add("{message.password.wrong.number}");
            valid = false;
        }
        String specialChars = "(.*[,~,!,@,#,$,%,^,&,*,(,),-,_,=,+,[,{,],},|,;,:,<,>,/,?].*$)";
        if (!password.matches(specialChars)) {
            validaionMessagesList.add("{message.password.wrong.special.character}");
            valid = false;
        }
        if (!valid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(validaionMessagesList.stream()
                    .map(i -> i.toString())
                    .collect(Collectors.joining(","))).addConstraintViolation();
        }
        return valid;
    }
}
