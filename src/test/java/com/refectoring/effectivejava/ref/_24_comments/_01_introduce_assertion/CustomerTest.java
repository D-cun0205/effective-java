package com.refectoring.effectivejava.ref._24_comments._01_introduce_assertion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void setDiscountRate() {
        Customer customer = new Customer();
        customer.setDiscountRate(-10d);
    }
}