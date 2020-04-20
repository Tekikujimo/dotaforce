package com.bos.DotaForce.servicios.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bos.DotaForce.modelos.Heroe;
import com.bos.DotaForce.servicios.repositories.HeroesRepository;
import com.bos.DotaForce.servicios.services.HeroesService;

@Service
public class HeroesServiceImpl implements HeroesService {
	
	@Autowired
	HeroesRepository heroesRepository;

	@Override
	public List<Heroe> obtenerHeroes() {
		// TODO Auto-generated method stub
		return heroesRepository.findAll();
	}

}
