package com.ista.swagger.api.models.models.services;

import java.util.List;

import com.ista.swagger.api.models.entity.Cliente;


public interface IClienteService {
	public List<Cliente> findAll();
	public Cliente Save(Cliente cliente);
	public void Delete(Long id);
	public Cliente findById(Long id);
}
