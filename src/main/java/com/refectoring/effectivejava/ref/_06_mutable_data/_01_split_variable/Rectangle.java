package com.refectoring.effectivejava.ref._06_mutable_data._01_split_variable;

public class Rectangle {

    private double perimeter;
    private double area;

    // after
    public void updateGeometry(double height, double width) {
        final double perimeter = 2 * (height + width);
        System.out.println("Perimeter: " + perimeter);
        this.perimeter = perimeter;

        final double area = height * width;
        System.out.println("Area: " + area);
        this.area = area;
    }

    // before
//    public void updateGeometry(double height, double width) {
//        double temp1 = 2 * (height + width);
//        System.out.println("Perimeter: " + temp1);
//        perimeter = temp1;
//
//        double temp2 = height * width;
//        System.out.println("Area: " + temp2);
//        area = temp2;
//    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }
}
