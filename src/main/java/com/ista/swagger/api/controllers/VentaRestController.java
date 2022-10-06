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

import com.ista.swagger.api.models.entity.Venta;
import com.ista.swagger.api.models.models.services.IVentaService;

@CrossOrigin(origins = { "http://localhost:4200" })
@RestController
@RequestMapping("/api")
public class VentaRestController {
	@Autowired
	private IVentaService ventaService;

	// Metodo para Listar Cliente
	@GetMapping("/listarventa")
	public List<Venta> indext() {
		return ventaService.findAll();
	}

	// Metodo para Guardar Cliente
	@PostMapping("/guardarventa")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta Guardar(@RequestBody Venta venta) {
		return ventaService.Save(venta);
	}

	// Metodo para Eliminar Cliente
	@DeleteMapping("/eliminarventa/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void Eliminar(@PathVariable Long id) {
		ventaService.Delete(id);
	}

	// Metodo para Buscar por id un Cliente
	@GetMapping("/buscarventa/{id}")
	public Venta Buscar(@PathVariable Long id) {
		return ventaService.findById(id);
	}

	// Metodo para editar Cliente
	@PutMapping("/editarventa/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Venta actualizar(@RequestBody Venta venta, @PathVariable Long id) {
		Venta ventaActual = ventaService.findById(id);

		ventaActual.setAlmacen(venta.getAlmacen());
		ventaActual.setFecha(venta.getFecha());
		ventaActual.setTotal(venta.getTotal());
		ventaActual.setVendedor(venta.getVendedor());

		return ventaService.Save(ventaActual);
	}
}
