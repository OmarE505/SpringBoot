package com.omarE505.DependencyInjection.interfacesegregationprinciple;

public class ToyBuilder {
    public static ToyHouse buildToyHouse(){
        ToyHouse toyHouse = new ToyHouse();
        toyHouse.setColor("Green");
        toyHouse.setPrice(20.3);

        return toyHouse;
    }

    public static ToyCar buildToyCar(){
        ToyCar toyCar = new ToyCar();
        toyCar.setColor("Red");
        toyCar.setPrice(11.3);

        toyCar.move();

        return toyCar;
    }

    public static ToyPlane buildToyPlane(){
        ToyPlane toyPlane = new ToyPlane();
        toyPlane.setColor("Black");
        toyPlane.setPrice(17.8);

        toyPlane.move();
        toyPlane.fly();

        return  toyPlane;
    }
}
