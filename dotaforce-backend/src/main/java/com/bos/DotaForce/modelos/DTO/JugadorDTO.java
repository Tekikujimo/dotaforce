package com.bos.DotaForce.modelos.DTO;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Type;



public class JugadorDTO {
	
    private Long id;
    
    private String nombre;

    private String nickname;
    
    private int edad;
    
    @Type(type = "date")
    private Date fechaNacimiento;

    private String pais;
    
    private List<Long> roles;
    
    private List<Long> resultado;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<Long> getRoles() {
		return roles;
	}

	public void setRoles(List<Long> roles) {
		this.roles = roles;
	}

	public List<Long> getResultado() {
		return resultado;
	}

	public void setResultado(List<Long> resultado) {
		this.resultado = resultado;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
    
    

}
