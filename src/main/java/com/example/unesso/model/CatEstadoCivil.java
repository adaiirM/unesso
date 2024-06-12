package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catEstadoCivil")
public class CatEstadoCivil {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatEstadoCivil;
	
	private String nombreEstadoCivil;
	
	
	
	public Integer getIdCatEstadoCivil() {
		return idCatEstadoCivil;
	}
	public void setIdCatEstadoCivil(Integer idCatEstadoCivil) {
		this.idCatEstadoCivil = idCatEstadoCivil;
	}
	public String getNombreEstadoCivil() {
		return nombreEstadoCivil;
	}
	public void setNombreEstadoCivil(String nombreEstadoCivil) {
		this.nombreEstadoCivil = nombreEstadoCivil;
	}
	@Override
	public String toString() {
		return "CatEstadoCivil [idCatEstadoCivil=" + idCatEstadoCivil + ", nombreEstadoCivil=" + nombreEstadoCivil
				+ "]";
	}
	
	

}
