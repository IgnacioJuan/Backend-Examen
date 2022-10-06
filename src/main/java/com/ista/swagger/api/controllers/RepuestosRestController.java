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

import com.ista.swagger.api.models.entity.Repuestos;
import com.ista.swagger.api.models.models.services.IRepuestosService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class RepuestosRestController {
	@Autowired
	private IRepuestosService repuestosService;

	// Metodo para Listar Cliente
	@GetMapping("/listarrepuestos")
	public List<Repuestos> indext() {
		return repuestosService.findAll();
	}

	// Metodo para Guardar Cliente
	@PostMapping("/guardarrepuestos")
	@ResponseStatus(HttpStatus.CREATED)
	public Repuestos Guardar(@RequestBody Repuestos repuestos) {
		return repuestosService.Save(repuestos);
	}

	// Metodo para Eliminar Cliente
	@DeleteMapping("/eliminarrepuestos/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable Long id) {
		repuestosService.Delete(id);
	}

	// Metodo para Buscar por id un Cliente
	@GetMapping("/buscarrepuestos/{id}")
	public Repuestos Buscar(@PathVariable Long id) {
		return repuestosService.findById(id);
	}

	// Metodo para editar Cliente
	@PutMapping("/editarrepuestos/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Repuestos actualizar(@RequestBody Repuestos repuestos, @PathVariable Long id) {
		Repuestos repuestosActual = repuestosService.findById(id);

		repuestosActual.setAnio(repuestos.getAnio());
		//repuestosActual.setCodigo(repuestos.getCodigo());
		repuestosActual.setDescripcion(repuestos.getDescripcion());
		repuestosActual.setMarca(repuestos.getMarca());
		repuestosActual.setNombre(repuestos.getNombre());
		repuestosActual.setTipo(repuestos.getTipo());

		return repuestosService.Save(repuestosActual);
	}
}
