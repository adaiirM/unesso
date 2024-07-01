package com.example.unesso.model;


import jakarta.persistence.*;

@Entity
@Table(name = "catarea")
public class CatArea {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idCatArea;

    @Column(name = "area")
    private String nombreArea;

    public Integer getIdCatArea() {
        return idCatArea;
    }

    public void setIdCatArea(Integer idCatArea) {
        this.idCatArea = idCatArea;
    }

    public String getNombreArea() {
        return nombreArea;
    }

    public void setNombreArea(String nombreArea) {
        this.nombreArea = nombreArea;
    }

    @Override
    public String toString() {
        return "CatArea{" +
                "idCatArea=" + idCatArea +
                ", area='" + nombreArea + '\'' +
                '}';
    }
}
