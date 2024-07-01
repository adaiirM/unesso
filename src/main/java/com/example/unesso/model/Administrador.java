package com.example.unesso.model;

import jakarta.persistence.*;

@Entity
@Table(name = "administrador")
public class Administrador {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idAdministrador;

    @Column(name = "nombreAdministrador")
    private String nombre;
    private String ApellidoP;
    private String ApellidoM;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    // Getters and Setters

    public Integer getIdAdministrador() {
        return idAdministrador;
    }

    public void setIdAdministrador(Integer idAdministrador) {
        this.idAdministrador = idAdministrador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return ApellidoP;
    }

    public void setApellidoP(String apellidoP) {
        ApellidoP = apellidoP;
    }

    public String getApellidoM() {
        return ApellidoM;
    }

    public void setApellidoM(String apellidoM) {
        ApellidoM = apellidoM;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Administrador{" +
                "idAdministrador=" + idAdministrador +
                ", nombreAdministrador='" + nombre + '\'' +
                ", ApellidoP='" + ApellidoP + '\'' +
                ", ApellidoM='" + ApellidoM + '\'' +
                ", usuario=" + usuario +
                '}';
    }
}
