package com.pingpongx.deeply.spring.beanFactory;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * //TODO
 *
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-19 21:13
 **/
public class ListableBeanFactoryBaseDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = CommonAnnotationConfigApplicationContextBuilder
            .buildContextAndRefresh(ListableBeanFactoryBaseDemo.class);

        //
        ListableBeanFactory listableBeanFactory = annotationConfigApplicationContext.getBeanFactory();
        System.out.printf("BeanDefinitionCount : %s %n", listableBeanFactory.getBeanDefinitionCount());

        System.out.println("==========getBeanDefinitionNames 方法便利所有的 BeanDefinitionName===========");
        for (String beanDefinitionName : listableBeanFactory.getBeanDefinitionNames()) {
            System.out.printf("getBeanDefinitionNames : %s %n", beanDefinitionName);
        }

        System.out.println("==========getBeanNamesForAnnotation 方法便利所有使用 @Bean 定义的Bean=========");
        String[] beanNamesForAnnotation = listableBeanFactory.getBeanNamesForAnnotation(Bean.class);
        for (String beanDefinitionName : beanNamesForAnnotation) {
            System.out.printf("getBeanNamesForAnnotation : %s %n", beanDefinitionName);
        }

        System.out.println("============getBeansOfType:获取所有的 String类型的Bean 并且输出 ==============");
        Map<String, String> beansOfType = listableBeanFactory.getBeansOfType(String.class);

        for (Entry<String, String> entry : beansOfType.entrySet()) {
            System.out.printf("key[%s] ,value[%s] %n", entry.getKey(), entry.getValue());
        }

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
