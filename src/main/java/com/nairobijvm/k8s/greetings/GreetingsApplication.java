package com.nairobijvm.k8s.greetings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@SpringBootApplication
public class GreetingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingsApplication.class, args);
	}

	@RestController
	public class GreetingsController {
		@GetMapping
		public String sayHello() {
			return "Ayeiya! The date today is " + new Date();
		}
	}

}

