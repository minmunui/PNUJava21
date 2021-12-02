package edu.pnu.edit;

import edu.pnu.shape.*;
import edu.pnu.shape.Shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Editor {
    private List<Shape> shapes = new ArrayList<>();

    public void add(Shape shape) {
        shapes.add(shape);
    }
    public void clear() {
        shapes.clear();
    }
    public void list() {
        System.out.print("[");
        for (int i = 0; i < shapes.size(); i ++) {
            System.out.print(shapes.get(i));
            if ( i+1 != shapes.size() ) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
