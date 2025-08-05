package com.gms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class GroceriesManagementSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(GroceriesManagementSystemApplication.class, args);
	}

}
