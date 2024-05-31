package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name="catMaterialVivienda")
public class CatMaterialVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatMaterialVivienda;
	
	private String nombreMaterialVivienda;
	
	
	
	
	public Integer getIdCatMaterialVivienda() {
		return idCatMaterialVivienda;
	}
	
	public void setIdCatMaterialVivienda(Integer idCatMaterialVivienda) {
		this.idCatMaterialVivienda = idCatMaterialVivienda;
	}
	
	public String getNombreMaterialVivienda() {
		return nombreMaterialVivienda;
	}
	
	public void setNombreMaterialVivienda(String nombreMaterialVivienda) {
		this.nombreMaterialVivienda = nombreMaterialVivienda;
	}
	
	
	
	@Override
	public String toString() {
		return "CatMaterialVivienda [idCatMaterialVivienda=" + idCatMaterialVivienda + ", nombreMaterialVivienda="
				+ nombreMaterialVivienda + "]";
	}
	
	

}
