package com.mywebstore.config;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mywebstore.mvc.controller.PingController;

@Configuration
@ComponentScan("com.mywebstore.mvc.dao")
@PropertySource("classpath:db.properties")
public class DataSourceConfig {

	private static final Logger LOGGER = Logger.getLogger(PingController.class);

	@Autowired
	Environment environment;

	@Bean
	DataSource dataSource() {
		LOGGER.info("DataSourceConfig:: supplying DriverManagerDataSource");

		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty("db.url"));
		driverManagerDataSource.setUsername(environment.getProperty("db.user"));
		driverManagerDataSource.setPassword(environment.getProperty("db.password"));
		driverManagerDataSource.setDriverClassName(environment.getProperty("db.driver"));
		return driverManagerDataSource;
	}
}