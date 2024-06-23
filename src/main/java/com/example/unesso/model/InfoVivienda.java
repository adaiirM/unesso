package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Table
@Entity(name="infoVivienda")
public class InfoVivienda {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idInfoVivienda;
	
	@OneToOne
	@JoinColumn(name="idCatSituacionVivienda")
	private CatSituacionVivienda catSituacionVivienda; 
	
	private Integer numComparteVivienda;
	
	private Double pagoRenta;
	
	private String nombreCasero;
	

	public Integer getIdInfoVivienda() {
		return idInfoVivienda;
	}

	public void setIdInfoVivienda(Integer idInfoVivienda) {
		this.idInfoVivienda = idInfoVivienda;
	}

	public CatSituacionVivienda getCatSituacionVivienda() {
		return catSituacionVivienda;
	}

	public void setCatSituacionVivienda(CatSituacionVivienda catSituacionVivienda) {
		this.catSituacionVivienda = catSituacionVivienda;
	}

	public Integer getNumComparteVivienda() {
		return numComparteVivienda;
	}

	public void setNumComparteVivienda(Integer numComparteVivienda) {
		this.numComparteVivienda = numComparteVivienda;
	}

	public Double getPagoRenta() {
		return pagoRenta;
	}

	public void setPagoRenta(Double pagoRenta) {
		this.pagoRenta = pagoRenta;
	}

	public String getNombreCasero() {
		return nombreCasero;
	}

	public void setNombreCasero(String nombreCasero) {
		this.nombreCasero = nombreCasero;
	}

	@Override
	public String toString() {
		return "InfoVivienda [idInfoVivienda=" + idInfoVivienda + ", catSituacionVivienda=" + catSituacionVivienda
				+ ", numComparteVivienda=" + numComparteVivienda + ", pagoRenta=" + pagoRenta + ", nombreCasero="
				+ nombreCasero + "]";
	}
	
	
	

}
