package com.bos.DotaForce.modelos.DTO;

import java.util.Date;

import org.hibernate.annotations.Type;

import com.bos.DotaForce.modelos.Jugador;

public class JugadorResultadoDTO {
	
	private Long id;
	private Jugador jugador;
	private String heroe;
	private String rol;
	private int asesinatos;
	private int muertes;
	private int oroAcumulado;
	private String resultado;
	private int puntos;
    @Type(type = "date")
    private Date fechaPartida;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public String getHeroe() {
		return heroe;
	}
	public void setHeroe(String heroe) {
		this.heroe = heroe;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public int getAsesinatos() {
		return asesinatos;
	}
	public void setAsesinatos(int asesinatos) {
		this.asesinatos = asesinatos;
	}
	public int getMuertes() {
		return muertes;
	}
	public void setMuertes(int muertes) {
		this.muertes = muertes;
	}
	public int getOroAcumulado() {
		return oroAcumulado;
	}
	public void setOroAcumulado(int oroAcumulado) {
		this.oroAcumulado = oroAcumulado;
	}
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	public int getPuntos() {
		return puntos;
	}
	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	public Date getFechaPartida() {
		return fechaPartida;
	}
	public void setFechaPartida(Date fechaPartida) {
		this.fechaPartida = fechaPartida;
	}
	
	
	
}
