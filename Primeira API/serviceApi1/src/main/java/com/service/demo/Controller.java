package com.service.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private ServiceRepository repository;

	@GetMapping("/servicos")
	public List<ServiceModel> pegarTodos() {
		return repository.findAll();
	}

	@PostMapping("/servicos")
	public ServiceModel criar (@RequestBody ServiceModel model) {
		repository.save(model);
		return model;
	
	}
}