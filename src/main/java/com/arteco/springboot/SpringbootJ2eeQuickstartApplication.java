package com.arteco.springboot;

import org.apache.tomcat.jdbc.pool.XADataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.web.WebApplicationInitializer;

import javax.sql.DataSource;

@SpringBootApplication
public class SpringbootJ2eeQuickstartApplication extends SpringBootServletInitializer implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJ2eeQuickstartApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(applicationClass);
	}

	private static Class<SpringbootJ2eeQuickstartApplication> applicationClass = SpringbootJ2eeQuickstartApplication.class;

	@Bean
	@Profile("devel")
	public DataSource dataSource(Environment environment){
		XADataSource dataSource = new XADataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		return dataSource;
	}
}
