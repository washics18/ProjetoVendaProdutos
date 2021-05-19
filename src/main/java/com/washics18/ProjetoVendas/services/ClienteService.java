package com.washics18.ProjetoVendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washics18.ProjetoVendas.domain.Cliente;
import com.washics18.ProjetoVendas.repositories.ClienteRepository;
import com.washics18.ProjetoVendas.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository cliente; //acessa a camada repository
	
	//metodo para buscar uma cliente por id
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = cliente.findById(id);
		
				
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado : id: " + id + " , Tipo: " + Cliente.class.getName()));
		
		
		
	}

}
