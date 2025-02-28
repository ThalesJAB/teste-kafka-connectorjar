package com.common.custom.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringContextProvider {
    private static final ApplicationContext context = new AnnotationConfigApplicationContext(SpringMongoConfig.class);

    public static ApplicationContext getApplicationContext() {
        return context;
    }
}