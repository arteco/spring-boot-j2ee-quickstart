package com.arteco.springboot;

import com.arteco.springboot.jaas.RoleUserAuthorityGranter;
import com.arteco.springboot.jaas.UsernameEqualsPasswordLoginModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.jaas.*;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.security.auth.login.AppConfigurationEntry;
import java.security.Principal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
		if (environment.acceptsProfiles("devel")) {
			auth.inMemoryAuthentication().withUser("admin").password("admin").roles("ADMIN");
		}else{
			auth.authenticationProvider(jaasAuthenticationProvider());
		}

	}

	private AuthenticationProvider jaasAuthenticationProvider() throws Exception {
		DefaultJaasAuthenticationProvider result = new DefaultJaasAuthenticationProvider();
		AppConfigurationEntry[] confs = new AppConfigurationEntry[]{jaasAuthenticationAppConfig()};
		Map<String,AppConfigurationEntry[]> mappedConfigurations = new HashMap<>();
		mappedConfigurations.put("SPRINGSECURITY", confs);
		InMemoryConfiguration config = new InMemoryConfiguration(mappedConfigurations);
		result.setConfiguration(config);
		result.setAuthorityGranters(new AuthorityGranter[]{new RoleUserAuthorityGranter()});
		return result;
	}

	private AppConfigurationEntry jaasAuthenticationAppConfig() {
		return new AppConfigurationEntry(
				UsernameEqualsPasswordLoginModule.class.getName(),
                AppConfigurationEntry.LoginModuleControlFlag.REQUIRED,
                new HashMap<String, Object>()
        );
	}
}
