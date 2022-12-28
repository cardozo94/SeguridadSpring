package co.camcar.seguridad.spring.config;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * Hello world!
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "co.camcar.seguridad.spring")
@PropertySource("classpath:persistencia-mysql.properties")
public class App 
{
	
	@Autowired
	private Environment env;
	
	//Sistema de log
	private Logger log = Logger.getLogger(getClass().getName());
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	//bean para seguridad
	@Bean
	public DataSource seguridadDataSource() {
		//crear pool de conexiones
		
		ComboPooledDataSource poolDataSource = new ComboPooledDataSource();
		
		//Establecer driver JDBC
		
		try {
			poolDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			log.info("ERROR - "+e.getMessage());
			e.printStackTrace();
		}
		
		//Hacer log de las propiedades de conexión
		
		log.info("URL de la BBDD: " + env.getProperty("jdbc.url"));
		log.info("usuario de la BBDD: " + env.getProperty("jdbc.user"));
		
		//Establecer propiedades de conexión con BBDD
		
		poolDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		poolDataSource.setUser(env.getProperty("jdbc.user"));
		poolDataSource.setPassword(env.getProperty("jdbc.password"));
		
		//Establecer las propiedades del pool de conexiones
		
		poolDataSource.setInitialPoolSize(Integer.valueOf(env.getProperty("connection.pool.initialPoolSize")));
		poolDataSource.setMinPoolSize(Integer.valueOf(env.getProperty("connection.pool.minPoolSize")));
		poolDataSource.setMaxPoolSize(Integer.valueOf(env.getProperty("connection.pool.maxPoolSize")));
		poolDataSource.setMaxIdleTime(Integer.valueOf(env.getProperty("connection.pool.maxIdleTime")));
		
		return poolDataSource;
	}
}
