package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catParentesco")
public class CatParentesco {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatParentesco;
	
	private String nombreParentesco;
	

	public Integer getIdCatParentesco() {
		return idCatParentesco;
	}

	public void setIdCatParentesco(Integer idCatParentesco) {
		this.idCatParentesco = idCatParentesco;
	}

	public String getNombreParentesco() {
		return nombreParentesco;
	}

	public void setNombreParentesco(String nombreParentesco) {
		this.nombreParentesco = nombreParentesco;
	}
	

	@Override
	public String toString() {
		return "CatParentesco [idCatParentesco=" + idCatParentesco + ", nombreParentesco=" + nombreParentesco + "]";
	}
	
	
	

}
