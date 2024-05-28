package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catTipoTransporte")
public class CatTipoTransporte {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatTipoTransporte;
	
	private String nombreTipoTransporte;
	
	private String abrevTipoTransporte;
	

	public Integer getIdCatTipoTransporte() {
		return idCatTipoTransporte;
	}

	public void setIdCatTipoTransporte(Integer idCatTipoTransporte) {
		this.idCatTipoTransporte = idCatTipoTransporte;
	}

	public String getNombreTipoTransporte() {
		return nombreTipoTransporte;
	}

	public void setNombreTipoTransporte(String nombreTipoTransporte) {
		this.nombreTipoTransporte = nombreTipoTransporte;
	}

	public String getAbrevTipoTransporte() {
		return abrevTipoTransporte;
	}

	public void setAbrevTipoTransporte(String abrevTipoTransporte) {
		this.abrevTipoTransporte = abrevTipoTransporte;
	}

	
	@Override
	public String toString() {
		return "CatTipoTransporte [idCatTipoTransporte=" + idCatTipoTransporte + ", nombreTipoTransporte="
				+ nombreTipoTransporte + ", abrevTipoTransporte=" + abrevTipoTransporte + "]";
	}
	
	

}
