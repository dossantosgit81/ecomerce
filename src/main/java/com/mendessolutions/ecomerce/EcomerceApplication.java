package com.mendessolutions.ecomerce;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mendessolutions.ecomerce.domain.Categoria;
import com.mendessolutions.ecomerce.domain.Cidade;
import com.mendessolutions.ecomerce.domain.Cliente;
import com.mendessolutions.ecomerce.domain.Endereco;
import com.mendessolutions.ecomerce.domain.Estado;
import com.mendessolutions.ecomerce.domain.Produto;
import com.mendessolutions.ecomerce.domain.enums.TipoCliente;
import com.mendessolutions.ecomerce.repositories.CategoriaRepository;
import com.mendessolutions.ecomerce.repositories.CidadeRepository;
import com.mendessolutions.ecomerce.repositories.ClienteRepository;
import com.mendessolutions.ecomerce.repositories.EnderecoRepository;
import com.mendessolutions.ecomerce.repositories.EstadoRepository;
import com.mendessolutions.ecomerce.repositories.ProdutoRepository;

@SpringBootApplication
public class EcomerceApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cateRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;
	
	@Autowired
	private EstadoRepository estRepo;
	
	@Autowired
	private CidadeRepository cidRepo;
	
	@Autowired
	private ClienteRepository cliRepo;
	
	@Autowired
	private EnderecoRepository endRepo;

	public static void main(String[] args) {
		SpringApplication.run(EcomerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		cateRepo.saveAll(Arrays.asList(cat1, cat2));
		prodRepo.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São paulo");
	
		estRepo.saveAll(Arrays.asList(est1, est2));
	
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		cidRepo.saveAll(Arrays.asList(c1, c2, c3));
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com" ,"5645346767", TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("00940294054", "2565532432"));
		
		Endereco e1 = new Endereco(null, "Rua Getulio Vergas", "300", "Apto 303", "Jardim", "38096870", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Matos", "300", "Apto 303", "Jardim", "38096870", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		cliRepo.saveAll(Arrays.asList(cli1));
		endRepo.saveAll(Arrays.asList(e1, e2));
		
	}

}
