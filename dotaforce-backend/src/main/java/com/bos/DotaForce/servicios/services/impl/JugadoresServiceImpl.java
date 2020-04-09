package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.servicios.repositories.JugadoresRepository;
import com.bos.DotaForce.servicios.services.JugadoresService;

@Service
public class JugadoresServiceImpl implements JugadoresService{

	@Autowired
	private JugadoresRepository jugadorRepository;
	
	@Override
	public List<Jugador> ObtenerTodosLosJugadores() {
		// TODO Auto-generated method stub
		return jugadorRepository.findAll();
	}

	@Override
	@Transactional
	public Jugador saveJugador(Jugador jugador) {
		return jugadorRepository.saveAndFlush(jugador);				
	}

}
