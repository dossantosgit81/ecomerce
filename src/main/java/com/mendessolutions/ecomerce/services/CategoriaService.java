package com.mendessolutions.ecomerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.mendessolutions.ecomerce.domain.Categoria;
import com.mendessolutions.ecomerce.repositories.CategoriaRepository;
import com.mendessolutions.ecomerce.services.exception.DataIntegrityException;
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
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return categoriaRepository.save(obj);
	}
	
	public Categoria update (Categoria obj) {
		buscar(obj.getId());
		return categoriaRepository.save(obj);
	}

	public void delete(Integer id) {
		buscar(id);
		try {	
			categoriaRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possivel excluir uma categoria que possui um ou mais produtos.");
		}
		
	}
	
	public List<Categoria> findAll(){
		return categoriaRepository.findAll();
	}
	
	
}
