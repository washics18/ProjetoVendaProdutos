package com.washics18.ProjetoVendas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.washics18.ProjetoVendas.domain.Pedido;
import com.washics18.ProjetoVendas.repositories.PedidoRepository;
import com.washics18.ProjetoVendas.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	public PedidoRepository repo; //acessa a camada repository
	
	//metodo para buscar uma categoria por id
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);
		
				
			return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado : id: " + id + " , Tipo: " + Pedido.class.getName()));
		
		
		
	}

}
