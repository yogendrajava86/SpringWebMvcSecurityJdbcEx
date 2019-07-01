package com.app.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.app")
@EnableWebMvc
@PropertySource("classpath:app.properties")
@Import(SecurityConfig.class)
public class AppConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public InternalResourceViewResolver ivr() {
		InternalResourceViewResolver v=new InternalResourceViewResolver();
		v.setPrefix(env.getProperty("mvc.prefix"));
		v.setSuffix(env.getProperty("mvc.suffix"));
		return v;
	}
	
	@Bean
	public BasicDataSource ds() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName(env.getProperty("dbclass"));
		ds.setUrl(env.getProperty("dburl"));
		ds.setUsername(env.getProperty("dbuname"));
		ds.setPassword(env.getProperty("dbpwd"));
		return ds;
	}
	@Bean
	public BCryptPasswordEncoder pwdEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
