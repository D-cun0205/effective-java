package com.refectoring.effectivejava.ref._18_middle_man._01_remove_middle_man;

public class Department {

    private Person manager;

    public Department(Person manager) {
        this.manager = manager;
    }

    public Person getManager() {
        return manager;
    }
}
