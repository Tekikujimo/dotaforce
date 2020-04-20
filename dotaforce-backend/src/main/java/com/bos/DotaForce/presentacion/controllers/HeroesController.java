package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Heroe;
import com.bos.DotaForce.servicios.services.HeroesService;


@RestController
@RequestMapping("/heroes")
public class HeroesController {
	
	@Autowired
	HeroesService heroesService;
	
	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Heroe> obtenerDatosJugadores(){
		List<Heroe> heroes = heroesService.obtenerHeroes();
		return heroes;
	}
}
