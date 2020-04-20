package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Resultado;
import com.bos.DotaForce.servicios.repositories.ResultadosRepository;
import com.bos.DotaForce.servicios.services.ResultadosService;

@Service
public class ResultadosServiceImpl implements ResultadosService {

	@Autowired
	private ResultadosRepository resultadoRepository;
	
	@Override
	public List<Resultado> ObtenerTodosLosResultados() {
		// TODO Auto-generated method stub
		return resultadoRepository.findAll();
	}

	@Override
	public Resultado saveResultado(Resultado resultado) {
		// TODO Auto-generated method stub
		return resultadoRepository.save(resultado);
	}

}
