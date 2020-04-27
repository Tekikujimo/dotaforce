package com.bos.DotaForce.servicios.services;

import java.util.List;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;

public interface ResultadosService {
	List<JugadorResultadoDTO> ObtenerTodosLosResultados();
	
	List<JugadorResultadoDTO> obtenerResultadosPorJugador(Long idJugador);
	
	Resultado saveResultado(JugadorResultadoDTO resultado);
	
	JugadorResultadoDTO obtenerResultado(Long idResultado);
	
	void borrarResultado(Long idResultado);
	
}
