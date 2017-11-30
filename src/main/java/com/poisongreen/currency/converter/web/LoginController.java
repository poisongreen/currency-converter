package com.poisongreen.currency.converter.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

    public static final String AUTH_STATUS = "auth_status";
    public static final String AUTH_STATUS_FAIL = "auth_fail";

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @RequestMapping("/login_fail")
    public String loginFail(ModelMap model) {
        model.addAttribute(AUTH_STATUS, AUTH_STATUS_FAIL);
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.addAttribute("message", "You have successfully logged off from application !");
        return "login";
    }
}