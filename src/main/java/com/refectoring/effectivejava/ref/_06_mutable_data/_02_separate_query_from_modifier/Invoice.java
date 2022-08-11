package com.refectoring.effectivejava.ref._06_mutable_data._02_separate_query_from_modifier;

public class Invoice {

    private double amount;

    public Invoice(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
