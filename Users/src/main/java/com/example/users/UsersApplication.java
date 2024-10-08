package com.example.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class UsersApplication {

	@RequestMapping("/")
	public String home() {
		System.out.println("Welcome to the Users Application");
		return "Welcome to the Users Application";
	}

	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
	}

}
