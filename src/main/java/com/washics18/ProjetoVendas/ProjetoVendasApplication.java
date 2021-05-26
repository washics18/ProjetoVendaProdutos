package com.washics18.ProjetoVendas;

import java.text.SimpleDateFormat;
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
import com.washics18.ProjetoVendas.domain.enums.EstadoPagamento;
import com.washics18.ProjetoVendas.domain.enums.TipoCliente;
import com.washics18.ProjetoVendas.domain.Estado;
import com.washics18.ProjetoVendas.domain.ItemPedido;
import com.washics18.ProjetoVendas.domain.Pagamento;
import com.washics18.ProjetoVendas.domain.PagamentoComBoleto;
import com.washics18.ProjetoVendas.domain.PagamentoComCartao;
import com.washics18.ProjetoVendas.domain.Pedido;
import com.washics18.ProjetoVendas.repositories.CategoriaRepository;
import com.washics18.ProjetoVendas.repositories.CidadeRepository;
import com.washics18.ProjetoVendas.repositories.ClienteRepository;
import com.washics18.ProjetoVendas.repositories.EnderecoRepository;
import com.washics18.ProjetoVendas.repositories.EstadoRepository;
import com.washics18.ProjetoVendas.repositories.ItemPedidoRepository;
import com.washics18.ProjetoVendas.repositories.PagamentoRepository;
import com.washics18.ProjetoVendas.repositories.PedidoRepository;
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
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

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
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro" , "67845-432" , cli1 , cidade2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2017 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("10/10/2017 19:35"), cli1, e2);
		
	   
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6); //classe pagamento abstract só pode ser instaciada pelas subclasses
		ped1.setPagamento(pagto1);
		
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 200.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		ItemPedido ip3 = new ItemPedido(ped2, p2, 100.00, 1, 800.00);
		
		ped1.getItens().addAll(Arrays.asList(ip1,ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2,ip3));
		
		
		
		
		
		
		
		
		
	}

}
