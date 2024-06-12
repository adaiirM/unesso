package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="comprobanteEstudios")
public class ComprobanteEstudios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idComprobanteEstudios;
	
	
	private String nombreComprobante;

	
	public Integer getIdComprobanteEstudios() {
		return idComprobanteEstudios;
	}

	public void setIdComprobanteEstudios(Integer idComprobanteEstudios) {
		this.idComprobanteEstudios = idComprobanteEstudios;
	}


	public String getNombreComprobante() {
		return nombreComprobante;
	}

	public void setNombreComprobante(String nombreComprobante) {
		this.nombreComprobante = nombreComprobante;
	}

	@Override
	public String toString() {
		return "ComprobanteEstudios [idComprobanteEstudios=" + idComprobanteEstudios 
				+ ", nombreComprobante=" + nombreComprobante + "]";
	}
	
	
	
}
