package com.refectoring.effectivejava.ref._06_mutable_data._04_replace_derived_variable_with_query;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountTest {

    @Test
    void discount() {
        Discount discount = new Discount(100);
        assertEquals(100, discount.getDiscountedTotal());
    }
}