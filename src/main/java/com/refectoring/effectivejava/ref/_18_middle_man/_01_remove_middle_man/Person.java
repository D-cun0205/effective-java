package com.refectoring.effectivejava.ref._18_middle_man._01_remove_middle_man;

public class Person {

    private Department department;

    private String name;

    public Person(String name, Department department) {
        this.name = name;
        this.department = department;
    }

    public Department getDepartment() {
        return this.department;
    }
}
