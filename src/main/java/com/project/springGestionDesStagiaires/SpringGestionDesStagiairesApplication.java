package com.project.springGestionDesStagiaires;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringGestionDesStagiairesApplication {
	public static ApplicationContext ioc_container;


	public static void main(String[] args) {

		ioc_container = SpringApplication.run(SpringGestionDesStagiairesApplication.class, args);
	}

}
