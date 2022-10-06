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

import com.ista.swagger.api.models.entity.Detalle_venta;
import com.ista.swagger.api.models.models.services.IDetalle_ventaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class Detalle_ventaRestController {
	@Autowired
	private IDetalle_ventaService detalle_ventaService;

	// Metodo para Listar Cliente
	@GetMapping("/listardetalle_venta")
	public List<Detalle_venta> indext() {
		return detalle_ventaService.findAll();
	}

	// Metodo para Guardar Cliente
	@PostMapping("/guardardetalle_venta")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalle_venta Guardar(@RequestBody Detalle_venta detalle_venta) {
		return detalle_ventaService.Save(detalle_venta);
	}

	// Metodo para Eliminar Cliente
	@DeleteMapping("/eliminardetalle_venta/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable Long id) {
		detalle_ventaService.Delete(id);
	}

	// Metodo para Buscar por id un Cliente
	@GetMapping("/buscardetalle_venta/{id}")
	public Detalle_venta Buscar(@PathVariable Long id) {
		return detalle_ventaService.findById(id);
	}

	// Metodo para editar Cliente
	@PutMapping("/editardetalle_venta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Detalle_venta actualizar(@RequestBody Detalle_venta detalle_venta, @PathVariable Long id) {
		Detalle_venta detalle_ventaActual = detalle_ventaService.findById(id);

		detalle_ventaActual.setCantidad(detalle_venta.getCantidad());
		detalle_ventaActual.setCosto(detalle_venta.getCosto());
		detalle_ventaActual.setTotal(detalle_venta.getTotal());

		return detalle_ventaService.Save(detalle_ventaActual);
	}
}
