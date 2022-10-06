package com.ista.swagger.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ista.swagger.api.models.entity.Cliente;
import com.ista.swagger.api.models.models.services.IClienteService;


@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	@Autowired
	private IClienteService clienteService;

	// Metodo para Listar Cliente
	@GetMapping("/listarcliente")
	public List<Cliente> indext() {
		return clienteService.findAll();
	}

	// Metodo para Guardar Cliente
	@PostMapping("/guardarcliente")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente Guardar(@RequestBody Cliente cliente) {
		return clienteService.Save(cliente);
	}

	// Metodo para Eliminar Cliente
	@DeleteMapping("/eliminarcliente/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable Long id) {
		clienteService.Delete(id);
	}

	// Metodo para Buscar por id un Cliente
	@GetMapping("/buscarcliente/{id}")
	public Cliente Buscar(@PathVariable Long id) {
		return clienteService.findById(id);
	}

	// Metodo para editar Cliente
	@PutMapping("/editarcliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id) {
		Cliente clienteActual = clienteService.findById(id);
		
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setCedula(cliente.getCedula());
		clienteActual.setCelular(cliente.getCelular());
		clienteActual.setDireccion(cliente.getDireccion());
		clienteActual.setNombre(cliente.getNombre());

		return clienteService.Save(clienteActual);
	}
}
