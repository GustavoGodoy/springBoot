package com.service.escola.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.escola.model.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

	public List<Aluno> findAllByNomeContainingIgnoreCase(String nome);

}