package com.example.unesso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tutorEconomico")
public class TutorEconomico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTutorEconomico;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	@OneToOne
	@JoinColumn(name="idCatSituacionTrabajo")
	private CatSituacionTrabajo catSituacionTrabajo;
	
	@OneToOne
	@JoinColumn(name="idCatParentesco")
	private CatParentesco catParentesco;
	
	@OneToOne
	@JoinColumn(name="idCatOcupacion")
	private CatOcupacion catOcupacion;
	
	private String nombreTutorEconomico;
	
	private String telefono;
	
	private String correo;
	
	private Boolean trabajadorSuneo;

	public Integer getIdTutorEconomico() {
		return idTutorEconomico;
	}

	public void setIdTutorEconomico(Integer idTutorEconomico) {
		this.idTutorEconomico = idTutorEconomico;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public CatSituacionTrabajo getCatSituacionTrabajo() {
		return catSituacionTrabajo;
	}

	public void setCatSituacionTrabajo(CatSituacionTrabajo catSituacionTrabajo) {
		this.catSituacionTrabajo = catSituacionTrabajo;
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

	public String getNombreTutorEconomico() {
		return nombreTutorEconomico;
	}

	public void setNombreTutorEconomico(String nombreTutorEconomico) {
		this.nombreTutorEconomico = nombreTutorEconomico;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Boolean getTrabajadorSuneo() {
		return trabajadorSuneo;
	}

	public void setTrabajadorSuneo(Boolean trabajadorSuneo) {
		this.trabajadorSuneo = trabajadorSuneo;
	}

	@Override
	public String toString() {
		return "TutorEconomico [idTutorEconomico=" + idTutorEconomico + ", domicilio=" + domicilio
				+ ", catSituacionTrabajo=" + catSituacionTrabajo + ", catParentesco=" + catParentesco
				+ ", catOcupacion=" + catOcupacion + ", nombreTutorEconomico=" + nombreTutorEconomico + ", telefono="
				+ telefono + ", correo=" + correo + ", trabajadorSuneo=" + trabajadorSuneo + "]";
	}
}
