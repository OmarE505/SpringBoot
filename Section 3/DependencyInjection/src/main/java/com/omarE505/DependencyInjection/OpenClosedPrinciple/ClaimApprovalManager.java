package com.omarE505.DependencyInjection.OpenClosedPrinciple;

public class ClaimApprovalManager {
    public void processClaim(InsuranceSurveyor insuranceSurveyor){
        if(insuranceSurveyor.isValid()){
            System.out.println("ClaimApprovalManager: Valid claim. currently processing claim for approval....");
        }
    }
}
