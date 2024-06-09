package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="estadoformularios")
public class EstadoFormularios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idEstadoFormularios ; 
	private Boolean formMisDatos ;
	private Boolean formMiFamilia ;
	private Boolean formDependienteEconomico ; 
	private Boolean formMisGatos ;
	
	public Integer getIdEstadoFormularios() {
		return idEstadoFormularios;
	}
	public void setIdEstadoFormularios(Integer idEstadoFormularios) {
		this.idEstadoFormularios = idEstadoFormularios;
	}
	public Boolean getFormMisDatos() {
		return formMisDatos;
	}
	public void setFormMisDatos(Boolean formMisDatos) {
		this.formMisDatos = formMisDatos;
	}
	public Boolean getFormMiFamilia() {
		return formMiFamilia;
	}
	public void setFormMiFamilia(Boolean formMiFamilia) {
		this.formMiFamilia = formMiFamilia;
	}
	public Boolean getFormDependienteEconomico() {
		return formDependienteEconomico;
	}
	public void setFormDependienteEconomico(Boolean formDependienteEconomico) {
		this.formDependienteEconomico = formDependienteEconomico;
	}
	public Boolean getFormMisGatos() {
		return formMisGatos;
	}
	public void setFormMisGatos(Boolean formMisGatos) {
		this.formMisGatos = formMisGatos;
	}
	@Override
	public String toString() {
		return "EstadoFormularios [idEstadoFormularios=" + idEstadoFormularios + ", formMisDatos=" + formMisDatos
				+ ", formMiFamilia=" + formMiFamilia + ", formDependienteEconomico=" + formDependienteEconomico
				+ ", formMisGatos=" + formMisGatos + "]";
	}
	
	
}
