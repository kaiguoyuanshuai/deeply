package com.pingpongx.deeply.spring.beanFactory;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 构建AnnotationConfigApplicationContext 上下文，注解方式上下文
 *
 * @author <a href="mailto:zhengkk@pingpongx.com">zhengkk</a>
 * @since 2020-03-19 20:59
 **/
public class CommonAnnotationConfigApplicationContextBuilder {

    public static AnnotationConfigApplicationContext buildContextAndRefresh(Class beanFactoryDemoClass) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext();
        annotationConfigApplicationContext.register(beanFactoryDemoClass);
        annotationConfigApplicationContext.refresh();
        return annotationConfigApplicationContext;
    }

}
