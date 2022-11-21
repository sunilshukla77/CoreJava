package com.structural.flyweight;

public class PaintApp {
    public void render(int numberOfShapes){

        Shape shape = null;
        for (int i = 0; i < numberOfShapes; i++) {
            if(i%2 == 0){
                shape= ShapeFactory.getShape("Circle");
                shape.draw(i,"red","white");
            } else{
                shape= ShapeFactory.getShape("Rectangle");
                shape.draw(i,i+i,"dotted");
            }
        }
    }
}
