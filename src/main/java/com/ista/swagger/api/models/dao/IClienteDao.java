package com.ista.swagger.api.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ista.swagger.api.models.entity.Cliente;


public interface IClienteDao extends CrudRepository<Cliente,Long>{

}
