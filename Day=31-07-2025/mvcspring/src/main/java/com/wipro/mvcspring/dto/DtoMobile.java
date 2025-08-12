package com.wipro.mvcspring.dto;

public class DtoMobile {
    private int id;
    private String make;
    private String modelNumber;
    private double price;

    public DtoMobile() {}

    public DtoMobile(int id, String make, String modelNumber, double price) {
        this.id = id;
        this.make = make;
        this.modelNumber = modelNumber;
        this.price = price;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getMake() { return make; }

    public void setMake(String make) { this.make = make; }

    public String getModelNumber() { return modelNumber; }

    public void setModelNumber(String modelNumber) { this.modelNumber = modelNumber; }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
