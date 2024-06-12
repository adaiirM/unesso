package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catCodigoPostal")
public class CatCodigoPostal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatCodigoPostal;
	
	private String numeroCodigoPostal;
	
	

	public Integer getIdCatCodigoPostal() {
		return idCatCodigoPostal;
	}

	public void setIdCatCodigoPostal(Integer idCatCodigoPostal) {
		this.idCatCodigoPostal = idCatCodigoPostal;
	}

	public String getNumeroCodigoPostal() {
		return numeroCodigoPostal;
	}

	public void setNumeroCodigoPostal(String numeroCodigoPostal) {
		this.numeroCodigoPostal = numeroCodigoPostal;
	}

	@Override
	public String toString() {
		return "CatCodigoPostal [idCatCodigoPostal=" + idCatCodigoPostal + ", numeroCodigoPostal=" + numeroCodigoPostal
				+ "]";
	}
	
	
	
}
