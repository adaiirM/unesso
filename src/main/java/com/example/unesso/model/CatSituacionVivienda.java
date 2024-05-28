package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catSituacionVivienda")
public class CatSituacionVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatSituacionVivienda;
	
	private String nombreSituacionVivienda;
	
	private String abrevSituacionVivienda;
	

	public Integer getIdCatSituacionVivienda() {
		return idCatSituacionVivienda;
	}

	public void setIdCatSituacionVivienda(Integer idCatSituacionVivienda) {
		this.idCatSituacionVivienda = idCatSituacionVivienda;
	}

	public String getNombreSituacionVivienda() {
		return nombreSituacionVivienda;
	}

	public void setNombreSituacionVivienda(String nombreSituacionVivienda) {
		this.nombreSituacionVivienda = nombreSituacionVivienda;
	}

	public String getAbrevSituacionVivienda() {
		return abrevSituacionVivienda;
	}

	public void setAbrevSituacionVivienda(String abrevSituacionVivienda) {
		this.abrevSituacionVivienda = abrevSituacionVivienda;
	}

	
	@Override
	public String toString() {
		return "CatSituacionVivienda [idCatSituacionVivienda=" + idCatSituacionVivienda + ", nombreSituacionVivienda="
				+ nombreSituacionVivienda + ", abrevSituacionVivienda=" + abrevSituacionVivienda + "]";
	}
	
	
	
	

}
