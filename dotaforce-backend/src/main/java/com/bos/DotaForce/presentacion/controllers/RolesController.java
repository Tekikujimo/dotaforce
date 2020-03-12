package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Rol;
import com.bos.DotaForce.servicios.services.RolesService;

@RestController
@RequestMapping("/roles")
public class RolesController {
	
	@Autowired
	RolesService rolesService;
	
	@RequestMapping(value = "/getAll" , method=RequestMethod.GET)
	public List<Rol> obtenerResultadosExistentes(){
		return rolesService.ObtenerTodosLosRoles();
	}
}
