package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Usuario;
import com.bos.DotaForce.servicios.services.UsuariosService;

@RestController
@RequestMapping("/users")
public class UsuarioController {
	
	@Autowired
	UsuariosService usuarioService;
	
	@RequestMapping(value = "/getAll", method=RequestMethod.GET)
	public List<Usuario> obtenerUsuariosExistentes(){
		return usuarioService.ObtenerTodosLosUsuarios();
	}
}
