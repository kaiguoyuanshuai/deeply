package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * ParentBeanFactory 不能获取 当前BeanFactory定义的Bean
 * 当前BeanFactory 可以获取 ParentBeanFactory 定义的Bean
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-20 13:12
 **/
public class ConfigurableBeanFactoryDemo {


    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(String.class);
        ConfigurableBeanFactory beanFactory = annotationConfigApplicationContext.getBeanFactory();

        //构建另外一个 ApplicationContext
        ClassPathXmlApplicationContext anotherContext = buildOneMoreBeanFactory();
        //设置到 ParentBeanFactory
        beanFactory.setParentBeanFactory(anotherContext);

        // 获取 ParentBeanFactory
        BeanFactory parentBeanFactory = beanFactory.getParentBeanFactory();
        System.out.println("==============parentBeanFactory 获取定义在 ParentBeanFactory 中的Bean : " + parentBeanFactory.getBean("user"));
        System.out.println("==============当前beanFactory 获取定义在 ParentBeanFactory 中的Bean : " + beanFactory.getBean("user"));

        System.out.println("==============parentBeanFactory 获取定义在 当前 BeanFactory 中的Bean : ");
        System.out.println(beanFactory.getBean("tt"));

        annotationConfigApplicationContext.close();
    }


    static ClassPathXmlApplicationContext buildOneMoreBeanFactory() {
        ClassPathXmlApplicationContext annotationConfigApplicationContext = new ClassPathXmlApplicationContext("META-INF/application-parent-beanFactory.xml");
        return annotationConfigApplicationContext;
    }


    @Bean
    public String tt() {
        return "uu";
    }

    @Bean
    public String peaple() {
        return "pp";
    }
}
