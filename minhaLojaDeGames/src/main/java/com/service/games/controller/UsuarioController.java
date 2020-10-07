package com.service.games.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.games.model.UsuarioModel;
import com.service.games.repository.UsuarioRepository;


@RestController
@RequestMapping("/UsuarioModel")
@CrossOrigin("*")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepository repository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> GetById(@PathVariable long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/Usuario/{Usuario}")
	public ResponseEntity<List<UsuarioModel>> GetByUsuario(@PathVariable String Usuario){
		return ResponseEntity.ok(repository.findAllByNomeIgnoreCaseContaining(Usuario));
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioModel> post (@RequestBody UsuarioModel Usuario){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(Usuario));
	}
	
	@PutMapping
	public ResponseEntity<UsuarioModel> put (@RequestBody UsuarioModel Usuario){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(Usuario));
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
}