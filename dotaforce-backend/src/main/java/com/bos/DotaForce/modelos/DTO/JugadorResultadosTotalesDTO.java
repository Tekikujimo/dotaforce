package com.bos.DotaForce.modelos.DTO;

import com.bos.DotaForce.modelos.Jugador;

public class JugadorResultadosTotalesDTO {
	
	private Jugador jugador;
	private int totalAsesinatos;
	private int totalMuertes;
	private int totalOroAcumulado;
	private int totalPuntos;
	
	public JugadorResultadosTotalesDTO() {
		
	}
	
	public JugadorResultadosTotalesDTO(Jugador jugador, int totalAsesinatos, int totalMuertes, int totalOroAcumulado,
			int totalPuntos) {
		super();
		this.jugador = jugador;
		this.totalAsesinatos = totalAsesinatos;
		this.totalMuertes = totalMuertes;
		this.totalOroAcumulado = totalOroAcumulado;
		this.totalPuntos = totalPuntos;
	}
	
	public Jugador getJugador() {
		return jugador;
	}
	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}
	public int getTotalAsesinatos() {
		return totalAsesinatos;
	}
	public void setTotalAsesinatos(int totalAsesinatos) {
		this.totalAsesinatos = totalAsesinatos;
	}
	public int getTotalMuertes() {
		return totalMuertes;
	}
	public void setTotalMuertes(int totalMuertes) {
		this.totalMuertes = totalMuertes;
	}
	public int getTotalOroAcumulado() {
		return totalOroAcumulado;
	}
	public void setTotalOroAcumulado(int totalOroAcumulado) {
		this.totalOroAcumulado = totalOroAcumulado;
	}
	public int getTotalPuntos() {
		return totalPuntos;
	}
	public void setTotalPuntos(int totalPuntos) {
		this.totalPuntos = totalPuntos;
	}
	
	


}
