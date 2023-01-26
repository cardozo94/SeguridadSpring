package co.camcar.seguridad.spring.config;

import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//This class represents the web.xml file
public class MyWebAppInitializer implements WebApplicationInitializer {
	
	private Logger log = Logger.getLogger(getClass().getName());

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext context
        = new AnnotationConfigWebApplicationContext();
      context.setConfigLocation("co.camcar.seguridad.spring.config");

      servletContext.addListener(new ContextLoaderListener(context));

      ServletRegistration.Dynamic dispatcher = servletContext
        .addServlet("dispatcher", new DispatcherServlet(context));
      
      try {
    	  dispatcher.setLoadOnStartup(1);
    	  dispatcher.addMapping("/");
      }catch (Exception e) {
		e.printStackTrace();
      }
	}

}

