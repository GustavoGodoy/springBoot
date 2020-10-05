package com.service.escola.controller;
import java.util.List;

import com.service.escola.model.Aluno;
import com.service.escola.repository.AlunoRepository;
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
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin("*")
public class AlunoController {
	
	@Autowired
	private AlunoRepository repository;
	
	@GetMapping("/aluno")
	public ResponseEntity<List<Aluno>> GetAll(){
		
		return ResponseEntity.ok(repository.findAll());
		
	}
	
	@GetMapping("/aluno/{id}")
	public ResponseEntity<Aluno> GetById(@PathVariable Long id)
	{
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/aluno/nome/{nome}")
	public ResponseEntity<List<Aluno>> GetByTitulo(@PathVariable String nome){
		return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
	}
	
	
	@PostMapping("/aluno")
	public ResponseEntity<Aluno> post (@RequestBody Aluno aluno){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(aluno));
	}
	
	@PutMapping ("/aluno/{id}")
	public ResponseEntity<Aluno> atualizar(@PathVariable Long id, @RequestBody Aluno model){
		return ResponseEntity.status(HttpStatus.OK).body(repository.save(model));
	}
	
	
	@DeleteMapping("aluno/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	

}