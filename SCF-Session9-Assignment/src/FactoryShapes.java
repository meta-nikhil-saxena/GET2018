package FactoryOfObjects;

import java.util.List;

import mainWorking.Screen;
import graphics.Circle;
import graphics.Point;
import graphics.Rectangle;
import graphics.Square;
import graphics.Triangle;
import interfaceModule.Shape;
import interfaceModule.ShapeEnum;

public class FactoryShapes {
Screen screen = new Screen();
        
    /**
     * Function to initialize shapes
     * 
     * @param shapeType
     * @param point
     * @param list
     * @return
     */
    public static Shape getShapeType(String shapeType, Point point,
            List<Integer> list) {

        Shape shape = null;
        try {

            if (shapeType.equalsIgnoreCase(ShapeEnum.SQUARE.name())) {
                int side = list.get(0);
                return new Square(side, point);

            } else if (shapeType.equalsIgnoreCase(ShapeEnum.CIRCLE.name())) {
                int radius = list.get(0);
                return new Circle(radius, point);

            } else if (shapeType.equalsIgnoreCase(ShapeEnum.RECTANGLE.name())) {
                int width = list.get(0);
                int length = list.get(1);
                return new Rectangle(length, width, point);

            } else if (shapeType.equalsIgnoreCase(ShapeEnum.TRIANGLE.name())) {
                int side1 = list.get(0);
                int side2 = list.get(1);
                int side3 = list.get(2);
                
                return new Triangle(side1, side2,side3, point);

            } else {

                System.out
                        .println("!! Compatible shape not Found in the System !!");
                throw new Exception("!! ERROR !!");

            }
        } catch (Exception e) {
            System.out.println("!! error.....error....error.....error !!");
        }

        return shape;

    }

}
