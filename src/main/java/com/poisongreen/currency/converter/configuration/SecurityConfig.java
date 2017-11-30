package com.poisongreen.currency.converter.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user1").password("password").roles("USER1")
                .and()
                .withUser("user2").password("password").roles("USER2");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/resources/**", "/", "/login", "/registration", "/login_fail", "/logout").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login_fail")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/user/dashboard")
                .usernameParameter("user_username")
                .passwordParameter("user_password")
                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .logoutSuccessUrl("/logout")
                .and()
                .csrf().disable();
    }
}
