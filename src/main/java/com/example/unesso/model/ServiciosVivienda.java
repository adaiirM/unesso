package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="serviciosVivienda")
public class ServiciosVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idServiciosVivienda;
	
	@OneToOne
	@JoinColumn(name="idCatServicios")
	private CatServicios catServicios;
	
	@OneToOne
	@JoinColumn(name="idViviendaFamilia")
	private ViviendaFamiliar viviendaFamilia;
	
	private String otros;
	

	public Integer getIdServiciosVivienda() {
		return idServiciosVivienda;
	}

	public void setIdServiciosVivienda(Integer idServiciosVivienda) {
		this.idServiciosVivienda = idServiciosVivienda;
	}

	public CatServicios getCatServicios() {
		return catServicios;
	}

	public void setCatServicios(CatServicios catServicios) {
		this.catServicios = catServicios;
	}

	public ViviendaFamiliar getViviendaFamilia() {
		return viviendaFamilia;
	}

	public void setViviendaFamilia(ViviendaFamiliar viviendaFamilia) {
		this.viviendaFamilia = viviendaFamilia;
	}

	public String getOtros() {
		return otros;
	}

	public void setOtros(String otros) {
		this.otros = otros;
	}

	@Override
	public String toString() {
		return "ServiciosVivienda [idServiciosVivienda=" + idServiciosVivienda + ", catServicios=" + catServicios
				+ ", viviendaFamilia=" + viviendaFamilia + ", otros=" + otros + "]";
	}
	
	
	

}
