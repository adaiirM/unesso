package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="viviendaFamiliar")
public class ViviendaFamiliar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idViviendaFamilia;
	
	@OneToOne
	@JoinColumn(name="idCatTipoVivienda")
	private CatTipoVivienda catTipoVivienda;
	
	@OneToOne
	@JoinColumn(name="idCatMaterialVivienda")
	private CatMaterialVivienda catMaterialVivienda;

	@OneToOne
	@JoinColumn(name="idCatSituacionViviendaFamiliar")
	private CatSituacionViviendaFamiliar catSituacionViviendaFamiliar;

	private Integer numPersonasHabitan;

	public Integer getIdViviendaFamilia() {
		return idViviendaFamilia;
	}

	public void setIdViviendaFamilia(Integer idViviendaFamilia) {
		this.idViviendaFamilia = idViviendaFamilia;
	}

	public CatTipoVivienda getCatTipoVivienda() {
		return catTipoVivienda;
	}

	public void setCatTipoVivienda(CatTipoVivienda catTipoVivienda) {
		this.catTipoVivienda = catTipoVivienda;
	}

	public CatMaterialVivienda getCatMaterialVivienda() {
		return catMaterialVivienda;
	}

	public void setCatMaterialVivienda(CatMaterialVivienda catMaterialVivienda) {
		this.catMaterialVivienda = catMaterialVivienda;
	}

	public CatSituacionViviendaFamiliar getCatSituacionViviendaFamiliar() {
		return catSituacionViviendaFamiliar;
	}

	public void setCatSituacionViviendaFamiliar(CatSituacionViviendaFamiliar catSituacionViviendaFamiliar) {
		this.catSituacionViviendaFamiliar = catSituacionViviendaFamiliar;
	}

	public Integer getNumPersonasHabitan() {
		return numPersonasHabitan;
	}

	public void setNumPersonasHabitan(Integer numPersonasHabitan) {
		this.numPersonasHabitan = numPersonasHabitan;
	}

	@Override
	public String toString() {
		return "ViviendaFamilia [idViviendaFamilia=" + idViviendaFamilia + ", catTipoVivienda=" + catTipoVivienda
				+ ", catMaterialVivienda=" + catMaterialVivienda + ", catSituacionViviendaFamiliar="
				+ catSituacionViviendaFamiliar + ", numPersonasHabitan=" + numPersonasHabitan + "]";
	}
	
	
	
	
	
}
