package graphics;

import java.util.Date;

import mainWorking.Screen;
import interfaceModule.Shape;

public class Circle implements Shape {

    private int radius;
    private int xCoordinate;
    private int yCoordinate;
    private Date date;

    private final String SHAPE = "CIRCLE";

    public Circle(int radius, Point point) {
        this.radius = radius;

        this.xCoordinate = point.getxCoordinate();
        this.yCoordinate = point.getyCoordinate();

    }

    // Setters and getters START
    public String getType() {

        return this.SHAPE;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRadius() {
        return radius;
    }

    public int getXcoordinate() {
        return xCoordinate;
    }

    public int getYcoordinate() {
        return yCoordinate;
    }

    // Setters and getters END

    public float getArea() {
        float area;
        area = (float) (3.14 * this.radius * this.radius);

        return area;
    }

    public float getPerimeter() {
        float perimeter;
        perimeter = (float) (2 * 3.14 * this.radius);

        return perimeter;
    }

    public String getOrigin() {

        return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
    }

    public boolean isPointEnclosed(Point point) {

        // Points given by user to check that is it enclosed
        int xCoordinate = point.getxCoordinate();
        int yCoordinate = point.getyCoordinate();

        // Checking range of points given

        if (xCoordinate > Screen.getMAX_XCOORDINATE()
                && yCoordinate > Screen.getMAX_YCOORDINATE()) {

            System.out.println("Out Of Range");
            throw new AssertionError("Out of Range");
        }

        // Origin of the graph(0,0)
        int x1 = Screen.getMIN_XCOORDINATE();
        int y1 = Screen.getMIN_YCOORDINATE();

        // Origin of circle stored in circle
        int x = this.xCoordinate;
        int y = this.yCoordinate;

        /**
         * x2 : is point of center xCoordinate y2 : is point of center
         * yCoordinate
         * 
         * ratio1 : is the ratio of line by section formula ratio2 : is the
         * second point in ratio of line by radius of circle given
         */
        int x2, y2, ratio1, ratio2 = this.radius;

        // To calculate distance between two point, which is the ratio1
        int calculate = (x - x1) * (x - x1) + (y - y1) * (y - y1);

        ratio1 = (int) Math.sqrt(calculate);

        x2 = (x * (ratio1 + ratio2) / ratio1) - ratio2 * x1;
        y2 = (y * (ratio1 + ratio2) / ratio1) - ratio2 * y1;

        // To find distance between two point to find that the given point is
        // enclosed in figure

        int calculate2 = (xCoordinate - x2) * (xCoordinate - x2)
                + (yCoordinate - y2) * (yCoordinate - y2);

        int distance = (int) Math.sqrt(Math.abs(calculate2));

        // checking the distance between point to be checked and the center of
        // circle if distance is less point is enclosed
        if (distance < ratio2) {
            return true;
        }

        return false;
    }
}
