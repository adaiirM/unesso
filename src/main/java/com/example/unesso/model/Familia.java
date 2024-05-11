package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="familia")
public class Familia {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idFamilia;
	
	@OneToOne
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	@OneToOne
	@JoinColumn(name="idGastosFam")
	private GastosFam gastosFam;
	
	@OneToOne
	@JoinColumn(name="idInfoFamilia")
	private InfoFamilia infoFamilia;
	
	@OneToOne
	@JoinColumn(name="idViviendaFamilia")
	private ViviendaFamiliar viviendaFamilia;
	
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

	@Override
	public String toString() {
		return "Familia [idFamilia=" + idFamilia + ", domicilio=" + domicilio + ", gastosFam=" + gastosFam
				+ ", infoFamilia=" + infoFamilia + ", viviendaFamilia=" + viviendaFamilia + ", telefono=" + telefono
				+ ", ingresoMensualPromedio=" + ingresoMensualPromedio + ", numPersonasAportan=" + numPersonasAportan
				+ ", numPersonasDependen=" + numPersonasDependen + "]";
	}
	
	
	
	
	

}
