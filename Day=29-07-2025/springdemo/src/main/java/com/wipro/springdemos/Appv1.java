package com.wipro.springdemos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springdemo.beans.College;

public class Appv1 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        College college = (College) context.getBean("college");
        System.out.println(college);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
