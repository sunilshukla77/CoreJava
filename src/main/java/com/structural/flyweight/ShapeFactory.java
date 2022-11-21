package com.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

    private static Map<String, Shape> shapes = new HashMap<>();

    public static Shape getShape(String type){
        Shape shape = null;
        if(shapes.get(type)!= null){
            shape= shapes.get(type);
        }else {
            if(type.equals("Circle")){
                shape= new Circle();
            } else if (type.equals("Rectangle")) {
                shape= new Rectangle(4,5,"blue");
            }
            shapes.put(type, shape);
        }
        return shape;

    }
}
