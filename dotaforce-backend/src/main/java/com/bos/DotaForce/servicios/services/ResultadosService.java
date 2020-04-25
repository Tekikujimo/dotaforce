package com.bos.DotaForce.servicios.services;

import java.util.List;

import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;

public interface ResultadosService {
	List<JugadorResultadoDTO> ObtenerTodosLosResultados();
	
	Resultado saveResultado(JugadorResultadoDTO resultado);
	
}
