package com.arteco.springboot;

import com.arteco.springboot.service.IMIUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Created by rarnau on 26/9/16.
 * Arteco Consulting Sl.
 * mailto: info@arteco-consulting.com
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private Environment environment;


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/api/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll();
		if (environment.acceptsProfiles("devel")){
			http.formLogin();
		}
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(daoAuthenticationProvider());
	}

	@Autowired
	public AuthenticationProvider daoAuthenticationProvider() {
		//TODO: password encoder is not set. For Example:
		//org.springframework.security.authentication.encoding.Md5PasswordEncoder
		return new DaoAuthenticationProvider();
	}

	@Autowired
	public UserDetailsService userDetailsService() {
		return new IMIUserDetailsService();
	}

}
