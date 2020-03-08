package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Rol;
import com.bos.DotaForce.servicios.repositories.RolesRepository;
import com.bos.DotaForce.servicios.services.RolesService;

@Service
public class RolesServiceImpl implements RolesService{
	
	@Autowired
	RolesRepository rolesRepository;

	@Override
	public List<Rol> ObtenerTodosLosRoles() {
		// TODO Auto-generated method stub
		return rolesRepository.findAll();
	}

}
