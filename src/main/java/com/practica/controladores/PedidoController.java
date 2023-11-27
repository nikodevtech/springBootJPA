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
		pedidoService.delete(id);
	}
	public void save(Pedido pedido) {
		pedidoService.save(pedido);
	}
	public void update(Pedido pedido) {
		pedidoService.update(pedido);
	}
	public List<Pedido> findAll() {
		return pedidoService.findAll();
	}
	public Pedido findById(long id) {
		return pedidoService.findById(id);
	}

}
