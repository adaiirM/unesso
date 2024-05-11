package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="ingresoFamiliar")
public class IngresoFamiliar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIngresosFamiliar;
	
	@OneToOne
	@JoinColumn(name="idFamilia")
	private Familia familia;
	
	@OneToOne
	@JoinColumn(name="idCatParentesco")
	private CatParentesco catParentesco;
	
	@OneToOne
	@JoinColumn(name="idCatOcupacion")
	private CatOcupacion idCatOcupacion;
	
	private String nombrePersona;
	
	private Double ingresoBruto;
	
	private Double ingresoNeto;
	

	public Integer getIdIngresosFamilia() {
		return idIngresosFamiliar;
	}

	public void setIdIngresosFamilia(Integer idIngresosFamilia) {
		this.idIngresosFamiliar = idIngresosFamilia;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public CatParentesco getCatParentesco() {
		return catParentesco;
	}

	public void setCatParentesco(CatParentesco catParentesco) {
		this.catParentesco = catParentesco;
	}

	public CatOcupacion getIdCatOcupacion() {
		return idCatOcupacion;
	}

	public void setIdCatOcupacion(CatOcupacion idCatOcupacion) {
		this.idCatOcupacion = idCatOcupacion;
	}

	public String getNombrePersona() {
		return nombrePersona;
	}

	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}

	public Double getIngresoBruto() {
		return ingresoBruto;
	}

	public void setIngresoBruto(Double ingresoBruto) {
		this.ingresoBruto = ingresoBruto;
	}

	public Double getIngresoNeto() {
		return ingresoNeto;
	}

	public void setIngresoNeto(Double ingresoNeto) {
		this.ingresoNeto = ingresoNeto;
	}

	@Override
	public String toString() {
		return "IngresosFamilia [idIngresosFamilia=" + idIngresosFamiliar + ", familia=" + familia + ", catParentesco="
				+ catParentesco + ", idCatOcupacion=" + idCatOcupacion + ", nombrePersona=" + nombrePersona
				+ ", ingresoBruto=" + ingresoBruto + ", ingresoNeto=" + ingresoNeto + "]";
	}
	
	
	

}
