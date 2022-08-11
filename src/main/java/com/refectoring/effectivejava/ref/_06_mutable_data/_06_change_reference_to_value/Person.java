package com.refectoring.effectivejava.ref._06_mutable_data._06_change_reference_to_value;

public class Person {

    private TelephoneNumber officeTelephoneNumber;

    public String officeAreaCode() {
        return this.officeTelephoneNumber.areaCode();
    }

    public String officeNumber() {
        return this.officeTelephoneNumber.number();
    }

}
