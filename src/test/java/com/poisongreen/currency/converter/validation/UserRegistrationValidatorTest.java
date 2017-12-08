package com.poisongreen.currency.converter.validation;

import com.poisongreen.currency.converter.model.UserRegistration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.springframework.security.core.userdetails.User;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.Errors;

import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class UserRegistrationValidatorTest {

    @Mock
    private Errors errors;

    @Captor
    private ArgumentCaptor<String> captor;

    @Test
    public void supports() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        Assert.assertTrue(validator.supports(UserRegistration.class));
        Assert.assertFalse(validator.supports(User.class));
    }

    @Test
    public void validateIncorrectFields() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        UserRegistration userRegistration = new UserRegistration();
        when(errors.getFieldValue("surname")).thenReturn(null);
        when(errors.getFieldValue("firstName")).thenReturn(null);
        when(errors.getFieldValue("login")).thenReturn(null);
        when(errors.getFieldValue("password")).thenReturn(null);
        when(errors.getFieldValue("passwordConfirm")).thenReturn(null);

        validator.validate(userRegistration, errors);

        verify(errors).rejectValue("surname", "message.surname.required", null, "Surname is required.");
        verify(errors).rejectValue("firstName", "message.firstName.required", null, "First name is required.");
        verify(errors).rejectValue("login", "message.login.required", null, "Login name is required.");
        verify(errors).rejectValue("password", "message.password.required", null, "Password is required.");
        verify(errors).rejectValue("passwordConfirm", "message.passwordConfirm.required", null, "Password confirm is required.");
        verify(errors, never()).rejectValue("passwordConfirm", "message.passwordConfirm.dont.match", "Passwords don't match.");
    }

    @Test
    public void validateCorrectFields() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setSurname("surnameValue");
        userRegistration.setFirstName("firstNameValue");
        userRegistration.setLogin("loginValue");
        userRegistration.setPassword("passwordValue");
        userRegistration.setPasswordConfirm("passwordValue");

        when(errors.getFieldValue("surname")).thenReturn(userRegistration.getSurname());
        when(errors.getFieldValue("firstName")).thenReturn(userRegistration.getFirstName());
        when(errors.getFieldValue("login")).thenReturn(userRegistration.getLogin());
        when(errors.getFieldValue("password")).thenReturn(userRegistration.getPassword());
        when(errors.getFieldValue("passwordConfirm")).thenReturn(userRegistration.getPasswordConfirm());

        validator.validate(userRegistration, errors);

        verify(errors, never()).rejectValue("surname", "message.surname.required", null, "Surname is required.");
        verify(errors, never()).rejectValue("firstName", "message.firstName.required", null, "First name is required.");
        verify(errors, never()).rejectValue("login", "message.login.required", null, "Login name is required.");
        verify(errors, never()).rejectValue("password", "message.password.required", null, "Password is required.");
        verify(errors, never()).rejectValue("passwordConfirm", "message.passwordConfirm.required", null, "Password confirm is required.");
        verify(errors, never()).rejectValue("passwordConfirm", "message.passwordConfirm.dont.match", "Passwords don't match.");
    }

    @Test
    public void validateDiffrentPasswords() {
        UserRegistrationValidator validator = new UserRegistrationValidator();
        UserRegistration userRegistration = new UserRegistration();
        userRegistration.setSurname("surnameValue");
        userRegistration.setFirstName("firstNameValue");
        userRegistration.setLogin("loginValue");
        userRegistration.setPassword("passwordValue");
        userRegistration.setPasswordConfirm("passwordConfirmValue");

        when(errors.getFieldValue("surname")).thenReturn(userRegistration.getSurname());
        when(errors.getFieldValue("firstName")).thenReturn(userRegistration.getFirstName());
        when(errors.getFieldValue("login")).thenReturn(userRegistration.getLogin());

        when(errors.getFieldValue("password")).thenReturn(userRegistration.getPassword());
        when(errors.getFieldValue("passwordConfirm")).thenReturn(userRegistration.getPasswordConfirm());

        validator.validate(userRegistration, errors);

        verify(errors).rejectValue("passwordConfirm", "message.passwordConfirm.dont.match", "Passwords don't match");

    }
}