package com.example.unesso.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="familia")
public class Familia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFamilia;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="idGastosFam")
	private GastosFam gastosFam;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="idInfoFamilia")
	private InfoFamilia infoFamilia;
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="idViviendaFamiliar")
	private ViviendaFamiliar viviendaFamilia;
	
	@JsonIgnore
	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL,  orphanRemoval = false)
	private List<Hermanos> hermanos;
	
	@JsonIgnore
	@OneToMany(mappedBy = "familia", cascade = CascadeType.ALL,  orphanRemoval = false)
	private List<IngresoFamiliar> ingresoFamiliar;
	
	private String telefono;
	
	private Double ingresoMensualPromedio;

	private Integer numPersonasAportan;
	
	private Integer numPersonasDependen;
	
	

	public Integer getIdFamilia() {
		return idFamilia;
	}

	public void setIdFamilia(Integer idFamilia) {
		this.idFamilia = idFamilia;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public GastosFam getGastosFam() {
		return gastosFam;
	}

	public void setGastosFam(GastosFam gastosFam) {
		this.gastosFam = gastosFam;
	}

	public InfoFamilia getInfoFamilia() {
		return infoFamilia;
	}

	public void setInfoFamilia(InfoFamilia infoFamilia) {
		this.infoFamilia = infoFamilia;
	}

	public ViviendaFamiliar getViviendaFamilia() {
		return viviendaFamilia;
	}

	public void setViviendaFamilia(ViviendaFamiliar viviendaFamilia) {
		this.viviendaFamilia = viviendaFamilia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Double getIngresoMensualPromedio() {
		return ingresoMensualPromedio;
	}

	public void setIngresoMensualPromedio(Double ingresoMensualPromedio) {
		this.ingresoMensualPromedio = ingresoMensualPromedio;
	}

	public Integer getNumPersonasAportan() {
		return numPersonasAportan;
	}

	public void setNumPersonasAportan(Integer numPersonasAportan) {
		this.numPersonasAportan = numPersonasAportan;
	}

	public Integer getNumPersonasDependen() {
		return numPersonasDependen;
	}

	public void setNumPersonasDependen(Integer numPersonasDependen) {
		this.numPersonasDependen = numPersonasDependen;
	}
	

	public List<Hermanos> getHermanos() {
		return hermanos;
	}

	public void setHermanos(List<Hermanos> hermanos) {
		this.hermanos = hermanos;
	}

	public List<IngresoFamiliar> getIngresoFamiliar() {
		return ingresoFamiliar;
	}

	public void setIngresoFamiliar(List<IngresoFamiliar> ingresoFamiliar) {
		this.ingresoFamiliar = ingresoFamiliar;
	}

	
	@Override
	public String toString() {
		return "Familia [idFamilia=" + idFamilia  + ", telefono=" + telefono + ", ingresoMensualPromedio="
				+ ingresoMensualPromedio + ", numPersonasAportan=" + numPersonasAportan + ", numPersonasDependen="
				+ numPersonasDependen + "]";
	}

}
