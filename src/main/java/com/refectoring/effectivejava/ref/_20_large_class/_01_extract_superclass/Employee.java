package com.refectoring.effectivejava.ref._20_large_class._01_extract_superclass;

public class Employee extends Party {

    private Integer id;

    private double monthlyCost;

    public double annualCost() {
        return this.monthlyCost * 12;
    }

    public Integer getId() {
        return this.id;
    }

    @Override
    public double monthlyCost() {
        return this.monthlyCost;
    }

}
