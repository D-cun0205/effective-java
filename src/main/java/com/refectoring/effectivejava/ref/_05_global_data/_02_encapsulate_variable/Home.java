package com.refectoring.effectivejava.ref._05_global_data._02_encapsulate_variable;

public class Home {

    public static void main(String[] args) {
        System.out.println(Thermostats.getTargetTemperature());
        Thermostats.setTargetTemperature(-1111600);
        Thermostats.setFahrenheit(false);
    }
}
