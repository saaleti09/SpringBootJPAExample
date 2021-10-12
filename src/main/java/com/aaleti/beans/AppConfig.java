package com.aaleti.beans;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("ReplacementForXML")
public class AppConfig {
	
	@Bean("appName")
	public String applicationName() {
		
		System.out.println("Called applicationName in AutoConfigurationStarter");
		
		return "MyApplicationName";
	}
	
	
	
	@Bean("sanjay")
    public MyBean myBean() {
		System.out.println("Creating My Bean");
		return new MyBean();
	}
	
	/*@Bean
	public DataSource getDataSource() {
		
		System.out.println("Confuguring custom data source");
		
		return DataSourceBuilder.create().url("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1").username("sa").password("sa").build();
		
	}*/

}
