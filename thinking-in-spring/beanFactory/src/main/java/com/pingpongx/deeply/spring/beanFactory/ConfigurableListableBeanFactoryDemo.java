package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * //TODO
 *
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-20 13:09
 **/
public class ConfigurableListableBeanFactoryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(ConfigurableListableBeanFactoryDemo.class);
        ConfigurableListableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();

        beanFactory.ignoreDependencyType(String.class);

        System.out.println(beanFactory.getBean("user"));
        annotationConfigApplicationContext.close();
    }


    @Bean
    public String user() {
        return "uu";
    }

    @Bean
    public String peaple() {
        return "pp";
    }
}
