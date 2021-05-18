package com.washics18.ProjetoVendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.washics18.ProjetoVendas.domain.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	 //JpaRepository acessar os dados do tipo que for passado ex: Categoria
	 // CategoriaRepository realizar operações acessos a dados buscar , deletar , salvar , alterar. Objeto Categoria mapeado pela tabela categoria 

}
