package com.wipro.springdemo.beans;

import org.springframework.stereotype.Component;

@Component
public class Display {

    private int size = 6; // default value

    // Getter method
    public int getSize() {
        return size;
    }

    // Setter method (if you want to set size from Spring config or anywhere)
    public void setSize(int size) {
        this.size = size;
    }
}
