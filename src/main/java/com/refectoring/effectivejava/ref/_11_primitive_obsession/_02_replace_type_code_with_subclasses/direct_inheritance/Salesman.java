package com.refectoring.effectivejava.ref._11_primitive_obsession._02_replace_type_code_with_subclasses.direct_inheritance;

public class Salesman extends Employee {
    public Salesman(String name) {
        super(name);
    }

    @Override
    public String getType() {
        return "salesman";
    }
}
