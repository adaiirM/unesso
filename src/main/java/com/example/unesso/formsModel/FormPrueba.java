package com.example.unesso.formsModel;

import java.util.ArrayList;
import java.util.List;

import com.example.unesso.model.Alumno;
import com.example.unesso.model.Hermanos;

public class FormPrueba {
	public List<Hermanos> hermanos = new ArrayList<>();
	
	public void addHermano(Hermanos hermano) {
		hermanos.add(hermano);
	}

	public List<Hermanos> getHermanos() {
		return hermanos;
	}

	public void setHermanos(List<Hermanos> hermanos) {
		this.hermanos = hermanos;
	}
	
	
	

}
