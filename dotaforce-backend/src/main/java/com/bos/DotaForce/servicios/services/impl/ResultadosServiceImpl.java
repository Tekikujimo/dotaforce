package com.bos.DotaForce.servicios.services.impl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;
import com.bos.DotaForce.modelos.DTO.JugadorResultadosTotalesDTO;
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
		
		Boolean existeResultado = false;
		
		Resultado resultado = createInstanceResultado(resultadoDTO);
		Jugador jugador = resultadoDTO.getJugador();		
		resultado = resultadoRepository.save(resultado);	
		
		List<Resultado> resultsBBDD = resultadoRepository.findResultsByJugadorId(jugador.getId());
		
		for(int y = 0 ; y<resultsBBDD.size() ; y++) {
			Resultado resultLoop = resultsBBDD.get(y);
			if(resultLoop.getId().equals(resultado.getId())) {
				existeResultado = true;
				break;
			}
		}
		
		//Esto es para comprobar si es una alta de nuevo resultado y prevenir el error de Multiple representations of the same entity [com.bos.DotaForce.modelos.Resultado#30] are being merged. Managed
		if(!existeResultado) {
			jugador = jugadorRepository.findPlayerById(jugador.getId());
			jugador.getResultados().add(resultado);		
			jugadorRepository.save(jugador);			
		}
		
			
		return resultado;
		//return resultadoRepository.save(resultado);
	}
	
	public JugadorResultadoDTO createInstanceJugadorResultado(Resultado r) {
		JugadorResultadoDTO jr = new JugadorResultadoDTO();
		
		if(r.getId() != null) {
			jr.setId(r.getId());
		}
				
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
		
		if(resultadoDTO.getId() != null) {
			result.setId(resultadoDTO.getId());	
		}
		
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

	@Override
	public JugadorResultadoDTO obtenerResultado(Long idResultado) {
		Resultado r = resultadoRepository.findResultById(idResultado);
		JugadorResultadoDTO jrdto = createInstanceJugadorResultado(r);		
		return jrdto ;
	}

	
	@Override
	public void borrarResultado(Long idResultado) {
		resultadoRepository.deleteRelationPlayerResultByResultId(idResultado);
		resultadoRepository.deleteResultById(idResultado);	

	}

	@Override
	public List<JugadorResultadoDTO> obtenerResultadosPorJugador(Long idJugador) {
		List<Resultado> resultados = resultadoRepository.findResultsByJugadorId(idJugador);
		List<JugadorResultadoDTO> resultadosDTO = new ArrayList<JugadorResultadoDTO>();		
		for(int i=0 ; i< resultados.size() ; i++) {
			resultadosDTO.add(createInstanceJugadorResultado(resultados.get(i)));
		}		
		return resultadosDTO;
	}

	@Override
	public List<JugadorResultadosTotalesDTO> obtenerResultadosTotalesConJugadores() {
		/*
		 Object[0] idJugador
		 Object[1] totalAsesinatos 
		 Object[2] totalMuertes
		 Object[3] totalOroAcumulado 
		 Object[4] totalPuntos
		 */
		
		List<JugadorResultadosTotalesDTO> resultadosTotalesAMostrarFront = new ArrayList<JugadorResultadosTotalesDTO>();
		
		List<Object[]> totalResultsWithPlayers = resultadoRepository.findTotalResultsWithPlayers();
		
		for(int z = 0 ; z < totalResultsWithPlayers.size() ; z++) {
			Object[] totalResultAndPlayer = totalResultsWithPlayers.get(z);				
	        Integer idJugador = ((BigDecimal) totalResultAndPlayer[0]).intValue();
	        Integer totalAsesinatos =  ((BigDecimal) totalResultAndPlayer[1]).intValue();
	        Integer totalMuertes =  ((BigDecimal) totalResultAndPlayer[2]).intValue();
	        Integer totalOroAcumulado =  ((BigDecimal) totalResultAndPlayer[3]).intValue();
	        Integer totalPuntos =  ((BigDecimal) totalResultAndPlayer[4]).intValue(); 	         
			Jugador j = jugadorRepository.findPlayerById(Long.valueOf(idJugador));
			JugadorResultadosTotalesDTO jrtdto = new JugadorResultadosTotalesDTO(j,totalAsesinatos,totalMuertes,totalOroAcumulado,totalPuntos); 
			resultadosTotalesAMostrarFront.add(jrtdto);
		}
		
		return resultadosTotalesAMostrarFront;
	}

}
