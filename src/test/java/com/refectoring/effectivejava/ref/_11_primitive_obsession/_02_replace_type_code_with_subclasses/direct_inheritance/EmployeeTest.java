package com.refectoring.effectivejava.ref._11_primitive_obsession._02_replace_type_code_with_subclasses.direct_inheritance;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void employeeType() {
        assertEquals("engineer", Employee.createEmployee("dcun", "engineer").getType());
        assertEquals("manager", Employee.createEmployee("dcun", "manager").getType());
        assertThrows(IllegalArgumentException.class, () -> Employee.createEmployee("dcun", "wrong type"));
    }
}