package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catServicios")
public class CatServicios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatServicios;
	
	private String nombreServicios;
	
	
	public Integer getIdCatServicios() {
		return idCatServicios;
	}
	public void setIdCatServicios(Integer idCatServicios) {
		this.idCatServicios = idCatServicios;
	}
	public String getNombreServicios() {
		return nombreServicios;
	}
	public void setNombreServicios(String nombreServicios) {
		this.nombreServicios = nombreServicios;
	}
	@Override
	public String toString() {
		return "CatServicios [idCatServicios=" + idCatServicios + ", nombreServicios=" + nombreServicios + "]";
	}
	
	

}
