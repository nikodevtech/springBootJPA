package com.practica.dao;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Clase DAO que representa la entidad Cliente en el sistema.
 */
@Entity
@Table(name = "cliente", schema = "jpa_practice")
public class Cliente {
	
	@Id
	@Column(name = "id_cliente")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "dni")
	private String dni;
	
	@Column(name = "email")
	private String email;
	
	@OneToMany(mappedBy = "cliente")
	List<Pedido>listaPedidos;

	public Cliente(String nombre, String dni, String email) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.email = email;
		this.listaPedidos = new ArrayList<>();
	}
	
	public Cliente() {
		
	}

	public Long getIdCliente() {
		return idCliente;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Pedido> getListaPedidos() {
		return listaPedidos;
	}

	public void setListaPedidos(List<Pedido> listaPedidos) {
		this.listaPedidos = listaPedidos;
	}
	
	public void addPedido(Pedido pedido) {
		listaPedidos.add(pedido);
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nombre=" + nombre + ", dni=" + dni + ", email=" + email
				+  "]";
	}
	
	
	

}
