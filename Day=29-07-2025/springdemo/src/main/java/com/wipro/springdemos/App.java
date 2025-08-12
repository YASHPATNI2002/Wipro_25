package com.wipro.springdemos;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.wipro.springdemo.beans.Department;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Department department = (Department) context.getBean("department");
        System.out.println(department);

        ((ClassPathXmlApplicationContext) context).close();
    }
}
