//package com.example.authenticationTutorial.authLearning1.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class InMemoryAuthConfig extends WebSecurityConfigurerAdapter {
//
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		// TODO Auto-generated method stub
//		auth.inMemoryAuthentication().withUser("abc").password("password").roles("USER")
//		.and()
//		.withUser("foo")
//		.password("password")
//		.roles("ADMIN");
//	}
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// TODO Auto-generated method stub
//		//hasAnyRole
//		http.authorizeRequests()
//		.antMatchers("/admin").hasAnyRole("ADMIN","USER")
//		.antMatchers("/user").hasRole("USER")
//		.antMatchers("/").permitAll()
//		.and().formLogin();
//	}
//	
//	
//	@Bean
//	public PasswordEncoder getPasswordEncoder() {
//		return NoOpPasswordEncoder.getInstance();
//	}
//}
