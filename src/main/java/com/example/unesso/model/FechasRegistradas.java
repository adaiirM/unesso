package com.example.unesso.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="fechasRegistradas")
public class FechasRegistradas {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idFechasRegistradas;

    private Date fechaInicio;
    private Date fechaFin;

    @OneToOne
    @JoinColumn(name="idCatCarrera")
    private CatCarrera carrera;

    public Integer getIdFechasRegistradas() {
        return idFechasRegistradas;
    }

    public void setIdFechasRegistradas(Integer idFechasRegistradas) {
        this.idFechasRegistradas = idFechasRegistradas;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public CatCarrera getCarrera() {
        return carrera;
    }

    public void setCarrera(CatCarrera carrera) {
        this.carrera = carrera;
    }
}
