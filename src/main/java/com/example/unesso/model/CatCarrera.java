package com.example.unesso.model;




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="catCarrera")
public class CatCarrera {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idCatCarrera;
	
	private String carrera;

	
	
	public Integer getIdCatCarrera() {
		return idCatCarrera;
	}

	public void setIdCatCarrera(Integer idCatCarrera) {
		this.idCatCarrera = idCatCarrera;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	@Override
	public String toString() {
		return "CatCarrera [idCatCarrera=" + idCatCarrera + ", carrera=" + carrera + "]";
	}
	
	

}
