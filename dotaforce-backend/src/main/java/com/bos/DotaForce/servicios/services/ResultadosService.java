package com.bos.DotaForce.servicios.services;

import java.util.List;
import java.util.Optional;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;

public interface ResultadosService {
	List<JugadorResultadoDTO> ObtenerTodosLosResultados();
	
	Resultado saveResultado(JugadorResultadoDTO resultado);
	
	JugadorResultadoDTO obtenerResultado(Long idResultado);
	
	void borrarResultado(Long idResultado);
	
}
