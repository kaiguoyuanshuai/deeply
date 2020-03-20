package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.beans.factory.HierarchicalBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-20 13:19
 **/
public class HierarchicalBeanFactoryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(HierarchicalBeanFactoryDemo.class);

        HierarchicalBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();
        System.out.println(beanFactory.getParentBeanFactory());

        System.out.println(beanFactory.containsLocalBean("user"));
        annotationConfigApplicationContext.close();

    }

}
