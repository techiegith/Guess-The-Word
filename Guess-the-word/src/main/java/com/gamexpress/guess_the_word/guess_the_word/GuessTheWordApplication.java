package com.gamexpress.guess_the_word.guess_the_word;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@SpringBootApplication

@ComponentScan
public class GuessTheWordApplication {

	public static void main(String[] args) {

		SpringApplication.run(GuessTheWordApplication.class, args);
	}

}
