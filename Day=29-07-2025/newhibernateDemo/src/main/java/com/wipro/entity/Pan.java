package com.wipro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "PAN")
public class Pan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "panholderName")
    private String panholderName;

    @Column(name = "panNumber")
    private String panNumber;

    public Pan() {}

    public Pan(String panholderName, String panNumber) {
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }

    public Pan(int id, String panholderName, String panNumber) {
        this.id = id;
        this.panholderName = panholderName;
        this.panNumber = panNumber;
    }

    // getters and setters

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPanholderName() {
        return panholderName;
    }
    public void setPanholderName(String panholderName) {
        this.panholderName = panholderName;
    }
    public String getPanNumber() {
        return panNumber;
    }
    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    @Override
    public String toString() {
        return "Pan [id=" + id + ", panholderName=" + panholderName + ", panNumber=" + panNumber + "]";
    }
}
