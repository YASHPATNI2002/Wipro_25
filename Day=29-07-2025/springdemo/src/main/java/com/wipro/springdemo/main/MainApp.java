package com.wipro.springdemo.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wipro.springdemo.beans.Mobile;
import com.wipro.springdemo.config.AppConfig;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Mobile mobile = context.getBean(Mobile.class);
        mobile.showDetails();
    }
}
