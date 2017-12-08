package com.poisongreen.currency.converter.validation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintValidatorContext;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
public class PasswordConstraintValidatorTest {

    @Mock
    private ConstraintValidatorContext context;

    @Test
    public void isValidEmptyValue() {
        PasswordConstraintValidator validator = new PasswordConstraintValidator();
        validator.isValid(null, context);

    }
}