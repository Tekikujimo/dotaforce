package com.bos.DotaForce.modelos;

import javax.persistence.*;

@Entity
@Table(name = "Roles")
public class Rol{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String denominacion;

    @Column
    private int num_posicion;

    /*@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = Jugador.class,mappedBy="roles")
    private List<Jugador> jugadores;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getNum_posicion() {
        return num_posicion;
    }

    public void setNum_posicion(int num_posicion) {
        this.num_posicion = num_posicion;
    }

    /*public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }*/

    



}