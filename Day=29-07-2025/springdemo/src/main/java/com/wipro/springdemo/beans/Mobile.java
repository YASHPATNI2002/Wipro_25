package com.wipro.springdemo.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mobile {

    private Display display;

    @Autowired
    public Mobile(Display display) {
        this.display = display;
    }

    public void showDetails() {
        System.out.println("Mobile Display Size: " + display.getSize());
    }
}
