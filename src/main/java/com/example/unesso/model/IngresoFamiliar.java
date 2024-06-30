package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="ingresoFamiliar")
public class IngresoFamiliar {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idIngresoFamiliar;
	
	@ManyToOne
	@JoinColumn(name="idFamilia")
	private Familia familia;
	
	@OneToOne
	@JoinColumn(name="idCatParentesco")
	private CatParentesco catParentesco;
	
	@OneToOne
	@JoinColumn(name="idCatOcupacion")
	private CatOcupacion catOcupacion;
	
	private String nombrePersona;
	
	private Double ingresoBruto;
	
	private Double ingresoNeto;
	
	private String lugarTrabajo;
	
	private String puestoTrabajo;

	public Integer getIdIngresoFamiliar() {
		return idIngresoFamiliar;
	}



	public void setIdIngresoFamiliar(Integer idIngresoFamiliar) {
		this.idIngresoFamiliar = idIngresoFamiliar;
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



	public CatOcupacion getCatOcupacion() {
		return catOcupacion;
	}



	public void setCatOcupacion(CatOcupacion catOcupacion) {
		this.catOcupacion = catOcupacion;
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



	public String getLugarTrabajo() {
		return lugarTrabajo;
	}



	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}



	public String getPuestoTrabajo() {
		return puestoTrabajo;
	}



	public void setPuestoTrabajo(String puestoTrabajo) {
		this.puestoTrabajo = puestoTrabajo;
	}



	@Override
	public String toString() {
		return "IngresoFamiliar [idIngresoFamiliar=" + idIngresoFamiliar + ", catParentesco=" + catParentesco
				+ ", catOcupacion=" + catOcupacion + ", nombrePersona=" + nombrePersona + ", ingresoBruto="
				+ ingresoBruto + ", ingresoNeto=" + ingresoNeto + ", lugarTrabajo=" + lugarTrabajo + ", puestoTrabajo="
				+ puestoTrabajo + "]";
	}
}
