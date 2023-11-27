package com.practica.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.dao.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

/**
 * Implementación de la interfaz {@link PedidoService} que proporciona
 * servicios relacionados con las pedidos. Esta clase utiliza JPA para
 * interactuar con la capa de persistencia
 * 
 * {@code @PersistenceContext}: El Ioc de Spring inyecta un EM ya configurado en
 * el properties para trabajar con la persistencia
 */
@Service
public class PedidoServiceImpl implements PedidoService {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void save(Pedido pedido) {
		entityManager.persist(pedido);
	}

	@Override
	@Transactional
	public void delete(long id) {
		Pedido p = entityManager.find(Pedido.class,id);
		if(p != null) {
			entityManager.remove(p);
		}
	}

	@Override
	@Transactional
	public void update(Pedido pedido) {
		entityManager.merge(pedido);
	}

	@Override
	@Transactional
	public List<Pedido> findAll() {
		return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
	}

	@Override
	@Transactional
	public Pedido findById(long id) {
		return entityManager.find(Pedido.class, id);
	}

}
