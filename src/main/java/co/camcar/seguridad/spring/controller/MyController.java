package co.camcar.seguridad.spring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

@Controller
public class MyController {
	
	@GetMapping("/")
	public String muestraInicio() {
		return "inicio";
	}

}
