package com.example.unesso.model;

import jakarta.persistence.CascadeType;
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="trabajo")
public class Trabajo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idTrabajo;

    @OneToOne(cascade = CascadeType.ALL)
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	private String telefono;
	
	private String nombreTrabajo;
	
	private Double ingresoMensual;
	

	@OneToOne
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b

	public Integer getIdTrabajo() {
		return idTrabajo;
	}

	public void setIdTrabajo(Integer idTrabajo) {
		this.idTrabajo = idTrabajo;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombreTrabajo() {
		return nombreTrabajo;
	}

	public void setNombreTrabajo(String nombreTrabajo) {
		this.nombreTrabajo = nombreTrabajo;
	}

	public Double getIngresoMensual() {
		return ingresoMensual;
	}

	public void setIngresoMensual(Double ingresoMensual) {
		this.ingresoMensual = ingresoMensual;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
	@Override
	public String toString() {
		return "Trabajo [idTrabajo=" + idTrabajo + ", domicilio=" + domicilio + ", telefono=" + telefono
				+ ", nombreTrabajo=" + nombreTrabajo + ", ingresoMensual=" + ingresoMensual + "]";
	}
	

}
