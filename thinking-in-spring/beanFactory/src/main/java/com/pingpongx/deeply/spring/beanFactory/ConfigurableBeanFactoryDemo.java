package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 *
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-20 13:12
 **/
public class ConfigurableBeanFactoryDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(String.class);
        ConfigurableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();

        AnnotationConfigApplicationContext anotherContext = buildOneMoreBeanFactory();
        beanFactory.setParentBeanFactory(anotherContext);

        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        System.out.println(parentBeanFactory.getBean("user"));

        System.out.println(beanFactory.getBean("user"));

        annotationConfigApplicationContext.close();
    }


    static AnnotationConfigApplicationContext buildOneMoreBeanFactory() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(ConfigurableBeanFactoryDemo.class);

        return annotationConfigApplicationContext;
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
