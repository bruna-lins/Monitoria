package com.persistencia.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistencia.domain.Produto;
import com.persistencia.repositories.ProdutoRepository;

@Service
public class DBService {
	
	@Autowired
	private ProdutoRepository repo;
	
	public void inicializarBancoDados() {
		Produto produto = new Produto(null,"Notebook","K45A",15,2599.99);
		repo.save(produto);
	}

}
