package com.ista.swagger.api.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_ventas")
public class Detalle_venta implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long id_venta;
	private Long id_repuesto;
	private int cantidad;
	private double costo;
	private double total;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_venta() {
		return id_venta;
	}
	public void setId_venta(Long id_venta) {
		this.id_venta = id_venta;
	}
	public Long getId_repuesto() {
		return id_repuesto;
	}
	public void setId_repuesto(Long id_repuesto) {
		this.id_repuesto = id_repuesto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
		
	
}
