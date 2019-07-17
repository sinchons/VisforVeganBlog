package com.sda.finalproject.plantwatering.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    @Qualifier("customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/","/signup","/resources/**").permitAll()
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/")
                .permitAll();
    }

//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("ADMIN1")
//                .password(passwordEncoder().encode("abc123"))
//                .roles("ADMIN").and()
//                .withUser("ADMIN2")
//                .password(passwordEncoder().encode("def456"))
//                .roles("ADMIN");
//
//    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//    http.authorizeRequests().anyRequest().permitAll();
//    //antMatchers path vai role kur atlauj
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
