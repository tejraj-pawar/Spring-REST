package com.yolo.springrest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


// for this we have disabled auto-configuration SecurityAutoConfiguration. (see application.properties)
@Configuration
@EnableWebSecurity
public class BasicAuthSecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        PasswordEncoder encoder = 
          PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth
          .inMemoryAuthentication()
          .withUser("user1").password(encoder.encode("pass1")).roles("USER1")
          .and()
          .withUser("user2").password(encoder.encode("pass2")).roles("USER2")
          .and()
          .withUser("admin").password(encoder.encode("admin")).roles("USER2", "USER1", "ADMIN");
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
		/*
		 * http .authorizeRequests() .anyRequest() .authenticated() .and() .httpBasic();
		 * http.csrf().disable();
		 */
        
        http
        .authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().antMatchers("/console/**").permitAll()
        .and()
        .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}	
