package com.omarE505.DependencyInjection.OpenClosedPrinciple;

public class VehicleInsuranceSurveyor extends InsuranceSurveyor{
    @Override
    public boolean isValid() {
        System.out.println("Vehicle insurance surveyor is working .....");
        return true;
    }
}
