package com.mendessolutions.ecomerce;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mendessolutions.ecomerce.domain.Categoria;
import com.mendessolutions.ecomerce.domain.Produto;
import com.mendessolutions.ecomerce.repositories.CategoriaRepository;
import com.mendessolutions.ecomerce.repositories.ProdutoRepository;

@SpringBootApplication
public class EcomerceApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository cateRepo;
	
	@Autowired
	private ProdutoRepository prodRepo;

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
		
	}

}
