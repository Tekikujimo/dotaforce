package com.bos.DotaForce.servicios.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.Rol;
import com.bos.DotaForce.modelos.DTO.JugadorDTO;
import com.bos.DotaForce.servicios.repositories.JugadoresRepository;
import com.bos.DotaForce.servicios.repositories.RolesRepository;
import com.bos.DotaForce.servicios.services.JugadoresService;

@Service
public class JugadoresServiceImpl implements JugadoresService{

	@Autowired
	private JugadoresRepository jugadorRepository;
	
	@Autowired
	private RolesRepository rolesRepository;
	
	@Override
	public List<Jugador> ObtenerTodosLosJugadores() {
		// TODO Auto-generated method stub
		return jugadorRepository.findAll();
	}

	@Override
	@Transactional
	public Jugador saveJugador(JugadorDTO jugadorDTO) {
		Jugador player = new Jugador();
		Set<Rol> rolesPlayer = new HashSet<>();
		
		player.setId(jugadorDTO.getId());
		player.setEdad(jugadorDTO.getEdad());
		player.setNickname(jugadorDTO.getNickname());
		player.setNombre(jugadorDTO.getNombre());
		player.setPais(jugadorDTO.getPais());
		player.setFechaNacimiento(jugadorDTO.getFechaNacimiento());
		jugadorDTO.getRoles().forEach(rolId->{
			Rol rol = rolesRepository.findRolById(rolId);
			rolesPlayer.add(rol);
		});
		player.setRoles(rolesPlayer);

		return jugadorRepository.save(player);				
	}

	@Override
	public Optional<Jugador> obtenerJugador(Long idJugador) {
		return jugadorRepository.findById(idJugador);
	}

	@Override
	@Transactional
	public void borrarJugador(Long idJugador) {
		jugadorRepository.deleteById(idJugador);
	}

}
