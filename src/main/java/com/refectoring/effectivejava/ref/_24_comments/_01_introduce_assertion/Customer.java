package com.refectoring.effectivejava.ref._24_comments._01_introduce_assertion;

public class Customer {
    private Double discountRate;

    public double applyDiscount(double amount) {
        return (this.discountRate != null) ? amount - (this.discountRate * amount) : amount;
    }

    public Double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(Double discountRate) {
        assert discountRate != null && discountRate > 0;
        this.discountRate = discountRate;
    }
}