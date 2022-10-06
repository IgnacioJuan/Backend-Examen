package com.ista.swagger.api.models.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.swagger.api.models.dao.IDetalle_VentaDao;
import com.ista.swagger.api.models.entity.Detalle_venta;

@Service
public class Detalle_ventaServiceImpl implements IDetalle_ventaService{
	
	@Autowired
	private IDetalle_VentaDao detalle_VentaDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Detalle_venta> findAll() {
		// TODO Auto-generated method stub
		return (List<Detalle_venta>) detalle_VentaDao.findAll();
	}

	@Override
	@Transactional 
	public Detalle_venta Save(Detalle_venta detalle_venta) {
		// TODO Auto-generated method stub
		return detalle_VentaDao.save(detalle_venta);
	}

	@Override
	@Transactional
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		detalle_VentaDao.deleteById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public Detalle_venta findById(Long id) {
		// TODO Auto-generated method stub
		return detalle_VentaDao.findById(id).orElse(null);
	}

}
