package com.omarE505.DependencyInjection.interfacesegregationprinciple;

public class ToyHouse implements Toy{
    double price;
    String color;
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }
}
