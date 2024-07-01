package com.example.unesso.model;

import jakarta.persistence.*;

@Entity
@Table(name="catMunicipio")
public class CatMunicipio {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatMunicipio;
	
	@OneToOne
	@JoinColumn(name="idCatEstado")
	private CatEstado catEstado;

	@OneToOne
	@JoinColumn(name="idCatRegion")
	private CatRegion catRegion;

	@OneToOne
	@JoinColumn(name="idCatDistrito")
	private CatDistrito catDistrito;
	
	private String nombreMunicipio;


	public Integer getIdCatMunicipio() {
		return idCatMunicipio;
	}

	public void setIdCatMunicipio(Integer idCatMunicipio) {
		this.idCatMunicipio = idCatMunicipio;
	}

	public CatEstado getCatEstado() {
		return catEstado;
	}

	public void setCatEstado(CatEstado catEstado) {
		this.catEstado = catEstado;
	}

	public CatRegion getCatRegion() {
		return catRegion;
	}

	public void setCatRegion(CatRegion catRegion) {
		this.catRegion = catRegion;
	}

	public CatDistrito getCatDistrito() {
		return catDistrito;
	}

	public void setCatDistrito(CatDistrito catDistrito) {
		this.catDistrito = catDistrito;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	@Override
	public String toString() {
		return "CatMunicipio{" +
				"idCatMunicipio=" + idCatMunicipio +
				", catEstado=" + catEstado +
				", catRegion=" + catRegion +
				", catDistrito=" + catDistrito +
				", nombreMunicipio='" + nombreMunicipio + '\'' +
				'}';
	}
}
