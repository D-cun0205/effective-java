package com.refectoring.effectivejava.ref._11_primitive_obsession._01_repliace_primitive_with_object;

import java.util.List;

public class Priority {
    private String value;
    private List<String> legarValues = List.of("low", "normal", "high", "rush");

    public Priority(String value) {
        if (legarValues.contains(value)) {
            this.value = value;
        } else {
            throw new IllegalArgumentException("illegal value for priority");
        }
    }

    @Override
    public String toString() {
        return this.value;
    }

    private int index() {
        return this.legarValues.indexOf(this.value);
    }

    public boolean higherThan(Priority other) {
        return this.index() > other.index();
    }
}