package com.malsolo.springframework.mvc.sample;

import org.springframework.context.ApplicationContext;

/**
 *
 * @author jbeneito
 */
public class ConfigurationHelper {
    
    public static void info(ApplicationContext context) {
        String[] beanNames = context.getBeanDefinitionNames();
        System.out.println("***** Loaded beans *********");
        for (String beanName : beanNames) {
            Object beanInstance = context.getBean(beanName);
            System.out.printf("***** Bean name: %s. Class: %s\n", beanName, beanInstance.getClass().getName());
        }
        System.out.println("***** END Loaded beans *********");
    }

}
