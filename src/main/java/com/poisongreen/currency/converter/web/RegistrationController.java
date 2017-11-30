package com.poisongreen.currency.converter.web;

import com.poisongreen.currency.converter.model.Registration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RegistrationController {

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String initRegistrationForm(Model model) {
        model.addAttribute("registrationForm", new Registration());
        return "registration";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registerUser(@ModelAttribute("registrationForm") Registration registration, Model model) {

        return "redirect:/login";
    }
}
