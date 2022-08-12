package com.refectoring.effectivejava.ref._10_data_clumps;

public class Employee {

    private String name;

    private TelephoneNumber personalNumber;

    public Employee(String name, TelephoneNumber personalNumber) {
        this.name = name;
        this.personalNumber = personalNumber;
    }

    public String personalPhoneNumber() {
        return this.personalNumber.toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
