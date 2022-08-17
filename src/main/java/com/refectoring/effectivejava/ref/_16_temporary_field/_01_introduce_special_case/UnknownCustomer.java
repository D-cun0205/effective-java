package com.refectoring.effectivejava.ref._16_temporary_field._01_introduce_special_case;

public class UnknownCustomer extends Customer {
    public UnknownCustomer() {
        super("unknown", new BasicBillingPlan(), new NullPaymentHistory());
    }

    @Override
    public String getName() {
        return "unknown";
    }

    @Override
    public boolean isUnknown(Customer customer) {
        return true;
    }
}
