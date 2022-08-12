package com.refectoring.effectivejava.ref._11_primitive_obsession._01_repliace_primitive_with_object;

public class Order {

    private Priority priority;

    public Order(String priority) {
        this(new Priority(priority));
    }

    public Order(Priority priority) {
        this.priority = priority;
    }

    public Priority getPriority() {
        return priority;
    }
}
