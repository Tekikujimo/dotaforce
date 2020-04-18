package com.bos.DotaForce.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Resultados")
public class Resultado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column(name ="heroe")
    private String heroe;
    
    @Column(name ="numeroAsesinatos")
    private int numAsesinatos;

    @Column(name ="numeroMuertes")
    private int numMuertes;

    @Column(name ="oroAcumulado")
    private int oroAcumulado;
    
    @Column(name ="resultado")
    private String resultado;
    
    @Column(name ="puntos")
    private int puntos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHeroe() {
		return heroe;
	}

	public void setHeroe(String heroe) {
		this.heroe = heroe;
	}

	public int getNumAsesinatos() {
		return numAsesinatos;
	}

	public void setNumAsesinatos(int numAsesinatos) {
		this.numAsesinatos = numAsesinatos;
	}

	public int getNumMuertes() {
		return numMuertes;
	}

	public void setNumMuertes(int numMuertes) {
		this.numMuertes = numMuertes;
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

    /*@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Jugador.class, mappedBy="resultado")
    private Jugador jugador;*/


    
}