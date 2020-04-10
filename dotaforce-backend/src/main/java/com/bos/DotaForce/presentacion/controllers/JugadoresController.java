package com.bos.DotaForce.presentacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.DTO.JugadorDTO;
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
	public ResponseEntity<Jugador> guardarJugador(@RequestBody JugadorDTO jugador){
		Jugador player = jugadoresService.saveJugador(jugador);
		return ResponseEntity.ok(player);
	}
	
	@RequestMapping(value="/getPlayer/{idJugador}", method=RequestMethod.GET)
	public ResponseEntity<Optional<Jugador>> obtenerJugador(@PathVariable Long idJugador){
		Optional<Jugador> player = jugadoresService.obtenerJugador(idJugador);
		return ResponseEntity.ok(player);
	}
}
