package com.practica.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practica.dao.Cliente;
import com.practica.servicios.ClienteService;

/**
 * Controlador que gestiona las operaciones relacionadas con los clientes en la capa de presentación
 * Utiliza el servicio {@link ClienteServiceImpl} para interactuar con la capa da servicio de persistencia a Clientes
 *
 * Las operaciones marcadas como {@code @Transactional} indican que deben ejecutarse dentro de una transacción,
 * gestionada por el IoC de Spring
 */
@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	public void delete(long id) {
		clienteService.delete(id);
	}
	
	public void save(Cliente cliente) {
		clienteService.save(cliente);
	}
	
	public void update(Cliente cliente) {
		clienteService.update(cliente);
	}
	
	public List<Cliente> findAll() {
		return clienteService.findAll();
	}
	
	public Cliente findById(long id) {
		return clienteService.findById(id);
	}

}
