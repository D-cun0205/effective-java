package com.refectoring.effectivejava.ref._16_temporary_field._01_introduce_special_case;

public class Site {

    private Customer customer;

    public Site(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }
}
