package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * BeanFactory 最基础的使用方法
 *
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-19 13:13
 **/
public class BeanFactoryDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(BeanFactoryDemo.class);

        //获取成最顶层的接口实现
        BeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();
        System.out.println(beanFactory.getBean("user"));

        //beanFactory.setParentBeanFactory();
        annotationConfigApplicationContext.close();

    }


    @Bean
    public String user() {
        return "user1";
    }
}
