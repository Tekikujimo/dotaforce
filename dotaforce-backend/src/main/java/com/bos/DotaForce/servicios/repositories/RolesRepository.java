package com.bos.DotaForce.servicios.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bos.DotaForce.modelos.Rol;

@Repository
public interface RolesRepository extends JpaRepository<Rol, Long> {
	
	Rol findRolById(Long id);


}
