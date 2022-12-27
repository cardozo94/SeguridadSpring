package co.camcar.seguridad.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String muestraInicio() {
		return "inicio";
	}
	
	//Agregar mapping a administadores
	@GetMapping("/administradores")
	public String muestraAdministradores() {
		return "administradores";
	}

	//Agregar mapping a ayudantes
	@GetMapping("/ayudantes")
	public String muestraAyudantes() {
		return "ayudantes";
	}
	
	@GetMapping("/acceso-denegado")
	public String muestraAccesoDenegado() {
		return "acceso-denegado";
	}
}
