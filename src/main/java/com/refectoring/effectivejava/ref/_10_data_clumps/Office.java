package com.refectoring.effectivejava.ref._10_data_clumps;

public class Office {

    private String location;

    private TelephoneNumber officeNumber;

    public Office(String location, TelephoneNumber officeNumber) {
        this.location = location;
        this.officeNumber = officeNumber;
    }

    public String officePhoneNumber() {
        return this.officeNumber.toString();
    }
}
