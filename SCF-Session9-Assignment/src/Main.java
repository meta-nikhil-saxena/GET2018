import graphics.Point;
import interfaceModule.Shape;
import interfaceModule.ShapeEnum;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import mainWorking.Screen;
import FactoryOfObjects.FactoryShapes;

public class Main {
    private static Scanner sc;
    static Shape shapeSquare, shapeRectangle, shapeTriangle, shapeCircle;

    public static void main(String args[]) {
        sc = new Scanner(System.in);
        Point point = new Point();
        Screen screen = new Screen();

        System.out.println("!! Welcome to Screen !!");
        System.out.println("Enter dimension of the screen : ");

        int x = sc.nextInt();

        try {
            if (!screen.isValidInput(x)) {
                System.out.println("!! Sorry negative !!");
                throw new Exception("Invalid input");
            }

            int y = sc.nextInt();

            if (!screen.isValidInput(y)) {
                System.out.println("!! Sorry negative !!");
                throw new Exception("Invalid input");
            }
            screen.setMAX_XCOORDINATE(x);
            screen.setMAX_YCOORDINATE(y);
        } catch (Exception e) {
            System.out.println("ERROR");
        }

        List<Integer> integerList = new ArrayList<Integer>();

        integerList.add(2);
        integerList.add(3);
        integerList.add(4);

        do {
            try {
                System.out.println("1. Add Square");
                System.out.println("2. Add Rectangle");
                System.out.println("3. Add Triangle");
                System.out.println("4. Add Circle");
                System.out.println("5. Display in Ascending Order of Shapes");
                System.out.println("6. Remove");
                System.out.println("7. Remove All");
                System.out.println("8. Point Enclosed ");
                System.out.println("9. EXIT");

                System.out.println("Enter Choice : ");
                int choice = sc.nextInt();

                switch (choice) {
                case 1: { // Square
                    Point pointSquare = screen.setAttributes();
                    Shape shapeSquare = FactoryShapes.getShapeType(
                            ShapeEnum.SQUARE.name(), pointSquare, integerList);

                    System.out.println("Area of Square : "
                            + shapeSquare.getArea());
                    System.out.println("Perimeter of Square : "
                            + shapeSquare.getPerimeter());
                    System.out.println("Origin of Square : "
                            + shapeSquare.getOrigin());

                    screen.addShapeToScreen(shapeSquare);
                    break;
                }
                case 2: {

                    // Rectangle
                    Point pointRectangle = screen.setAttributes();
                    Shape shapeRectangle = FactoryShapes.getShapeType(
                            ShapeEnum.RECTANGLE.name(), pointRectangle,
                            integerList);

                    System.out.println("Area of Rectangle : "
                            + shapeRectangle.getArea());
                    System.out.println("Perimeter of Rectangle : "
                            + shapeRectangle.getPerimeter());
                    System.out.println("Origin of Rectangle : "
                            + shapeRectangle.getOrigin());

                    screen.addShapeToScreen(shapeRectangle);
                    break;
                }
                case 3: {
                    // Triangle
                    Point pointTriangle = screen.setAttributes();
                    Shape shapeTriangle = FactoryShapes.getShapeType(
                            ShapeEnum.TRIANGLE.name(), pointTriangle,
                            integerList);

                    System.out.println("Area of Triangle : "
                            + shapeTriangle.getArea());
                    System.out.println("Perimeter of Triangle : "
                            + shapeTriangle.getPerimeter());
                    System.out.println("Origin of Triangle : "
                            + shapeTriangle.getOrigin());

                    screen.addShapeToScreen(shapeTriangle);
                    break;
                }
                case 4: {

                    // Circle
                    Point circle = screen.setAttributes();

                    Shape shapeCircle = FactoryShapes.getShapeType(
                            ShapeEnum.CIRCLE.name(), circle, integerList);

                    System.out.println("Area of Circle : "
                            + shapeCircle.getArea());
                    System.out.println("Perimeter of Circle : "
                            + shapeCircle.getPerimeter());
                    System.out.println("Origin of Circle : "
                            + shapeCircle.getOrigin());
                    screen.addShapeToScreen(shapeCircle);

                    break;
                }
                case 5: {
                    screen.display();
                    String shapeNamesAscending[] = screen.displayinAscending();
                    System.out.println("------------------------------------");
                    System.out.println("Shapes Names in ascending Order : ");
                    for (int i = 0; i < shapeNamesAscending.length; i++) {
                        System.out.println(shapeNamesAscending[i]);
                    }
                    System.out.println("------------------------------------");
                    break;
                }
                case 6: {
                    screen.display();
                    System.out.println("Enter index to remove : ");
                    int index = sc.nextInt();
                    screen.remove(index);
                    break;
                }
                case 7: {
                    screen.removeAll();
                    break;
                }
                case 8: {
                    System.out
                            .println("Enter point to find that it is Enclosed");

                    int xCoordinate = sc.nextInt();
                    int yCoordinate = sc.nextInt();

                    point.setxCoordinate(xCoordinate);
                    point.setyCoordinate(yCoordinate);

                    String enclosedShapes[] = screen.findEnclosedPoint(point);

                    for (int i = 0; i < enclosedShapes.length; i++) {
                        System.out.println(enclosedShapes[i]);
                    }

                    break;
                }
                case 9: {
                    System.exit(0);

                }
                default:
                    System.out.println("Invalid choice");
                }
            } catch (Exception e) {
                System.out.println("Input correct");
                sc.next();
            }
        } while (true);

    }
}
