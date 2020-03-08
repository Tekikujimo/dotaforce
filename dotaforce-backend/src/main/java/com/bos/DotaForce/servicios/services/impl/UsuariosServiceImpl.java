package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Usuario;
import com.bos.DotaForce.servicios.repositories.UsuariosRepository;
import com.bos.DotaForce.servicios.services.UsuariosService;

@Service
public class UsuariosServiceImpl implements UsuariosService{
	
	@Autowired
	UsuariosRepository usuarioRepository;

	@Override
	public List<Usuario> ObtenerTodosLosUsuarios() {
		// TODO Auto-generated method stub
		return usuarioRepository.findAll();
	}

}
