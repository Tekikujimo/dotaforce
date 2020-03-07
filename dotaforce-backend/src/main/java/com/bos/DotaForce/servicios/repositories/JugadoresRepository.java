package com.bos.DotaForce.servicios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Jugador;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugador, Long> {
	List<Jugador> findByRolesDenominacion(String denominacion);
	
	//List<Jugador> findByRolesNum_posicion(int posicion);

}
