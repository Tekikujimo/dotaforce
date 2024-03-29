package com.bos.DotaForce.servicios.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bos.DotaForce.modelos.Resultado;

@Repository
public interface ResultadosRepository extends JpaRepository<Resultado, Long> {
	@Query(value="SELECT * FROM RESULTADOS r join JUGADOR_RESULTADOS jr on r.ID = jr.RESULTADO_ID_FK",nativeQuery=true)
	List<Resultado> findResults();
	
	@Query(value="SELECT * FROM RESULTADOS r WHERE r.ID = ?1",nativeQuery=true)
	Resultado findResultById(Long idResultado);
	
	@Query(value="SELECT * FROM RESULTADOS r join JUGADOR_RESULTADOS jr on r.ID = jr.RESULTADO_ID_FK WHERE jr.JUGADOR_ID_FK=?1",nativeQuery=true)
	List<Resultado> findResultsByJugadorId(Long idJugador);
	
	@Query(value="SELECT jr.jugador_id_fk,sum(r.numero_asesinatos) as totalAsesinatos ,sum(r.numero_muertes) as totalMuertes,sum(r.oro_acumulado) as totalOroAcumulado,sum(r.puntos) as totalPuntos\r\n" + 
			"FROM RESULTADOS r \r\n" + 
			"JOIN JUGADOR_RESULTADOS jr ON r.ID = jr.RESULTADO_ID_FK\r\n" + 
			"GROUP BY jr.jugador_id_fk\r\n" + 
			"ORDER BY totalPuntos DESC,totalOroAcumulado DESC,totalMuertes DESC,totalAsesinatos DESC",nativeQuery=true)
	List<Object[]> findTotalResultsWithPlayers();
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM JUGADOR_RESULTADOS jr WHERE jr.RESULTADO_ID_FK=?1",nativeQuery=true)
	void deleteRelationPlayerResultByResultId(Long idResultado);
	
	@Transactional
	@Modifying
	@Query(value="DELETE FROM RESULTADOS r WHERE r.id=?1",nativeQuery=true)
	void deleteResultById(Long idResultado);
	
	
}
