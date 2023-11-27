package com.practica.servicios;

import java.util.List;

import com.practica.dao.Cliente;

/**
 * Interfaz que declara los servicios relacionados con los clientes.
 * Proporciona métodos para el CRUD de clientes.
 */
public interface ClienteService {
	
	/**
	 * Registra un nuevo cliente en el sistema.
	 * @param cliente El cliente a registrar
	 */
	public void save(Cliente cliente);
	/**
	 * Elimina un cliente previamente registrado en el sistema
	 * @param id El id del cliente a eliminar
	 */
	public void delete(long id);
	/**
	 * Modifica un cliente previamente persistido en el sistema
	 * @param cliente El cliente a modificar
	 */
	public void update(Cliente cliente);
	/**
	 * Obtiene todos los Clientes registrados en el sistema
	 * @return Una lista de todos los Clientes registrados
	 */
	public List<Cliente> findAll();
	/**
	 * Obtiene un Cliente por su ID previamente registrado en el sistema
	 * @param id Del cliente a obtener
	 * @return El Cliente encontrado por su id
	 */
	public Cliente findById(long id);

}
