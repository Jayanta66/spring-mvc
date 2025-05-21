package com;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages ="com")
@EnableWebMvc
public class EmployeeConfig {
	
	@Bean
	public ViewResolver getViewResolver() {
		
		InternalResourceViewResolver i = new InternalResourceViewResolver();
		i.setPrefix("/WEB-INF/views/");
		i.setSuffix(".jsp");
		
		return i;
		
		
	}
	

	@Bean
	public EmployeeDAO getEmployeeDAO() {
		EmployeeDAO empdao = new EmployeeDAO();
		empdao.setTemplate(getJdbcTemplate());
	
		return empdao;
		
	}
	
	
	@Bean
	public JdbcTemplate getJdbcTemplate() {
		JdbcTemplate template = new JdbcTemplate();
		template.setDataSource(getDriverManagerDataSource());
		return template;
		
	}
	
	@Bean
	public DriverManagerDataSource getDriverManagerDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("1234");
		System.out.println("Database connected ");
		return ds;
		
	}

	
}
