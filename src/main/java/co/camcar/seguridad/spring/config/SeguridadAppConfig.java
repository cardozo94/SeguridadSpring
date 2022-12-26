package co.camcar.seguridad.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SeguridadAppConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//conectar a BBDD donde esten los usuario, contraseña y perfil
		
		UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(usuarios.username("Camilo").password("123456789").roles("administrador"))
			.withUser(usuarios.username("Lorena").password("987654321").roles("usuario"))
			.withUser(usuarios.username("Francisco").password("147852369").roles("ayudante"))
			.withUser(usuarios.username("Mireya").password("963258741").roles("administrador"));
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().anyRequest().authenticated()
		.and().formLogin()
		.loginPage("/formularioLogin")
		.loginProcessingUrl("/authenticacionUsuario")
		.permitAll()
		.and().logout().permitAll();
	}
	

}
