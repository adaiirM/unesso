package com.example.unesso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.unesso.formsModel.FormPrueba;
import com.example.unesso.model.Hermanos;
import com.example.unesso.services.IHermanosService;
import com.example.unesso.util.ArchiveUtils;


//@RestController
@Controller
@RequestMapping(value="/hermanos")
public class HermanosController {
	
	@Value("${unessi.ruta.comprobantes}")
	private String rutaComprobantes;
	
	@Autowired
	private IHermanosService hermanosService ;
	
	/*
	@PostMapping("/guardar")
    public void guardarHermanos(@RequestBody  List<Hermanos> hermanos) {
        // Aquí debes guardar la lista de hermanos en la base de datos
        // Por ejemplo, usando un servicio de HermanosService
        // hermanosService.saveAll(hermanos);
		
		for(Hermanos hermano : hermanos) {
			  System.out.println(hermanos);
		}
		
        System.out.println("Hermanos recibidos: " + hermanos);
    }
	@PostMapping("/prueba")
	public void recibirHermanos(@RequestBody List<Hermanos> hermanos) {
	    // Procesar la lista de objetos Hermanos
		for(Hermanos hermano : hermanos) {
			  System.out.println(hermanos);
		}
	}
	*/
	@GetMapping("/create")
	public String showCreateForm(Model model) {
	    FormPrueba formPrueba = new FormPrueba();

	    for (int i = 1; i <= 3; i++) {
	    	Hermanos hermano = new Hermanos();
	    	hermano.setNombreHermanos("Carlos");
	    	System.out.println(hermano);
	    	formPrueba.addHermano(hermano);
	    }
	    
	    model.addAttribute("form", formPrueba);
	    return "FormHermanoPrueba";
	}
	@PostMapping("/save")
	public String saveBooks(@ModelAttribute FormPrueba form, @RequestParam("file") MultipartFile[] files,
			Model model) {
	    

	    for(Hermanos  hermano : form.getHermanos() ) {
	    	System.out.println(hermano.getNombreHermanos());
	    }
	    
	    
	    for (int i = 0; i < form.getHermanos().size(); i++) {
            Hermanos hermano = form.getHermanos().get(i);
            MultipartFile file = files[i];
            if (!file.isEmpty()) {
                String nombreArchivo = ArchiveUtils.guardarComprobanteEstudio(file, rutaComprobantes);
                if (nombreArchivo != null) {
                	System.out.println(nombreArchivo);
                    //hermano.setNombreArchivo(nombreArchivo); // Supongamos que tienes un campo para almacenar el nombre del archivo en Hermanos
                }
            }
            //System.out.println(hermano.getNombreHermanos());
        }
	    
	    
	    return "menuSolicitarBeca";
	}

}
