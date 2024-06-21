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
	
	private String pagoBimestral;
	
	private String pagoPromedioMes;
	
	private String rutaRecibo;
	
	private String nombreOriginal;

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

	public String getPagoPromedioMes() {
		return pagoPromedioMes;
	}

	public void setPagoPromedioMes(String pagoPromedioMes) {
		this.pagoPromedioMes = pagoPromedioMes;
	}

	public String getRutaRecibo() {
		return rutaRecibo;
	}

	public void setRutaRecibo(String rutaRecibo) {
		this.rutaRecibo = rutaRecibo;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public String getPagoBimestral() {
		return pagoBimestral;
	}

	public void setPagoBimestral(String pagoBimestral) {
		this.pagoBimestral = pagoBimestral;
	}

	@Override
	public String toString() {
		return "ReciboLuz [idReciboLuz=" + idReciboLuz + ", domicilio=" + domicilio + ", titular=" + titular
				+ ", periodoInicio=" + periodoInicio + ", periodoFin=" + periodoFin + ", nombreArchivo=" + nombreArchivo
				+ ", pagoBimestral=" + pagoBimestral + ", pagoPromedioMes=" + pagoPromedioMes + ", rutaRecibo="
				+ rutaRecibo + ", nombreOriginal=" + nombreOriginal + "]";
	}
}
