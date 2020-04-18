package com.bos.DotaForce.presentacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.servicios.services.ResultadosService;

@RestController
@RequestMapping("/results")
public class ResultadosController {
	
	@Autowired
	ResultadosService resultadosService;
	
	@RequestMapping(value = "/getAll" , method=RequestMethod.GET)
	public List<Resultado> obtenerResultadosExistentes(){
		return resultadosService.ObtenerTodosLosResultados();
	}
	
	@RequestMapping(value = "/saveResult" , method=RequestMethod.POST)
	public Resultado guardarResultado(Resultado resultado){
		return resultadosService.saveResultado(resultado);
	}
	
	
	
}
