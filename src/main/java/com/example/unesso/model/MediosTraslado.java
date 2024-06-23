package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="mediosTraslado")
public class MediosTraslado {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMediosTraslado;
	
	@OneToOne
	@JoinColumn(name="idAlumno")
	private Alumno alumno;
	
	@OneToOne
	@JoinColumn(name="idCatMediosTransporte")
	private CatMediosTransporte catMediosTransporte;
	

	public Integer getIdMediosTraslado() {
		return idMediosTraslado;
	}

	public void setIdMediosTraslado(Integer idMediosTraslado) {
		this.idMediosTraslado = idMediosTraslado;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public CatMediosTransporte getCatMediosTransporte() {
		return catMediosTransporte;
	}

	public void setCatMediosTransporte(CatMediosTransporte catMediosTransporte) {
		this.catMediosTransporte = catMediosTransporte;
	}

	@Override
	public String toString() {
		return "MediosTraslado [idMediosTraslado=" + idMediosTraslado + ", alumno=" + alumno + ", catMediosTransporte="
				+ catMediosTransporte + "]";
	}
	
	
	

}
