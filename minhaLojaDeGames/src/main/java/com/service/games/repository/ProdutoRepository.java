package com.service.games.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.games.model.ProdutoModel;


@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel,Long>{
	
	public List<ProdutoModel> findAllByNameProdutoIgnoreCaseContaining(String produto);

}
