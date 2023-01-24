package co.camcar.seguridad.spring.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Autowired
	private DataSource seguridadDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/* prueba inicial antes de BBDD
		 UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(usuarios.username("Camilo").password("123456789").roles("usuario","ayudante","administrador"))
			.withUser(usuarios.username("Lorena").password("987654321").roles("usuario"))
			.withUser(usuarios.username("Francisco").password("147852369").roles("usuario","ayudante"))
			.withUser(usuarios.username("Mireya").password("963258741").roles("usuario","ayudante","administrador"));
		*/
		//conectar a BBDD donde esten los usuario, contraseña y perfil
		
		auth.jdbcAuthentication().dataSource(seguridadDataSource);
		
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.authorizeHttpRequests().anyRequest().authenticated()
		http.authorizeRequests()
		.antMatchers("/").hasRole("usuario")
		.antMatchers("/administradores/**").hasRole("administrador")
		.antMatchers("/ayudantes/**").hasRole("ayudante")
		.and().formLogin()
		.loginPage("/formularioLogin")
		.loginProcessingUrl("/authenticacionUsuario")
		.permitAll()
		.and().logout().permitAll()
		.and().exceptionHandling().accessDeniedPage("/acceso-denegado");
	}
	

}
