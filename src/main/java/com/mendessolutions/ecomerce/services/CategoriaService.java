package com.mendessolutions.ecomerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendessolutions.ecomerce.domain.Categoria;
import com.mendessolutions.ecomerce.repositories.CategoriaRepository;
import com.mendessolutions.ecomerce.services.exception.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" +id+ " Tipo " + Categoria.class.getName()
				));
	}
	
}
