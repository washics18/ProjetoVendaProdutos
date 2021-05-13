package com.washics18.ProjetoVendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washics18.ProjetoVendas.domain.Categoria;
import com.washics18.ProjetoVendas.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	public CategoriaRepository repo; //acessa a camada repository
	
	//metodo para buscar uma categoria por id
	public Categoria buscar(Integer id) {
		
		Optional<Categoria> obj = repo.findById(id);
				
			return obj.orElse(null);
		
		
		
	}

}
