package com.example.unesso.formsModel;

import java.util.ArrayList;
import java.util.List;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatMedios;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.Familia;
import com.example.unesso.model.Hermanos;
import com.example.unesso.model.InfoFamilia;
import com.example.unesso.model.MediosEstudios;
import com.example.unesso.model.TutorEconomico;
import com.example.unesso.model.ViviendaFamiliar;

public class FormMiFamilia {
	private Alumno alumno;
	private Familia familia;
	private Domicilio domicilio;
	private InfoFamilia infoFamilia;
	private ViviendaFamiliar viviendaFamiliar;
	private TutorEconomico tutor;
	private List<Hermanos> hermanos = new ArrayList<>() ;
	private List<Integer> mediosEstudios = new ArrayList<>() ;
	private List<Integer> serviciosVivienda = new ArrayList<>() ;
	
	
	public Familia getFamilia() {
		return familia;
	}
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public InfoFamilia getInfoFamilia() {
		return infoFamilia;
	}
	public void setInfoFamilia(InfoFamilia infoFamilia) {
		this.infoFamilia = infoFamilia;
	}
	public ViviendaFamiliar getViviendaFamiliar() {
		return viviendaFamiliar;
	}
	public void setViviendaFamiliar(ViviendaFamiliar viviendaFamiliar) {
		this.viviendaFamiliar = viviendaFamiliar;
	}
	
	
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	
	public TutorEconomico getTutor() {
		return tutor;
	}
	public void setTutor(TutorEconomico tutor) {
		this.tutor = tutor;
	}
	
	public void addHermano(Hermanos hermano) {
		hermanos.add(hermano);
	}

	public List<Hermanos> getHermanos() {
		return hermanos;
	}

	public void setHermanos(List<Hermanos> hermanos) {
		this.hermanos = hermanos;
	}
	
	
	public List<Integer> getMediosEstudios() {
		return mediosEstudios;
	}
	public void setMediosEstudios(List<Integer> mediosEstudios) {
		this.mediosEstudios = mediosEstudios;
	}
	
	
	public List<Integer> getServiciosVivienda() {
		return serviciosVivienda;
	}
	public void setServiciosVivienda(List<Integer> serviciosVivienda) {
		this.serviciosVivienda = serviciosVivienda;
	}
	@Override
	public String toString() {
		return "FormMiFamilia [alumno=" + alumno + ", familia=" + familia + ", domicilio=" + domicilio
				+ ", infoFamilia=" + infoFamilia + ", viviendaFamiliar=" + viviendaFamiliar + ", tutor=" + tutor + "]";
	}
	
	

}
