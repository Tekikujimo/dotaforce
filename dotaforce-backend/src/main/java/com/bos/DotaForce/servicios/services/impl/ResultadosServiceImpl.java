package com.bos.DotaForce.servicios.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;
import com.bos.DotaForce.servicios.repositories.JugadoresRepository;
import com.bos.DotaForce.servicios.repositories.ResultadosRepository;
import com.bos.DotaForce.servicios.services.ResultadosService;

@Service
public class ResultadosServiceImpl implements ResultadosService {

	@Autowired
	private ResultadosRepository resultadoRepository;
	
	@Autowired
	private JugadoresRepository jugadorRepository;
	
	@Override
	public List<JugadorResultadoDTO> ObtenerTodosLosResultados() {
		List<Resultado> resultados = resultadoRepository.findResults();
		List<JugadorResultadoDTO> resultadosAMostrarFront = new ArrayList<>();
			
		if(!resultados.isEmpty()) {
			for(int i = 0 ; i < resultados.size() ; i++) {
				Resultado r = resultados.get(i);				
				resultadosAMostrarFront.add(createInstanceJugadorResultado(r));				
			}		
		}


		return resultadosAMostrarFront; 
	}

	@Override
	@Transactional
	public Resultado saveResultado(JugadorResultadoDTO resultadoDTO) {
		
		Resultado resultado = createInstanceResultado(resultadoDTO);
		Jugador jugador = resultadoDTO.getJugador();		
		resultado = resultadoRepository.save(resultado);			
		jugador.getResultados().add(resultado);		
		jugadorRepository.save(jugador);
		
		return resultado;
		//return resultadoRepository.save(resultado);
	}
	
	public JugadorResultadoDTO createInstanceJugadorResultado(Resultado r) {
		JugadorResultadoDTO jr = new JugadorResultadoDTO();
		
		jr.setAsesinatos(r.getNumAsesinatos());
		jr.setMuertes(r.getNumMuertes());
		jr.setHeroe(r.getHeroe());
		jr.setJugador(jugadorRepository.findPlayerByIdResult(r.getId()));
		jr.setFechaPartida(r.getFechaPartida());
		jr.setResultado(r.getResultado());
		jr.setPuntos(r.getPuntos());
		jr.setRol(r.getRol());
		jr.setOroAcumulado(r.getOroAcumulado());
		
		return jr;

	}	
	
	public Resultado createInstanceResultado(JugadorResultadoDTO resultadoDTO) {
		Resultado result = new Resultado();
		
		result.setNumAsesinatos(resultadoDTO.getAsesinatos());
		result.setNumMuertes(resultadoDTO.getMuertes());
		result.setOroAcumulado(resultadoDTO.getOroAcumulado());
		result.setPuntos(resultadoDTO.getPuntos());
		result.setHeroe(resultadoDTO.getHeroe());
		result.setResultado(resultadoDTO.getResultado());
		result.setFechaPartida(new Date());
		result.setRol(resultadoDTO.getRol());
		
		return result;
	}

}
