package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Pais;
import com.bos.DotaForce.servicios.services.PaisesService;


@RestController
@RequestMapping("/paises")
public class PaisesController {
	@Autowired
	PaisesService paisesService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Pais> obtenerDatosJugadores(){
		List<Pais> heroes = paisesService.obtenerPaises();
		return heroes;
	}
}
