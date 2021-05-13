package com.washics18.ProjetoVendas.Resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.washics18.ProjetoVendas.domain.Categoria;
import com.washics18.ProjetoVendas.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service; //acessa a camada serviços
	
	
	@RequestMapping(value="/{id}" , method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) { //ResponseEntity<?> armazena varias informações de uma resposta http para serviço rest
		
		Categoria obj = service.buscar(id);
		
		return ResponseEntity.ok().body(obj);
		
		
	}

}
