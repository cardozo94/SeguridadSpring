package co.camcar.seguridad.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("==========> getRootConfigClasses");
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("==========> getServletConfigClasses");
		return new Class[] {App.class};
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("==========> getServletMappings");
		return new String[] {"/"};
	}

}
