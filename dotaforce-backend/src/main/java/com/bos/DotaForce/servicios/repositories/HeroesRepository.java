package com.bos.DotaForce.servicios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Heroe;

@Repository
public interface HeroesRepository extends JpaRepository<Heroe, Long> {

}
