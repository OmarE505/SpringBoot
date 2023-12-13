package com.omarE505.DependencyInjection.interfacesegregationprinciple;

public class ToyPlane implements Toy,Movable,Flyable{
    double price;
    String color;

    @Override
    public void fly() {
        System.out.println("Plane Is Flying...");
    }

    @Override
    public void move() {
        System.out.println("Plane Is Moving...");
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
