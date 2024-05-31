package com.example.unesso.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="alumno")
public class Alumno {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idAlumno;
	
	@OneToOne
	@JoinColumn(name="idDomicilio")
	private Domicilio domicilio;
	
	@OneToOne
	@JoinColumn(name="idInfoVivienda")
	private InfoVivienda infoVivienda;
	
	@OneToOne
	@JoinColumn(name="idTutor")
	private Tutor tutor;
	
	@OneToOne
	@JoinColumn(name="idCatEstadoCivil")
	private CatEstadoCivil catEstadoCivil;
	
	@OneToOne
	@JoinColumn(name="idFamilia")
	private Familia familia;
	
	@OneToOne
	@JoinColumn(name="idIngresosFamiliar")
	private IngresoFamiliar ingresoFamiliar;
	
	@OneToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="idCatGrupo")
	private CatGrupo catGrupo;
	
	private String matricula;
	
	private String nombre;
	
	private String apellidoP;
	
	private String apellidoM;
	
	private String telefono;
	
	private String curp;
	
	private Boolean recursosSuficientes;
	
	private Boolean solicitaBecaAlimenticia;
	
	private Double gastoMensual;
	
	private Boolean dependeEconomicamente;
	
	private Boolean familiarComunero;
	
	private String observaciones;
	
	private String idioma;

	public Integer getIdAlumno() {
		return idAlumno;
	}

	public void setIdAlumno(Integer idAlumno) {
		this.idAlumno = idAlumno;
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public InfoVivienda getInfoVivienda() {
		return infoVivienda;
	}

	public void setInfoVivienda(InfoVivienda infoVivienda) {
		this.infoVivienda = infoVivienda;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public CatEstadoCivil getCatEstadoCivil() {
		return catEstadoCivil;
	}

	public void setCatEstadoCivil(CatEstadoCivil catEstadoCivil) {
		this.catEstadoCivil = catEstadoCivil;
	}

	public Familia getFamilia() {
		return familia;
	}

	public void setFamilia(Familia familia) {
		this.familia = familia;
	}

	public IngresoFamiliar getIngresoFamiliar() {
		return ingresoFamiliar;
	}

	public void setIngresoFamiliar(IngresoFamiliar ingresoFamiliar) {
		this.ingresoFamiliar = ingresoFamiliar;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public CatGrupo getCatGrupo() {
		return catGrupo;
	}

	public void setCatGrupo(CatGrupo catGrupo) {
		this.catGrupo = catGrupo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoP() {
		return apellidoP;
	}

	public void setApellidoP(String apellidoP) {
		this.apellidoP = apellidoP;
	}

	public String getApellidoM() {
		return apellidoM;
	}

	public void setApellidoM(String apellidoM) {
		this.apellidoM = apellidoM;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCurp() {
		return curp;
	}

	public void setCurp(String curp) {
		this.curp = curp;
	}

	public Boolean getRecursosSuficientes() {
		return recursosSuficientes;
	}

	public void setRecursosSuficientes(Boolean recursosSuficientes) {
		this.recursosSuficientes = recursosSuficientes;
	}

	public Boolean getSolicitaBecaAlimenticia() {
		return solicitaBecaAlimenticia;
	}

	public void setSolicitaBecaAlimenticia(Boolean solicitaBecaAlimenticia) {
		this.solicitaBecaAlimenticia = solicitaBecaAlimenticia;
	}

	public Double getGastoMensual() {
		return gastoMensual;
	}

	public void setGastoMensual(Double gastoMensual) {
		this.gastoMensual = gastoMensual;
	}

	public Boolean getDependeEconomicamente() {
		return dependeEconomicamente;
	}

	public void setDependeEconomicamente(Boolean dependeEconomicamente) {
		this.dependeEconomicamente = dependeEconomicamente;
	}

	public Boolean getFamiliarComunero() {
		return familiarComunero;
	}

	public void setFamiliarComunero(Boolean familiarComunero) {
		this.familiarComunero = familiarComunero;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", domicilio=" + domicilio + ", infoVivienda=" + infoVivienda
				+ ", tutor=" + tutor + ", catEstadoCivil=" + catEstadoCivil + ", familia=" + familia
				+ ", ingresoFamiliar=" + ingresoFamiliar + ", usuario=" + usuario + ", catGrupo=" + catGrupo
				+ ", matricula=" + matricula + ", nombre=" + nombre + ", apellidoP=" + apellidoP + ", apellidoM="
				+ apellidoM + ", telefono=" + telefono + ", curp=" + curp + ", recursosSuficientes="
				+ recursosSuficientes + ", solicitaBecaAlimenticia=" + solicitaBecaAlimenticia + ", gastoMensual="
				+ gastoMensual + ", dependeEconomicamente=" + dependeEconomicamente + ", familiarComunero="
				+ familiarComunero + ", observaciones=" + observaciones + ", idioma=" + idioma + "]";
	}
	
	
	

}
