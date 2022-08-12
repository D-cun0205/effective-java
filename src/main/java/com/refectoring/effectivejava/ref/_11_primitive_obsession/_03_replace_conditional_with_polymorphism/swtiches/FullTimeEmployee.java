package com.refectoring.effectivejava.ref._11_primitive_obsession._03_replace_conditional_with_polymorphism.swtiches;

import java.util.List;

public class FullTimeEmployee extends Employee {

    public FullTimeEmployee(List<String> availableProjects) {
        super(availableProjects);
    }

    @Override
    public int vacationHours() {
        return 120;
    }

}
