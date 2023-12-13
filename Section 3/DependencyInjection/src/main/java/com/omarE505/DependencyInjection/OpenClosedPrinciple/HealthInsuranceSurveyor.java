package com.omarE505.DependencyInjection.OpenClosedPrinciple;

public class HealthInsuranceSurveyor extends InsuranceSurveyor{
    @Override
    public boolean isValid() {
        System.out.println("Health Insurance Surveyor Working....");
        //implement logic here
        return true;
    }
}
