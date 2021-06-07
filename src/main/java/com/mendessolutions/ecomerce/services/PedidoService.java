package com.mendessolutions.ecomerce.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mendessolutions.ecomerce.domain.Pedido;
import com.mendessolutions.ecomerce.repositories.PedidoRepository;
import com.mendessolutions.ecomerce.services.exception.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository categoriaRepository;

	public Pedido buscar(Integer id) {
		Optional<Pedido> obj = categoriaRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id:" +id+ " Tipo " + Pedido.class.getName()
				));
	}
	
}
