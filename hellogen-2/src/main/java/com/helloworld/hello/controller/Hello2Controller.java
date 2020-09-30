package com.helloworld.hello.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello2")
public class Hello2Controller {
	
	@GetMapping
	public String hello2() {
		return "Olá Generation!\n"+"Meu objetivo nessa semana é desenvolver a habilidade com o STS para formar um bom BACK-END!";
	}

}
