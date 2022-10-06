package com.ista.swagger.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.swagger.api.models.entity.Venta;

public interface IVentaDao extends CrudRepository<Venta,Long>{

}
