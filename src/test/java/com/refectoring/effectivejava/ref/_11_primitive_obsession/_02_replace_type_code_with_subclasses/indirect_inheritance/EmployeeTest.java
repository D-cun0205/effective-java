package com.refectoring.effectivejava.ref._11_primitive_obsession._02_replace_type_code_with_subclasses.indirect_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void capitalizedType() {
        assertEquals("Manager", new FullTimeEmployee("dcun", "manager").capitalizedType());
        assertEquals("Engineer", new FullTimeEmployee("dcun", "engineer").capitalizedType());
        assertThrows(IllegalArgumentException.class, () -> new Employee("dcun", "wrong type"));
    }
}