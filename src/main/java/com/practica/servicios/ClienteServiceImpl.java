package com.practica.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.dao.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
		entityManager.persist(cliente);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Cliente c = entityManager.find(Cliente.class, id);
		if(c != null) {
			entityManager.remove(c);
		}
	}

	@Override
	@Transactional
	public void update(Cliente cliente) {
		entityManager.merge(cliente);		
	}

	@Override
	@Transactional
	public List<Cliente> findAll() {
		return entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class).getResultList();
	}

	@Override
	@Transactional
	public Cliente findById(long id) {
		return entityManager.find(Cliente.class, id);
	}

}
