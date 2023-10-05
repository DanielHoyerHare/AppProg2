package com.example.finalprojectapp.models;

public class HairColor {

    int id;
    String color;


    public HairColor() {}

    public HairColor(String color) {
        super();
        this.color = color;
    }

    public HairColor(int id, String color) {
        super();
        this.id = id;
        this.color = color;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString(){
        return color;
    }
}

