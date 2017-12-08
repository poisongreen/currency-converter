package com.poisongreen.currency.converter.web;

import com.poisongreen.currency.converter.model.UserRegistration;
import com.poisongreen.currency.converter.validation.UserRegistrationValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class RegistrationController {


    @Autowired
    private UserRegistrationValidator nameValidator;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.addValidators(nameValidator);
    }


    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new UserRegistration());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registrationForm") @Valid UserRegistration registration, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "registration";
        }
        return "redirect:/login";
    }
}
