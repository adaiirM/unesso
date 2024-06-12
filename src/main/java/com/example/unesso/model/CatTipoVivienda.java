package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catTipoVivienda")
public class CatTipoVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatTipoVivienda;
	
	private String nombreTipoVivienda;
	

	public Integer getIdCatTipoVivienda() {
		return idCatTipoVivienda;
	}

	public void setIdCatTipoVivienda(Integer idCatTipoVivienda) {
		this.idCatTipoVivienda = idCatTipoVivienda;
	}

	public String getNombreTipoVivienda() {
		return nombreTipoVivienda;
	}

	public void setNombreTipoVivienda(String nombreTipoVivienda) {
		this.nombreTipoVivienda = nombreTipoVivienda;
	}

	
	@Override
	public String toString() {
		return "CatTipoVivienda [idCatTipoVivienda=" + idCatTipoVivienda + ", nombreTipoVivienda=" + nombreTipoVivienda
				+ "]";
	}
	
	

}
