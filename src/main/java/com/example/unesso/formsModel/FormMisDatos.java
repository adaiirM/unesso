package com.example.unesso.formsModel;

import java.util.ArrayList;
import java.util.List;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.CatSituacionVivienda;
import com.example.unesso.model.Transporte;
import com.example.unesso.model.Domicilio;
import com.example.unesso.model.Hermanos;
import com.example.unesso.model.InfoVivienda;
import com.example.unesso.model.MediosTraslado;
import com.example.unesso.model.TutorEconomico;


/**
 * Esta clase contiene los modelos que permitiran realizar las operaciones CRUD 
 * en el formulario formMisDatos
 */
public class FormMisDatos {
	private Alumno alumno;
	private Domicilio domicilio;
	private TutorEconomico tutor;
	private List<Integer> mediosTraslado = new ArrayList<>();
	private Transporte transporte;
	private InfoVivienda infoVivienda;
	private CatSituacionVivienda catSituacionVivinda;
	
	//Medos get y set
	public Alumno getAlumno() {
		return alumno;
	}
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}
	public Domicilio getDomicilio() {
		return domicilio;
	}
	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}
	public TutorEconomico getTutor() {
		return tutor;
	}
	public void setTutor(TutorEconomico tutor) {
		this.tutor = tutor;
	}
	
	
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	
	public List<Integer> getMediosTraslado() {
		return mediosTraslado;
	}
	public void setMediosTraslado(List<Integer> mediosTraslado) {
		this.mediosTraslado = mediosTraslado;
	}
	
	public void addMediosTraslado(Integer medio) {
		mediosTraslado.add(medio);
	}
	
	public InfoVivienda getInfoVivienda() {
		return infoVivienda;
	}
	public void setInfoVivienda(InfoVivienda infoVivienda) {
		this.infoVivienda = infoVivienda;
	}
	
	
	public CatSituacionVivienda getCatSituacionVivinda() {
		return catSituacionVivinda;
	}
	public void setCatSituacionVivinda(CatSituacionVivienda catSituacionVivinda) {
		this.catSituacionVivinda = catSituacionVivinda;
	}
	@Override
	public String toString() {
		return "FormMisDatos [alumno=" + alumno + ", domicilio=" + domicilio + ", tutor=" + tutor + ", mediosTraslado="
				+ mediosTraslado + ", transporte=" + transporte + ", infoVivienda=" + infoVivienda
				+ ", catSituacionVivinda=" + catSituacionVivinda + "]";
	}
	
	
	
	
	

}
