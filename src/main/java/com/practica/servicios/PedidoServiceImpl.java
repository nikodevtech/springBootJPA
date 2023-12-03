package com.practica.servicios;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practica.dao.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;
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
        try {
            entityManager.persist(pedido);
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al guardar el pedido: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void delete(long id) {
        try {
            Pedido p = entityManager.find(Pedido.class, id);
            if (p != null) {
                entityManager.remove(p);
            } else {
                throw new EntityNotFoundException("Pedido con ID " + id + " no encontrado");
            }
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al eliminar el pedido: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public void update(Pedido pedido) {
        try {
            entityManager.merge(pedido);
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al actualizar el pedido: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Pedido> findAll() {
        try {
            return entityManager.createQuery("SELECT p FROM Pedido p", Pedido.class).getResultList();
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al recuperar todos los pedidos: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public Pedido findById(long id) {
        try {
            return entityManager.find(Pedido.class, id);
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al recuperar el pedido por ID: " + e.getMessage());
        }
    }

    @Override
    @Transactional
    public List<Pedido> findByEstado(String estado) {
        try {
            String jpqlQuery = "SELECT p FROM Pedido p WHERE p.estadoPedido = :estadoParam";
            return entityManager.createQuery(jpqlQuery, Pedido.class)
                    .setParameter("estadoParam", estado)
                    .getResultList();
        } catch (IllegalArgumentException | PersistenceException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al recuperar pedidos por estado: " + e.getMessage());
        }
    }
}
