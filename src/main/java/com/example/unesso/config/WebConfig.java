package com.example.unesso.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

@Configuration
public class WebConfig {
	@Value("${inesis.ruta.recibosLuz}")
	private String rutaRecibosLuz;
	
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/recibosLuz/**").addResourceLocations("file:" + rutaRecibosLuz);
	}
}
