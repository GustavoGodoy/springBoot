package com.service.games.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="tb_categoria")
public class CategoriaModel {

	@Id
	@Column(name = "id_categoria")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@NotNull
	private String categoria;

	@OneToMany(mappedBy="categoria", cascade=CascadeType.ALL)
	@JsonIgnoreProperties("categoria")
	private List<ProdutoModel> produtos;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<ProdutoModel> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<ProdutoModel> produtos) {
		this.produtos = produtos;
	}
	
}
