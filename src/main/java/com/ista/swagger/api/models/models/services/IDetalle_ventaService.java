package com.ista.swagger.api.models.models.services;

import java.util.List;

import com.ista.swagger.api.models.entity.Detalle_venta;


public interface IDetalle_ventaService {
	
	public List<Detalle_venta> findAll();
	public Detalle_venta Save(Detalle_venta detalle_venta);
	public void Delete(Long id);
	public Detalle_venta findById(Long id);
}
