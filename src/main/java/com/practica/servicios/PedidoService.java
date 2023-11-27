package com.practica.servicios;

import java.util.List;

import com.practica.dao.Pedido;

/**
 * Interfaz que declara los servicios relacionados con los pedidos.
 * Proporciona métodos para el CRUD de pedidos.
 */
public interface PedidoService {
	
	/**
	 * Registra un nuevo pedido en el sistema.
	 * @param cliente El pedido a registrar
	 */
	public void save(Pedido pedido);
	/**
	 * Elimina un pedido previamente registrado en el sistema
	 * @param id El id del pedido a eliminar
	 */
	public void delete(long id);
	/**
	 * Modifica un pedido previamente persistido en el sistema
	 * @param cliente El pedido a modificar
	 */
	public void update(Pedido pedido);
	/**
	 * Obtiene todos los pedidos registrados en el sistema
	 * @return Una lista de todos los pedidos registrados
	 */
	public List<Pedido> findAll();
	/**
	 * Obtiene un Pedido por su ID previamente registrado en el sistema
	 * @param id del Pedido a obtener
	 * @return El Pedido encontrado por su id
	 */
	public Pedido findById(long id);

}
