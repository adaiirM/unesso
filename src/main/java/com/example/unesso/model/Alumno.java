 package com.example.unesso.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
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
	@JoinColumn(name="idTutorEconomico")
	private TutorEconomico tutorEconomico;
	
	@OneToOne
	@JoinColumn(name="idCatEstadoCivil")
	private CatEstadoCivil catEstadoCivil;
	
	@OneToOne
	@JoinColumn(name="idFamilia")
	private Familia familia;
	
	@OneToOne
	@JoinColumn(name="idUsuario")
	private Usuario usuario;
	
	@OneToOne
	@JoinColumn(name="idCatGrupo")
	private CatGrupo catGrupo;
	
	@OneToOne
	@JoinColumn(name="idTransporte")
	private Transporte transporte;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL,  orphanRemoval = false)
	private List<MediosEstudios> mediosEstudios;
	
	@JsonIgnore
	@OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL,  orphanRemoval = false)
	private List<MediosTraslado> mediosTraslado;
	
	@OneToOne
	@JoinColumn(name="idCatInternet")
	private CatInternet catInternet;
	
	@OneToOne
	@JoinColumn(name="idEstadoFormularios")
	private EstadoFormularios estadoFormularios;
	
	@OneToOne(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
	private Trabajo trabajo;
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
	
	private String matricula;
	
	private String nombre;
	
	private String apellidoP;
	
	private String apellidoM;
	
	private String telefono;
	
	private String curp;
	
	private Boolean recursosSuficientes;
	
	private Boolean solicitaBecaAlimenticia;
	
	private Boolean tieneComputadora;
	
	private Boolean tieneTelefono;
	
	private Boolean tieneVehiculo;
	
	private Boolean tieneInternet;
	
	private Double gastoMensual;
	
	private Boolean dependeEconomicamente;
	
	private Boolean familiarComunero;
	
	private String observaciones ;
	
	private Date fechaEntregaSolicitud ; 
	
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



	public TutorEconomico getTutorEconomico() {
		return tutorEconomico;
	}



	public void setTutorEconomico(TutorEconomico tutor) {
		this.tutorEconomico = tutor;
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



	public Transporte getTransporte() {
		return transporte;
	}



	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}



	public List<MediosEstudios> getMediosEstudios() {
		return mediosEstudios;
	}



	public void setMediosEstudios(List<MediosEstudios> mediosEstudios) {
		this.mediosEstudios = mediosEstudios;
	}



	public List<MediosTraslado> getMediosTraslado() {
		return mediosTraslado;
	}



	public void setMediosTraslado(List<MediosTraslado> mediosTraslado) {
		this.mediosTraslado = mediosTraslado;
	}



	public CatInternet getCatInternet() {
		return catInternet;
	}



	public void setCatInternet(CatInternet catInternet) {
		this.catInternet = catInternet;
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



	public Boolean getTieneComputadora() {
		return tieneComputadora;
	}



	public void setTieneComputadora(Boolean tieneComputadora) {
		this.tieneComputadora = tieneComputadora;
	}



	public Boolean getTieneTelefono() {
		return tieneTelefono;
	}



	public void setTieneTelefono(Boolean tieneTelefono) {
		this.tieneTelefono = tieneTelefono;
	}



	public Boolean getTieneVehiculo() {
		return tieneVehiculo;
	}



	public void setTieneVehiculo(Boolean tieneVehiculo) {
		this.tieneVehiculo = tieneVehiculo;
	}

	

	public Boolean getTieneInternet() {
		return tieneInternet;
	}



	public void setTieneInternet(Boolean tieneInternet) {
		this.tieneInternet = tieneInternet;
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



	public Date getFechaEntregaSolicitud() {
		return fechaEntregaSolicitud;
	}



	public void setFechaEntregaSolicitud(Date fechaEntregaSolicitud) {
		this.fechaEntregaSolicitud = fechaEntregaSolicitud;
	}



	public String getIdioma() {
		return idioma;
	}



	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	
>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b

	public EstadoFormularios getEstadoFormularios() {
		return estadoFormularios;
	}



	public void setEstadoFormularios(EstadoFormularios estadoFormularios) {
		this.estadoFormularios = estadoFormularios;
	}



	public Trabajo getTrabajo() {
		return trabajo;
	}



	public void setTrabajo(Trabajo trabajo) {
		this.trabajo = trabajo;
	}



>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
	@Override
	public String toString() {
		return "Alumno [idAlumno=" + idAlumno + ", domicilio=" + domicilio + ", infoVivienda=" + infoVivienda
				+ ", tutor=" + tutorEconomico + ", catEstadoCivil=" + catEstadoCivil + ", familia=" + familia

>>>>>>> 65bf87f7c87f9ee64db5be972b5c536dcb035b8b
				+", usuario=" + usuario + ", catGrupo=" + catGrupo
				+ ", transporte=" + transporte + ", matricula=" + matricula + ", nombre=" + nombre + ", apellidoP="
				+ apellidoP + ", apellidoM=" + apellidoM + ", telefono=" + telefono + ", curp=" + curp
				+ ", recursosSuficientes=" + recursosSuficientes + ", solicitaBecaAlimenticia="
				+ solicitaBecaAlimenticia + ", gastoMensual=" + gastoMensual + ", dependeEconomicamente="
				+ dependeEconomicamente + ", familiarComunero=" + familiarComunero + ", observaciones=" + observaciones
				+ ", idioma=" + idioma + "]";
	}

}
