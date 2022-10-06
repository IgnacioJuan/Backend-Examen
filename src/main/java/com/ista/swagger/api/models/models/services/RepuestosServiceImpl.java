package com.ista.swagger.api.models.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ista.swagger.api.models.dao.IRepuestosDao;
import com.ista.swagger.api.models.entity.Repuestos;

@Service
public class RepuestosServiceImpl implements IRepuestosService{

	@Autowired
	private IRepuestosDao repuestosDao;
	@Override
	@Transactional (readOnly = true)
	public List<Repuestos> findAll() {
		// TODO Auto-generated method stub
		return (List<Repuestos>) repuestosDao.findAll();
	}

	@Override
	@Transactional 
	public Repuestos Save(Repuestos repuestos) {
		// TODO Auto-generated method stub
		return repuestosDao.save(repuestos);
	}

	@Override
	@Transactional 
	public void Delete(Long id) {
		// TODO Auto-generated method stub
		repuestosDao.deleteById(id);
	}

	@Override
	@Transactional (readOnly = true)
	public Repuestos findById(Long id) {
		// TODO Auto-generated method stub
		return repuestosDao.findById(id).orElse(null);
	}

}
