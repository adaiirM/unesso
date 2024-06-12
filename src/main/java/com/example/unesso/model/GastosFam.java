package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="gastosFam")
public class GastosFam {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idGastosFam;
	
	@OneToOne
	@JoinColumn(name="idReciboLuz")
	private ReciboLuz reciboLuz;
	
	private Double gastosAlimentacion;
	
	private Double gastoRenta;
	
	private Double gastoServicios;
	
	private Double gastoEscolares;
	
	private Double gastoRopa;
	
	private Double gastoTransporte;
	
	private Double gastoOtros;
	
	

	public Integer getIdGastosFam() {
		return idGastosFam;
	}

	public void setIdGastosFam(Integer idGastosFam) {
		this.idGastosFam = idGastosFam;
	}

	public ReciboLuz getReciboLuz() {
		return reciboLuz;
	}

	public void setReciboLuz(ReciboLuz reciboLuz) {
		this.reciboLuz = reciboLuz;
	}

	public Double getGastosAlimentacion() {
		return gastosAlimentacion;
	}

	public void setGastosAlimentacion(Double gastosAlimentacion) {
		this.gastosAlimentacion = gastosAlimentacion;
	}

	public Double getGastoRenta() {
		return gastoRenta;
	}

	public void setGastoRenta(Double gastoRenta) {
		this.gastoRenta = gastoRenta;
	}

	public Double getGastoServicio() {
		return gastoServicios;
	}

	public void setGastoServicio(Double gastoServicio) {
		this.gastoServicios = gastoServicio;
	}

	public Double getGastoEscolares() {
		return gastoEscolares;
	}

	public void setGastoEscolares(Double gastoEscolares) {
		this.gastoEscolares = gastoEscolares;
	}

	public Double getGastoRopa() {
		return gastoRopa;
	}

	public void setGastoRopa(Double gastoRopa) {
		this.gastoRopa = gastoRopa;
	}

	public Double getGastoTransporte() {
		return gastoTransporte;
	}

	public void setGastoTransporte(Double gastoTransporte) {
		this.gastoTransporte = gastoTransporte;
	}

	public Double getGastoOtros() {
		return gastoOtros;
	}

	public void setGastoOtros(Double gastoOtros) {
		this.gastoOtros = gastoOtros;
	}

	@Override
	public String toString() {
		return "GastosFam [idGastosFam=" + idGastosFam + ", reciboLuz=" + reciboLuz + ", gastosAlimentacion="
				+ gastosAlimentacion + ", gastoRenta=" + gastoRenta + ", gastoServicio=" + gastoServicios
				+ ", gastoEscolares=" + gastoEscolares + ", gastoRopa=" + gastoRopa + ", gastoTransporte="
				+ gastoTransporte + ", gastoOtros=" + gastoOtros + "]";
	}
	
	
	
	

}
