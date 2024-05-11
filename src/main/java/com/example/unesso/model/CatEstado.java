package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catEstado")
public class CatEstado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatEstado;
	
	private String nombreEstado;

	
	
	public Integer getIdCatEstado() {
		return idCatEstado;
	}

	public void setIdCatEstado(Integer idCatEstado) {
		this.idCatEstado = idCatEstado;
	}

	public String getNombreEstado() {
		return nombreEstado;
	}

	public void setNombreEstado(String nombreEstado) {
		this.nombreEstado = nombreEstado;
	}

	@Override
	public String toString() {
		return "CatEstado [idCatEstado=" + idCatEstado + ", nombreEstado=" + nombreEstado + "]";
	}
	
	
	
	

}
