package com.bos.DotaForce.servicios.services;

import java.util.List;
import java.util.Optional;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.DTO.JugadorDTO;


public interface JugadoresService {

	List<Jugador> ObtenerTodosLosJugadores();
	
	Jugador saveJugador(JugadorDTO jugadorDTO);
	
	Optional<Jugador> obtenerJugador(Long idJugador);
}
