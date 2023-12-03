package com.practica.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.practica.dao.Pedido;
import com.practica.servicios.PedidoService;

/**
 * Controlador que gestiona las operaciones relacionadas con los pedidos en la capa de presentación
 * Utiliza el servicio {@link PedidoServiceImpl} para interactuar con la capa da servicio de persistencia a Pedidos
 *
 * Las operaciones marcadas como {@code @Transactional} indican que deben ejecutarse dentro de una transacción,
 * gestionada por el IoC de Spring
 */
@Controller
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	public void delete(long id) {
		try {
			pedidoService.delete(id);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void save(Pedido pedido) {
		try {
			pedidoService.save(pedido);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public void update(Pedido pedido) {
		try {
			pedidoService.update(pedido);
		}catch(Exception e) {
			e.getMessage();
		}
	}
	
	public List<Pedido> findAll() {
		try {
			return pedidoService.findAll();
		}catch(Exception e) {
			e.getMessage();
			return null;
		}	
	}
	public Pedido findById(long id) {
		try {
			return pedidoService.findById(id);
		}catch(Exception e) {
			e.getMessage();
			return null;
		}
	}
}
