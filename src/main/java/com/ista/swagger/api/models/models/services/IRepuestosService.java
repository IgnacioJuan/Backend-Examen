package com.ista.swagger.api.models.models.services;

import java.util.List;

import com.ista.swagger.api.models.entity.Repuestos;

public interface IRepuestosService {
	public List<Repuestos> findAll();
	public Repuestos Save(Repuestos repuestos);
	public void Delete(Long id);
	public Repuestos findById(Long id);
}
