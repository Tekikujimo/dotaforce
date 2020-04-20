package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Pais;
import com.bos.DotaForce.servicios.repositories.PaisesRepository;
import com.bos.DotaForce.servicios.services.PaisesService;

@Service
public class PaisesServiceImpl implements PaisesService {

	@Autowired
	PaisesRepository paisesRepository;
	
	@Override
	public List<Pais> obtenerPaises() {
		// TODO Auto-generated method stub
		return paisesRepository.findAll();
	}

}
