package com.example.unesso.util;

import java.io.File;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public class Utileria {
	public static String guardarArchivo(MultipartFile multiPart, String ruta) {
		// Obtenemos el nombre original del archivo.
		String nombreOriginal = multiPart.getOriginalFilename();
		nombreOriginal = nombreOriginal.replace(" ", "-");
		String nombreFinal = randomAlphaNumeric(8) + nombreOriginal;
		try {
			// Formamos el nombre del archivo para guardarlo en el disco duro.
			File file = new File(ruta + nombreFinal);
			System.out.println("Archivo: " + file.getAbsolutePath());
			//Guardamos fisicamente el archivo en HD.
			multiPart.transferTo(file);
			return nombreFinal;
		} catch (IOException e) {
			System.out.println("Error " + e.getMessage());
			return null;
		}
	}
	
	public static String randomAlphaNumeric(int count) {
		String CARACTERES = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while(count-- != 0) {
			int caracter = (int) (Math.random() * CARACTERES.length());
			builder.append(CARACTERES.charAt(caracter));
		}
		return builder.toString();
	}
	
	
}

