package com.persistencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persistencia.domain.Produto;
import com.persistencia.repositories.ProdutoRepository;
import com.persistencia.service.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	public Produto findById(Integer id) {
		Optional<Produto> produto = repo.findById(id);
		return produto.orElseThrow( () -> 
		               new ObjectNotFoundException("Objeto nao encontrado Id: "+id+
		            		                       " Tipo: "+Produto.class.getName()));
	}
	
	public List<Produto> findAll() {
		return repo.findAll();
	}
	
	public Produto save(Produto produto) {
		produto.setId(null);
		return repo.save(produto);
	}
	
	public Produto update(Produto produto) {
		findById(produto.getId()); // Se não encontrar, gera exceção...
		return repo.save(produto);
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
