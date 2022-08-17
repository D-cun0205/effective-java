package com.refectoring.effectivejava.ref._20_large_class._01_extract_superclass;

public abstract class Party {

    protected String name;

    public String getName() {
        return name;
    }

    public double annualCost() {
        return this.monthlyCost() * 12;
    }

    public abstract double monthlyCost();
}
