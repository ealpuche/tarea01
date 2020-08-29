package com.mitocode.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.model.Venta;
import com.mitocode.repo.IGenericRepo;
import com.mitocode.repo.IVentaRepo;
import com.mitocode.service.IVentaService;

@Service
public class IVentaServiceImpl extends CRUDImpl<Venta, Integer> implements IVentaService {
	@Autowired
	private IVentaRepo repo;

	@Override
	protected IGenericRepo<Venta, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

	@Override
	public Venta registrarTransaccional(Venta venta) throws Exception {
		venta.getDetalleVenta().forEach(det -> det.setVenta(venta));
		return repo.save(venta);
	}

}
