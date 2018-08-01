import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import graphics.Point;
import interfaceModule.Shape;
import mainWorking.Screen;

import org.junit.Test;

import FactoryOfObjects.FactoryShapes;

public class TestForShapes {

    List<Integer> listInteger = new ArrayList<Integer>();
    float area, perimeter;
    boolean enclosed;
    Screen screen = new Screen();

    /**
    *Function to test for square
    */
    @Test
    public void testSquare() {

        screen.setMAX_XCOORDINATE(600);
        screen.setMAX_YCOORDINATE(600);

        Point point = new Point();
        point.setxCoordinate(5);
        point.setyCoordinate(5);

        listInteger.add(5);

        Shape shapeSquare = FactoryShapes.getShapeType("SQUARE", point,
                listInteger);
        area = shapeSquare.getArea();
        perimeter = shapeSquare.getPerimeter();
        enclosed = shapeSquare.isPointEnclosed(point);
        screen.screenList.add(shapeSquare);
        assertEquals(25, area, 0.002);
        assertEquals(20, perimeter, 0.002);
        assertEquals(true, enclosed);
    }

     /**
    *Function to test for Rectangle
    */
    @Test
    public void testRectangle() {
        Screen screen = new Screen();
        screen.setMAX_XCOORDINATE(600);
        screen.setMAX_YCOORDINATE(600);

        Point point = new Point();
        point.setxCoordinate(5);
        point.setyCoordinate(5);
        listInteger.add(5);
        listInteger.add(6);

        Shape shapeRectangle = FactoryShapes.getShapeType("RECTANGLE", point,
                listInteger);
        area = shapeRectangle.getArea();
        perimeter = shapeRectangle.getPerimeter();
        enclosed = shapeRectangle.isPointEnclosed(point);
        screen.screenList.add(shapeRectangle);
        assertEquals(30, area, 0.002);
        assertEquals(22, perimeter, 0.002);
        assertEquals(true, enclosed);
    }

     /**
    *Function to test for Triangle
    */
    @Test
    public void testtriangle() {
        Screen screen = new Screen();
        screen.setMAX_XCOORDINATE(600);
        screen.setMAX_YCOORDINATE(600);

        Point point = new Point();
        point.setxCoordinate(5);
        point.setyCoordinate(5);
        listInteger.add(2);
        listInteger.add(3);
        listInteger.add(4);

        Shape shapeTriangle = FactoryShapes.getShapeType("TRIANGLE", point,
                listInteger);

        area = shapeTriangle.getArea();
        perimeter = shapeTriangle.getPerimeter();
        enclosed = shapeTriangle.isPointEnclosed(point);
        screen.screenList.add(shapeTriangle);
        assertEquals(3.464, area, 0.002);
        assertEquals(4, perimeter, 0.002);
        assertEquals(true, enclosed);
    }

     /**
    *Function to test for Circle
    */
    @Test
    public void testCircle() {
        Screen screen = new Screen();
        screen.setMAX_XCOORDINATE(600);
        screen.setMAX_YCOORDINATE(600);

        Point point = new Point();

        point.setxCoordinate(5);
        point.setyCoordinate(5);

        listInteger.add(2);

        Shape shapeCircle = FactoryShapes.getShapeType("CIRCLE", point,
                listInteger);
        screen.screenList.add(shapeCircle);
        area = shapeCircle.getArea();
        perimeter = shapeCircle.getPerimeter();
        enclosed = shapeCircle.isPointEnclosed(point);

        assertEquals(12.56, area, 0.002);
        assertEquals(12.56, perimeter, 0.002);
        assertEquals(true, enclosed);
    }

}
