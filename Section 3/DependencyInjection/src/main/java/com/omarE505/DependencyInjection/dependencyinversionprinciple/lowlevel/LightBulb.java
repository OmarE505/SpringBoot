package com.omarE505.DependencyInjection.dependencyinversionprinciple.lowlevel;

import com.omarE505.DependencyInjection.dependencyinversionprinciple.highlevel.Switchable;

public class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Turning Lightbulb On ...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Lightbulb Off ...");
    }
}
