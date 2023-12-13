package com.omarE505.DependencyInjection.dependencyinversionprinciple.lowlevel;

import com.omarE505.DependencyInjection.dependencyinversionprinciple.highlevel.Switchable;

public class Fan implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Turning Fan On ...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning Fan Off ...");
    }
}
