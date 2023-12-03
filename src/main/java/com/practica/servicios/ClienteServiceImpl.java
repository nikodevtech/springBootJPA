package com.practica.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.dao.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz {@link ClienteService} que proporciona
 * servicios relacionados con las clientes. Esta clase utiliza JPA para
 * interactuar con la capa de persistencia
 * 
 * {@code @PersistenceContext}: El Ioc de Spring inyecta un EM ya configurado en
 * el properties para trabajar con la persistencia
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void save(Cliente cliente) {
		try {
			entityManager.persist(cliente);
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al insertar el cliente: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public void delete(long id) {
		try {
			Cliente c = entityManager.find(Cliente.class, id);
			if (c != null) {
				entityManager.remove(c);
			} else {
				throw new EntityNotFoundException("Cliente con ID " + id + " no encontrado");
			}
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al eliminar el cliente: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		try {
			entityManager.merge(cliente);
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al actualizar el cliente: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		try {
			return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al recuperar todos los clientes: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public Cliente findById(long id) {
		try {
			return entityManager.find(Cliente.class, id);
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al recuperar el cliente por ID: " + e.getMessage());
		}
	}

	@Override
	@Transactional
	public List<Cliente> findByDni(String dni) {
		try {
			String queryJPQL = "SELECT c FROM Cliente c WHERE c.dni = :dniParam";
			return entityManager.createQuery(queryJPQL, Cliente.class)
								.setParameter("dniParam", dni)
								.getResultList();
		} catch (IllegalArgumentException | PersistenceException e) {
			e.printStackTrace();
			throw new RuntimeException("Error al recuperar clientes por DNI: " + e.getMessage());
		}
	}

}
