package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catSituacionViviendaFamiliar")
public class CatSituacionViviendaFamiliar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatSituacionViviendaFamiliar;
	
	private String nombreSituacionViviendaFam;
	

	public Integer getIdCatSituacionViviendaFamiliar() {
		return idCatSituacionViviendaFamiliar;
	}

	public void setIdCatSituacionViviendaFamiliar(Integer idCatSituacionViviendaFamiliar) {
		this.idCatSituacionViviendaFamiliar = idCatSituacionViviendaFamiliar;
	}

	public String getNombreSituacionViviendaFam() {
		return nombreSituacionViviendaFam;
	}

	public void setNombreSituacionViviendaFam(String nombreSituacionViviendaFam) {
		this.nombreSituacionViviendaFam = nombreSituacionViviendaFam;
	}

	
	@Override
	public String toString() {
		return "CatSituacionViviendaFamiliar [idCatSituacionViviendaFamiliar=" + idCatSituacionViviendaFamiliar
				+ ", nombreSituacionViviendaFam=" + nombreSituacionViviendaFam + "]";
	}

	
	

}
