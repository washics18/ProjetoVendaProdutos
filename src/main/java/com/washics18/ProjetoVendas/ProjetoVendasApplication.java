package com.washics18.ProjetoVendas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.washics18.ProjetoVendas.domain.Categoria;
import com.washics18.ProjetoVendas.domain.Cidade;
import com.washics18.ProjetoVendas.domain.Cliente;
import com.washics18.ProjetoVendas.domain.Endereco;
import com.washics18.ProjetoVendas.domain.Produto;
import com.washics18.ProjetoVendas.domain.enums.TipoCliente;
import com.washics18.ProjetoVendas.domain.Estado;
import com.washics18.ProjetoVendas.repositories.CategoriaRepository;
import com.washics18.ProjetoVendas.repositories.CidadeRepository;
import com.washics18.ProjetoVendas.repositories.ClienteRepository;
import com.washics18.ProjetoVendas.repositories.EnderecoRepository;
import com.washics18.ProjetoVendas.repositories.EstadoRepository;
import com.washics18.ProjetoVendas.repositories.ProdutoRepository;

@SpringBootApplication
public class ProjetoVendasApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ClienteRepository  clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoVendasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador" , 2000.00);
		Produto p2 = new Produto(null, "Impressora" , 800.00);
		Produto p3 = new Produto(null, "Mouse" , 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		
		
		Estado estado1 = new Estado(null, "Minas Gerais");
		Estado estado2 = new Estado(null, "São Paulo");
		
		Cidade cidade1 = new Cidade(null, "Urberlândia" , estado1);
		Cidade cidade2 = new Cidade(null, "São Paulo" , estado2);
		Cidade cidade3 = new Cidade(null, "Campinas" , estado2);
		
		estado1.getCidades().addAll(Arrays.asList(cidade1));
		estado2.getCidades().addAll(Arrays.asList(cidade2,cidade3));
		
		estadoRepository.saveAll(Arrays.asList(estado1,estado2));
		cidadeRepository.saveAll(Arrays.asList(cidade1,cidade2,cidade3));
		
		Cliente cli1 = new Cliente(null , "Maria Silva" , "maria@gmail.com" , "34567875" , TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363342" , "93836785"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "Apto 203", "Jardim", "234588-678", cli1, cidade1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro" , "67845-432" , cli1 , cidade1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		
		
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
	   
		
		
		
		
		
		
	}

}
