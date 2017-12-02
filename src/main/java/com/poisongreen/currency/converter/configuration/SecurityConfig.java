package com.poisongreen.currency.converter.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@Order(1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


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
