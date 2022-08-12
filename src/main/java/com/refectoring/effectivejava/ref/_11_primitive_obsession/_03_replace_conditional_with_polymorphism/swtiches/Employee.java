package com.refectoring.effectivejava.ref._11_primitive_obsession._03_replace_conditional_with_polymorphism.swtiches;

import java.util.List;

public abstract class Employee {

    private List<String> availableProjects;

    public Employee(List<String> availableProjects) {
        this.availableProjects = availableProjects;
    }

    public Employee() {};

    protected abstract int vacationHours();

    public boolean canAccessTo(String project) {
        return this.availableProjects.contains(project);
    }
}
