package com.bos.DotaForce.modelos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Resultados")
public class Resultado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name ="puntuacion_partida_individual")
    private int puntuacion_por_partida_individual;

    @Column(name ="puntuacion_partida_grupal")
    private int puntuacion_por_partida_grupal;

    @Column(name ="puntuacion_partida_individual_grupal")
    private int total_puntuacion_partida_individual_grupal;

    @Column(name ="numeroMuertes")
    private int num_muertes;

    @Column(name ="numeroAsesinatos")
    private int num_asesinatos;

    @Column(name ="oroAcumulado")
    private int oro_acumulado;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private Jugador jugador;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPuntuacion_por_partida_individual() {
        return puntuacion_por_partida_individual;
    }

    public void setPuntuacion_por_partida_individual(int puntuacion_por_partida_individual) {
        this.puntuacion_por_partida_individual = puntuacion_por_partida_individual;
    }

    public int getPuntuacion_por_partida_grupal() {
        return puntuacion_por_partida_grupal;
    }

    public void setPuntuacion_por_partida_grupal(int puntuacion_por_partida_grupal) {
        this.puntuacion_por_partida_grupal = puntuacion_por_partida_grupal;
    }

    public int getTotal_puntuacion_partida_individual_grupal() {
        return total_puntuacion_partida_individual_grupal;
    }

    public void setTotal_puntuacion_partida_individual_grupal(int total_puntuacion_partida_individual_grupal) {
        this.total_puntuacion_partida_individual_grupal = total_puntuacion_partida_individual_grupal;
    }

    public int getNum_muertes() {
        return num_muertes;
    }

    public void setNum_muertes(int num_muertes) {
        this.num_muertes = num_muertes;
    }

    public int getNum_asesinatos() {
        return num_asesinatos;
    }

    public void setNum_asesinatos(int num_asesinatos) {
        this.num_asesinatos = num_asesinatos;
    }

    public int getOro_acumulado() {
        return oro_acumulado;
    }

    public void setOro_acumulado(int oro_acumulado) {
        this.oro_acumulado = oro_acumulado;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    
    

}