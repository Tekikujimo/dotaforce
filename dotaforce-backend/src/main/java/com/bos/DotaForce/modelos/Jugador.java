package com.bos.DotaForce.modelos;

import java.text.DateFormat;

import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.*;

@Entity
@Table(name="Jugadores")
public class Jugador{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    
    @Column
    private String nombre;

    @Column
    private String nickname;

    @Column
    private int edad;

    @Column
    @Type(type = "date")
    private Date fechaNacimiento;

    @Column
    private String pais;

    @JoinTable(name = "jugador_roles",
            joinColumns = {@JoinColumn(name = "JUGADOR_ID_FK", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "ROL_ID_FK", referencedColumnName = "id")}
    )  
    // De Jugador --> Roles es la relacion
    // El ManyToMany solo se usara si sabemos que nuestros roles seran usados por varios jugadores
    /* Si declaramos con list aparecera esta excepcion:
    org.hibernate.loader.MultipleBagFetchException: cannot simultaneously fetch multiple bags: [com.bos.DotaForce.modelos.Jugador.resultado, com.bos.DotaForce.modelos.Jugador.roles]*/
    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    private Set<Rol> roles;

    @JoinTable(name = "jugador_resultados",
            joinColumns = {@JoinColumn(name = "JUGADOR_ID_FK", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "RESULTADO_ID_FK", referencedColumnName = "id")}
    )
    // De Jugador --> resultados es la relacion
    // El OneToMany solo se usara si sabemos que nuestros resultados seran usados solo por un jugador en concreto y no por otros
    // El ManyToOne solo se usara si sabemos que un resultado sera usado por varios jugadores
    @OneToMany(fetch = FetchType.EAGER,cascade = {CascadeType.MERGE,CascadeType.REMOVE})
    private Set<Resultado> resultado;

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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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

    public Set<Rol> getRoles() {
        return roles;
    }

    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }

    public Set<Resultado> getResultado() {
        return resultado;
    }

    public void setResultado(Set<Resultado> resultado) {
        this.resultado = resultado;
    }

        

}

