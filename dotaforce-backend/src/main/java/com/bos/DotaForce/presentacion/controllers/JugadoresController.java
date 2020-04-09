package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.servicios.services.JugadoresService;

@RestController
@RequestMapping("/players")
public class JugadoresController {
	
	@Autowired
	JugadoresService jugadoresService;

	@RequestMapping(value="/getAll", method=RequestMethod.GET)
	public List<Jugador> obtenerDatosJugadores(){
		List<Jugador> jugadores = jugadoresService.ObtenerTodosLosJugadores();
		return jugadores;
	}
	
	@RequestMapping(value="/savePlayer", method=RequestMethod.POST)
	public Jugador guardarJugador(@RequestBody Jugador jugador){
		Jugador player = jugadoresService.saveJugador(jugador);
		return player;
	}
}
