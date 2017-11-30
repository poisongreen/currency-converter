package com.poisongreen.currency.converter.web;


import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.poisongreen.currency.converter.web.LoginController.AUTH_STATUS;
import static com.poisongreen.currency.converter.web.LoginController.AUTH_STATUS_FAIL;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
public class LoginControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void callDefaultLink() throws Exception {
        this.mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/view/login.jsp"));

    }

    @Test
    public void callLogin() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/view/login.jsp"));

    }

    @Test
    public void callLoginFail() throws Exception {
        this.mockMvc.perform(get("/login_fail"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute(AUTH_STATUS, Matchers.is(AUTH_STATUS_FAIL)))
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/view/login.jsp"));
    }

    @Test
    public void callLogout() throws Exception {
        this.mockMvc.perform(get("/logout"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attribute("message", Matchers.is("You have successfully logged off from application !")))
                .andExpect(view().name("login"))
                .andExpect(forwardedUrl("/WEB-INF/view/login.jsp"));
    }

}