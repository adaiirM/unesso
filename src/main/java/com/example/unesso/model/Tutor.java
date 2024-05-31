package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tutor")
public class Tutor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTutor;
	
	@OneToOne
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	@OneToOne
	@JoinColumn(name="idCatSituacionTrabajo")
	private CatSituacionTrabajo catSituacionTrabajo;
	
	@OneToOne
	@JoinColumn(name="idCatParentesco")
	private CatParentesco catParentesco;
	
	private String nombreTutor;
	
	private String telefono;
	
	private String correo;
	
	private Boolean trabajadorSuneo;
	

	public Integer getIdTutor() {
		return idTutor;
	}

	public void setIdTutor(Integer idTutor) {
		this.idTutor = idTutor;
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

	public String getNombreTutor() {
		return nombreTutor;
	}

	public void setNombreTutor(String nombreTutor) {
		this.nombreTutor = nombreTutor;
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
		return "Tutor [idTutor=" + idTutor + ", domicilio=" + domicilio + ", catSituacionTrabajo=" + catSituacionTrabajo
				+ ", catParentesco=" + catParentesco + ", nombreTutor=" + nombreTutor + ", telefono=" + telefono
				+ ", correo=" + correo + ", trabajadorSuneo=" + trabajadorSuneo + "]";
	} 
	
	
	
}
