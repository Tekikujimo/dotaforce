package com.bos.DotaForce.presentacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;
import com.bos.DotaForce.modelos.DTO.JugadorResultadosTotalesDTO;
import com.bos.DotaForce.servicios.services.ResultadosService;

@RestController
@RequestMapping("/results")
public class ResultadosController {
	
	@Autowired
	ResultadosService resultadosService;
	
	@RequestMapping(value = "/getAll" , method=RequestMethod.GET)
	public List<JugadorResultadoDTO> obtenerResultadosExistentes(){
		return resultadosService.ObtenerTodosLosResultados();
	}
	
	@RequestMapping(value = "/saveResult" , method=RequestMethod.POST)
	public Resultado guardarResultado(@RequestBody JugadorResultadoDTO resultado){
		return resultadosService.saveResultado(resultado);
	}
	
	@RequestMapping(value="/getResult/{idResultado}", method=RequestMethod.GET)
	public ResponseEntity<JugadorResultadoDTO> obtenerJugador(@PathVariable Long idResultado){
		JugadorResultadoDTO resultado = resultadosService.obtenerResultado(idResultado);
		return ResponseEntity.ok(resultado);
	}
	
	@RequestMapping(value="/deleteResult/{idResultado}", method=RequestMethod.DELETE)
	public void borrarJugador(@PathVariable Long idResultado){
		resultadosService.borrarResultado(idResultado);
	}
	
	@RequestMapping(value="/getResultsByPlayer/{idPlayer}", method=RequestMethod.GET)
	public List<JugadorResultadoDTO> obtenerResultadosPorJugador(@PathVariable Long idPlayer){
		return resultadosService.obtenerResultadosPorJugador(idPlayer);		
	}

	@RequestMapping(value="/getTotalResultsWithPlayers", method=RequestMethod.GET)
	public List<JugadorResultadosTotalesDTO> obtenerResultadosTotalesConJugadores(){
		return resultadosService.obtenerResultadosTotalesConJugadores();		
	}
	
	
}
