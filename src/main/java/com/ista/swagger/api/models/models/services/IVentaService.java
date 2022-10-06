package com.ista.swagger.api.models.models.services;

import java.util.List;

import com.ista.swagger.api.models.entity.Venta;

public interface IVentaService {
	public List<Venta> findAll();
	public Venta Save(Venta venta);
	public void Delete(Long id);
	public Venta findById(Long id);
}
