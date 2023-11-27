package com.practica.dao;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase DAO que representa la entidad Pedido en el sistema.
 */
@Entity
@Table(name = "pedido", schema = "jpa_practice")
public class Pedido {
	
	@Id
	@Column(name = "id_pedido")
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private long idPedido;
	@Column(name = "fecha_pedido")
	private String fechaPedido;
	@Column(name = "estado_pedido")
	private String estadoPedido;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id_fk")
	Cliente cliente;
	
	public Pedido() {
		
	}
	
	public Pedido(String fechaPedido, String estadoPedido, Cliente cliente) {
		super();
		this.fechaPedido = fechaPedido;
		this.estadoPedido = estadoPedido;
		this.cliente = cliente;
	}



	public long getId() {
		return idPedido;
	}

	public String getFecha() {
		return fechaPedido;
	}

	public void setFecha(String fecha) {
		this.fechaPedido = fecha;
	}

	public String getEstado() {
		return estadoPedido;
	}

	public void setEstado(String estado) {
		this.estadoPedido = estado;
	}
	

	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", estadoPedido=" + estadoPedido
				+ ", cliente=" + cliente.toString() + "]";
	}
	
	


	
	
	


}
