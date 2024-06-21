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
@Entity(name="hermanos")
public class Hermanos {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idHermanos;
	
	
	@ManyToOne
    @JoinColumn(name = "idFamilia")
    private Familia familia;
			
	private String nombreHermanos;
	
	private Integer edad;
	
	private String nombreEscuela;
	
	private String grado;
	
	private String nombreTipoComprobante;
	
	private String nombreArchivoOriginal;
	
	private String rutaArchivoComprobante;
	
	

	public Integer getIdHermanos() {
		return idHermanos;
	}



	public void setIdHermanos(Integer idHermanos) {
		this.idHermanos = idHermanos;
	}



	public Familia getFamilia() {
		return familia;
	}



	public void setFamilia(Familia familia) {
		this.familia = familia;
	}



	public String getNombreHermanos() {
		return nombreHermanos;
	}



	public void setNombreHermanos(String nombreHermanos) {
		this.nombreHermanos = nombreHermanos;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	public String getNombreEscuela() {
		return nombreEscuela;
	}



	public void setNombreEscuela(String nombreEscuela) {
		this.nombreEscuela = nombreEscuela;
	}



	public String getGrado() {
		return grado;
	}



	public void setGrado(String grado) {
		this.grado = grado;
	}



	public String getNombreTipoComprobante() {
		return nombreTipoComprobante;
	}



	public void setNombreTipoComprobante(String nombreTipoComprobante) {
		this.nombreTipoComprobante = nombreTipoComprobante;
	}



	public String getNombreArchivoOriginal() {
		return nombreArchivoOriginal;
	}



	public void setNombreArchivoOriginal(String rutaArchivoOriginal) {
		this.nombreArchivoOriginal = rutaArchivoOriginal;
	}



	public String getRutaArchivoComprobante() {
		return rutaArchivoComprobante;
	}



	public void setRutaArchivoComprobante(String rutaArchivoComprobante) {
		this.rutaArchivoComprobante = rutaArchivoComprobante;
	}



	@Override
	public String toString() {
		return "Hermanos [idHermanos=" + idHermanos + ", familia=" + familia + ", nombreHermanos=" + nombreHermanos
				+ ", edad=" + edad + ", nombreEscuela=" + nombreEscuela + ", grado=" + grado + ", nombreComprobante="
				+ nombreTipoComprobante + ", rutaComprobante=" + rutaArchivoComprobante + "]";
	}
	
	

	

}
