package com.ista.swagger.api.models.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.swagger.api.models.dao.IDetalle_VentaDao;
import com.ista.swagger.api.models.dao.IVentaDao;
import com.ista.swagger.api.models.entity.Venta;

@Service
public class VentaServiceImpl implements IVentaService{

	@Autowired
	private IVentaDao ventaDao;
	
	@Override
	@Transactional (readOnly = true)
	public List<Venta> findAll() {
		// TODO Auto-generated method stub
		return (List<Venta>) ventaDao.findAll();
	}

	@Override
	@Transactional 
	public Venta Save(Venta venta) {
		// TODO Auto-generated method stub
		return ventaDao.save(venta);
	}

	@Override
	@Transactional 
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		ventaDao.deleteById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public Venta findById(Long id) {
		// TODO Auto-generated method stub
		return ventaDao.findById(id).orElse(null);
	}

}
