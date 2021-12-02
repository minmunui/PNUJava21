package edu.pnu.shape;

import java.awt.*;

public class Circle extends Shape {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    @Override
    public float getArea() {
        return (float) (Math.PI * (Math.pow(radius, 2)));
    }

    @Override
    public String toString() {
        return "[Circle "+center+", radius: " + radius +" area: " + String.format("%.2f]",getArea());
    }
}
