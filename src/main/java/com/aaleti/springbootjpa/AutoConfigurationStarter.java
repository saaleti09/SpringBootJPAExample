package com.aaleti.springbootjpa;

import java.util.Arrays;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.Order;

@EnableAutoConfiguration
@ComponentScan("com.aaleti.*")
public class AutoConfigurationStarter implements CommandLineRunner, ApplicationRunner {

	public static void main(String[] args) {

		/*
		 * ApplicationContext factory = new
		 * AnnotationConfigApplicationContext(AppConfig.class);
		 * 
		 * for (String beanName : factory.getBeanDefinitionNames()) {
		 * System.out.println("Bean name is " + beanName); }
		 */

		SpringApplication.run(AutoConfigurationStarter.class, args);

	}

	@Override
	@Order(2)
	public void run(String... args) throws Exception {

		if (args.length > 0)
			System.out.println(
					"Spring Boot Hello World Application Command Line Arguments passed : " + Arrays.toString(args));
		else
			System.out.println("No Command Line Arguments passed");

	}

	@Override
	@Order(1)
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub

		System.out.println("Want to print this after application startup is complete" + args.getSourceArgs());

	}

}
