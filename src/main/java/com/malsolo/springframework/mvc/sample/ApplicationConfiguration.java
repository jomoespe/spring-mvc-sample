package com.malsolo.springframework.mvc.sample;

import static org.springframework.context.annotation.ComponentScan.Filter;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 *
 * @author jbeneito
 */
@Configuration
@ComponentScan(basePackageClasses = ApplicationConfiguration.class
        , excludeFilters = {
            @Filter(type = FilterType.ANNOTATION, value = EnableWebMvc.class),
            @Filter(type = FilterType.ANNOTATION, value = Controller.class)
        }
)
public class ApplicationConfiguration {

    public static void main(String... args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            ConfigurationHelper.info(context);
        }
    }

}
