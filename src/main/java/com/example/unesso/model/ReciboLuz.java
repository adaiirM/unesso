package com.example.unesso.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="reciboLuz")
public class ReciboLuz {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idReciboLuz;
	
	@OneToOne
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	private String titular;
	
	private Date periodoInicio;
	
	private Date periodoFin;
	
	private String nombreArchivo;
	
	private Double pagoPromedioMes;
	

	public Integer getIdReciboLuz() {
		return idReciboLuz;
	}

	public void setIdReciboLuz(Integer idReciboLuz) {
		this.idReciboLuz = idReciboLuz;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public void setPeriodoInicio(Date periodoInicio) {
		this.periodoInicio = periodoInicio;
	}

	public Date getPeriodoFin() {
		return periodoFin;
	}

	public void setPeriodoFin(Date periodoFin) {
		this.periodoFin = periodoFin;
	}

	public String getNombreArchivo() {
		return nombreArchivo;
	}

	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}

	public Double getPagoPromedioMes() {
		return pagoPromedioMes;
	}

	public void setPagoPromedioMes(Double pagoPromedioMes) {
		this.pagoPromedioMes = pagoPromedioMes;
	}

	@Override
	public String toString() {
		return "ReciboLuz [idReciboLuz=" + idReciboLuz + ", domicilio=" + domicilio + ", titular=" + titular
				+ ", periodoInicio=" + periodoInicio + ", periodoFin=" + periodoFin + ", nombreArchivo=" + nombreArchivo
				+ ", pagoPromedioMes=" + pagoPromedioMes + "]";
	}
	
	
	

}
