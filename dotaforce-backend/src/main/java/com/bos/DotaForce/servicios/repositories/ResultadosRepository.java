package com.bos.DotaForce.servicios.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Resultado;

@Repository
public interface ResultadosRepository extends JpaRepository<Resultado, Long> {
	@Query(value="SELECT * FROM RESULTADOS r join JUGADOR_RESULTADOS jr on r.ID = jr.RESULTADO_ID_FK",nativeQuery=true)
	List<Resultado> findResults();
}
