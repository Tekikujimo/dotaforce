package com.bos.DotaForce.servicios.services;

import java.util.List;
import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.modelos.DTO.JugadorResultadoDTO;
import com.bos.DotaForce.modelos.DTO.JugadorResultadosTotalesDTO;

public interface ResultadosService {
	List<JugadorResultadoDTO> ObtenerTodosLosResultados();
	
	List<JugadorResultadoDTO> obtenerResultadosPorJugador(Long idJugador);
	
	Resultado saveResultado(JugadorResultadoDTO resultado);
	
	JugadorResultadoDTO obtenerResultado(Long idResultado);
	
	void borrarResultado(Long idResultado);
	
	List<JugadorResultadosTotalesDTO> obtenerResultadosTotalesConJugadores();
	
}
