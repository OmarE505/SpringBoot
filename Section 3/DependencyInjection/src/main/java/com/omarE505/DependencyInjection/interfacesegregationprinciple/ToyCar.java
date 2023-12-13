package com.omarE505.DependencyInjection.interfacesegregationprinciple;

public class ToyCar implements Toy, Movable{
    double price;
    String color;

    @Override
    public void move() {
        System.out.println("Car is moving...");
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
