package com.malsolo.springframework.mvc.sample;

import com.malsolo.springframework.mvc.sample.web.WelcomeController;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.context.support.StaticWebApplicationContext;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author jbeneito
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackageClasses = WelcomeController.class)
public class WebConfiguration extends WebMvcConfigurerAdapter {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver
                = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    public static void main(String... args) {
        try (ConfigurableApplicationContext context = createContext()) {
            ConfigurationHelper.info(context);
        }
    }

    private static ConfigurableApplicationContext createContext() {
        StaticWebApplicationContext context = new StaticWebApplicationContext();
        context.setServletContext(new MockServletContext());
        AnnotationConfigUtils.registerAnnotationConfigProcessors(context);
        context.refresh();
        context.registerShutdownHook();
        return context;
    }

}
