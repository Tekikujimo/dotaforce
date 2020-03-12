package com.bos.DotaForce.servicios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Resultado;

@Repository
public interface ResultadosRepository extends JpaRepository<Resultado, Long> {

}
