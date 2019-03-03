package com.karunsood.InMemoryAuthenticationExample.config;

import javax.servlet.Filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser("karun").password(encoder.encode("1234")).roles("USER").and()
		.withUser("bunny").password(encoder.encode("1234")).roles("ADMIN");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		//http.authorizeRequests().anyRequest().permitAll().and().httpBasic();
		//http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		//http.authorizeRequests().antMatchers("**/rest").hasRole("USER").anyRequest().fullyAuthenticated().and().httpBasic();
		//http.authorizeRequests().antMatchers("**/rest").hasRole("USER").and().httpBasic();
		// http.authorizeRequests().anyRequest().permitAll().and().addFilterBefore(customFilter(), BasicAuthenticationFilter.class).httpBasic();
		//http.authorizeRequests().anyRequest().fullyAuthenticated().and().addFilterBefore(customFilter(), BasicAuthenticationFilter.class).httpBasic();
		//http.authorizeRequests().anyRequest().fullyAuthenticated().and().addFilterBefore(customFilter(), BasicAuthenticationFilter.class).httpBasic();
		http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();
		http.csrf().disable();
	}
	
	@Bean
	public CustomFilter customFilter(){
		return new CustomFilter();
	}

}
