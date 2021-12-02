package edu.pnu.shape;

import java.awt.*;
import java.math.*;

public class Rectangle extends Shape {
    private int width, height;

    public Rectangle(int x1, int y1, int x2, int y2) {
        width = Math.abs(x2 - x1);
        height = Math.abs(y2 - y1);

    }
    @Override
    public float getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("[Rectangle %d %d %.2f]", width, height, getArea());
    }
}