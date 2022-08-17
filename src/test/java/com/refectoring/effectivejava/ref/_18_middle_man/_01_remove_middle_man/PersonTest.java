package com.refectoring.effectivejava.ref._18_middle_man._01_remove_middle_man;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void getManager() {
        Person dcun = new Person("dcun", null);
        Person sanghun = new Person("sanghun", new Department(dcun));
        assertEquals(dcun, sanghun.getDepartment().getManager());
    }
}