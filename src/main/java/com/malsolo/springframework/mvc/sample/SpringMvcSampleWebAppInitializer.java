package com.malsolo.springframework.mvc.sample;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 *
 * @author jbeneito
 */
public class SpringMvcSampleWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?> [] { ApplicationConfiguration.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?> [] { WebConfiguration.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
    
}
