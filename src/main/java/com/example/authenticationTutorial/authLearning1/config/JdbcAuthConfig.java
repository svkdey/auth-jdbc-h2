package com.example.authenticationTutorial.authLearning1.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class JdbcAuthConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	DataSource datasource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		//autometic population
//		auth.jdbcAuthentication().dataSource(datasource) // autometically points to h2
//				.withDefaultSchema().withUser(User.withUsername("user1").password("pass").roles("USER"))
//				.withUser(User.withUsername("user2").password("pass").roles("ADMIN"));
//	
	//if we use default schema
//		auth.jdbcAuthentication().dataSource(datasource);
//<!---->	
		
//		if we use usebased schema
	
		
		auth.jdbcAuthentication().dataSource(datasource).usersByUsernameQuery(
				"select * from users where username = ? ")
			.authoritiesByUsernameQuery(
					"select * from authorities where username = ?" );
		
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// hasAnyRole
		http.authorizeRequests().antMatchers("/admin").hasAnyRole("ADMIN", "USER").antMatchers("/user").hasRole("USER")
				.antMatchers("/").permitAll().and().formLogin();
	}
//	@Override
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	

}
