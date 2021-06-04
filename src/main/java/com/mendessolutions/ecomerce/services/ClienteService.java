package com.mendessolutions.ecomerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendessolutions.ecomerce.domain.Cliente;
import com.mendessolutions.ecomerce.repositories.ClienteRepository;
import com.mendessolutions.ecomerce.services.exception.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository categoriaRepository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" +id+ " Tipo " + Cliente.class.getName()
				));
	}
	
}
