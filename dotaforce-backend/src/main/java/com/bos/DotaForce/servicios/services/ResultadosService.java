package com.bos.DotaForce.servicios.services;

import java.util.List;

import com.bos.DotaForce.modelos.Resultado;

public interface ResultadosService {
	List<Resultado> ObtenerTodosLosResultados();
	
	Resultado saveResultado(Resultado resultado);
	
}
