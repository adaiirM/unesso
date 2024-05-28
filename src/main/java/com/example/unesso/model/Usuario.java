package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idUsuario;
	
	@OneToOne
	@JoinColumn(name="idCatRol")
	private CatRol catRol;
	
	private String correo;
	
	private String contrasenia;
	
	private Boolean estatus;

	
	public Integer getIdUser() {
		return idUsuario;
	}

	public void setIdUser(Integer idUser) {
		this.idUsuario = idUser;
	}

	public CatRol getCatRol() {
		return catRol;
	}

	public void setCatRol(CatRol catRol) {
		this.catRol = catRol;
	}

	public String getUsername() {
		return correo;
	}

	public void setUsername(String username) {
		this.correo = username;
	}

	public String getPassword() {
		return contrasenia;
	}

	public void setPassword(String password) {
		this.contrasenia = password;
	}

	public Boolean getStatus() {
		return estatus;
	}

	public void setStatus(Boolean status) {
		this.estatus = status;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUsuario + ", catRol=" + catRol + ", username=" + correo + ", password=" + contrasenia
				+ ", status=" + estatus + "]";
	}
	
	

}
