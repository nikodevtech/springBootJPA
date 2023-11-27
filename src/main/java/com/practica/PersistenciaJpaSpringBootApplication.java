package com.practica;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.practica.controladores.ClienteController;
import com.practica.controladores.PedidoController;
import com.practica.dao.Cliente;
import com.practica.dao.Pedido;

@SpringBootApplication
public class PersistenciaJpaSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(PersistenciaJpaSpringBootApplication.class, args);
		
		ClienteController clienteController = context.getBean(ClienteController.class);
		PedidoController pedidoController = context.getBean(PedidoController.class);
		
		Cliente cliente1 = new Cliente("Nico","30242873N","noemail@no.com");
		Cliente cliente2 = new Cliente("Laura","56222928N","noemail@no.com");
		
		clienteController.save(cliente1);
		clienteController.save(cliente2);
		
		Pedido pedidoCliente1 = new Pedido("2023/11/26","pagado",cliente1);
		Pedido pedido2Cliente1 = new Pedido("2023/11/22","entregado", cliente1);
		
		cliente1.addPedido(pedidoCliente1);
		cliente1.addPedido(pedido2Cliente1);
		
		pedidoController.save(pedidoCliente1);
		pedidoController.save(pedido2Cliente1);
		
		for(Cliente c : clienteController.findAll()) {
			System.out.println(c.toString());
		}
		for(Pedido p : pedidoController.findAll()) {
			System.out.println(p.toString());
		}
		

		
		
		
	}

}
