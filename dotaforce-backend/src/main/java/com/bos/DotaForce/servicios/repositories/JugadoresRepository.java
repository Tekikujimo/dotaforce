package com.bos.DotaForce.servicios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Jugador;
import com.bos.DotaForce.modelos.Resultado;

@Repository
public interface JugadoresRepository extends JpaRepository<Jugador, Long> {
	List<Jugador> findByRolesDenominacion(String denominacion);
	
	@Query(value="SELECT * FROM JUGADORES j join JUGADOR_RESULTADOS jr on j.ID = jr.JUGADOR_ID_FK AND jr.RESULTADO_ID_FK=?1",nativeQuery=true)
	Jugador findPlayerByIdResult(Long idResult);
	
	//List<Jugador> findByRolesNum_posicion(int posicion);

}
