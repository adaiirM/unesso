package com.example.unesso.util;

import java.time.LocalDate;

public class DateUtils {
	/**
	 * Esta funcion obtiene el año de la fecha actual
	 * @return int con el año obtenido 
	 */
	public int obtenerAnioActualDelSistema() {
		LocalDate dt = LocalDate.now();
		int year = dt.getYear();
		
		return year;
	}
	
	
	

}
