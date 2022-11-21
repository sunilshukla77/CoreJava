package com.structural.flyweight;

public class Rectangle extends Shape{
    String label;
    int lenght;

    int breath;
    String fillStyle;

    public Rectangle(int lenght, int breath, String fillStyle) {
        this.lenght = lenght;
        this.breath = breath;
        this.fillStyle = fillStyle;
    }


    @Override
    public String toString() {
        return "Rectangle{" +
                "label='" + label + '\'' +
                ", lenght='" + lenght + '\'' +
                ", breath='" + breath + '\'' +
                ", fillStyle='" + fillStyle + '\'' +
                '}';
    }
}
