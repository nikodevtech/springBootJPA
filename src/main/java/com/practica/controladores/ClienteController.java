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
		try {
			clienteService.delete(id);
		} catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void save(Cliente cliente) {
		try {
			clienteService.save(cliente);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void update(Cliente cliente) {
		try {
			clienteService.update(cliente);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public List<Cliente> findAll() {
		try {
			return clienteService.findAll();
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public Cliente findById(long id) {
		try {
			return clienteService.findById(id);
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
	}
	
	public List<Cliente> findByDni(String dni) {
		try {
			return clienteService.findByDni(dni);
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
	}

}
