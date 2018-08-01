package mainWorking;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import graphics.Point;
import interfaceModule.Shape;

public class Screen {

    public List<Shape> screenList = new ArrayList<Shape>();
    Scanner sc = new Scanner(System.in);

    // Max x-coordinate and y-coordinate on the screen
    private static int maxXcoordinate;
    private static int maxYcoordinate;

    // Min x-coordinate and y-coordinate on the screen
    private static int minXcoordinate;
    private static int minYcoordinate;

    // Getters and setters START
    public static int getMAX_XCOORDINATE() {
        return maxXcoordinate;
    }

    public void setMAX_XCOORDINATE(int mAX_XCOORDINATE) {
        maxXcoordinate = mAX_XCOORDINATE;
    }

    public static int getMAX_YCOORDINATE() {
        return maxYcoordinate;
    }

    public void setMAX_YCOORDINATE(int mAX_YCOORDINATE) {
        maxYcoordinate = mAX_YCOORDINATE;
    }

    public static int getMIN_XCOORDINATE() {
        return minXcoordinate;
    }

    public static int getMIN_YCOORDINATE() {
        return minYcoordinate;
    }

    // getters and setters END

    // Function to check input given to screen is negative or positive
    public boolean isValidInput(int input) {

        if (input < 0) {
            System.out.println("!! Input is negative !!");

            return false;

        }
        return true;

    }

    /**
     * Function to check if list is empty
     * 
     * @throws Exception
     */
    public void checkForEmptyAndThrowException() throws Exception {
        if (screenList.size() == 0) {
            System.out.println("List of Shapes Empty");
            throw new Exception("!! Empty !!");
        }
    }

    /**
     * Function to set Attributes
     */
    public Point setAttributes() {

        Point point = new Point();

        System.out
                .println("Set point for Square on screen (X and Y) Coordinates : ");

        point.setxCoordinate(sc.nextInt());
        point.setyCoordinate(sc.nextInt());

        return point;
    }

    /**
     * Function to add shape to screen
     * 
     * @param shape
     */
    public void addShapeToScreen(Shape shape) {

        shape.setDate(new Date());
        screenList.add(shape);
        System.out.println("!! Shape  Added !!");
    }

    /**
     * Function to Display list
     * 
     * @param index
     */
    public void display() throws Exception {

        Iterator<Shape> shape = screenList.iterator();
        checkForEmptyAndThrowException();
        int index = 0;
        while (shape.hasNext()) {
            Shape shapeGet = shape.next();
            System.out
                    .println("----------------------------------------------");
            System.out.println("INDEX : " + index);
            System.out.println("DATE : " + shapeGet.getDate());
            System.out.println("SHAPE : " + shapeGet.getType());
            System.out.println("Area : " + shapeGet.getArea());
            System.out.println("Perimeter : " + shapeGet.getPerimeter());
            System.out.println("Origin of shape : " + shapeGet.getOrigin());
            System.out
                    .println("----------------------------------------------");

            index++;
            // shape.next();
        }
    }

    /**
     * Function to remove shape
     * 
     * @param index
     */
    public void remove(int index) {

        screenList.remove(index);
        System.out.println("!! Shape Removed !!");
    }

    /**
     * Function to remove all shapes
     */
    public void removeAll() throws Exception {
        checkForEmptyAndThrowException();
        screenList.removeAll(screenList);
        System.out.println("!! All Shape Removed !!");

    }

    public String[] displayinAscending() throws Exception {

        String shapeNAmes[] = new String[screenList.size()];

        for (int i = 0; i < shapeNAmes.length; i++) {
            shapeNAmes[i] = screenList.get(i).getType();
        }
        checkForEmptyAndThrowException();

        int i = 0;
        while (i < screenList.size()) {
            int j = 0;
            while (j < (screenList.size() - 1) - i) {

                if (screenList.get(j).getArea() > screenList.get(j + 1)
                        .getArea()) {

                    String temporary = shapeNAmes[j];
                    shapeNAmes[j] = shapeNAmes[j + 1];
                    shapeNAmes[j + 1] = temporary;

                }
                j++;
            }
            i++;
        }

        return shapeNAmes;
    }

    /**
     * Function to check that is point enclosed in a Shape or not
     * 
     * @param point
     * @return true or false
     */
    public String[] findEnclosedPoint(Point point) {

        Iterator<Shape> shape = screenList.iterator();
        String EnclosedShapes[] = new String[screenList.size()];
        int newIndex = 0;

        while (shape.hasNext()) {

            Shape shapeGet = shape.next();

            if (shapeGet.isPointEnclosed(point)) {

                System.out.println("Point is enclosed in : "
                        + shapeGet.getType());
                EnclosedShapes[newIndex++] = shapeGet.getType();

            }

        }
        String newString[] = new String[newIndex];
        for (int i = 0; i < newString.length; i++) {
            newString[i] = EnclosedShapes[i];
        }
        
        return newString;
    }
}
