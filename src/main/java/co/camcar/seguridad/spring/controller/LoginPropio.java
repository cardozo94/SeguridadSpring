package co.camcar.seguridad.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginPropio {
	
	@GetMapping("/formularioLogin")
	public String formularioLoginPropio() {
		return "login-nuevo";
	}

}
