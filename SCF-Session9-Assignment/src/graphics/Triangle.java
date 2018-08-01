package graphics;

import java.util.Date;

import interfaceModule.Shape;

public class Triangle implements Shape {

    private int side1;
    private int side2;
    private int side3;
    private int xCoordinate;
    private int yCoordinate;
    private Date date;
    private final String SHAPE = "TRIANGLE";

    public Triangle(int side1, int side2, int side3, Point point) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

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

    public int getside1() {
        return side1;
    }

    public int getside2() {
        return side2;
    }

    public int getside3() {
        return side3;
    }

    public int getXcoordinate() {
        return xCoordinate;
    }

    public int getYcoordinate() {
        return yCoordinate;
    }

    // Setters and getters END

    public float getArea() {
        float sides = (float) ((this.side1 + this.side2 + this.side3) / 2);
        float solution = (sides * ((sides - side1) + (sides - side2) + (sides - side3)));
        float finalsol = (float) Math.sqrt(solution);
        return finalsol;
    }

    public float getPerimeter() {
        float sides = (float) ((this.side1 + this.side2 + this.side3) / 2);
        return sides;
    }

    public String getOrigin() {

        return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
    }

    public boolean isPointEnclosed(Point point) {

        int xCoordinate = point.getxCoordinate();
        int yCoordinate = point.getyCoordinate();

        int x1 = this.xCoordinate;
        int y1 = this.yCoordinate;

        int x2 = x1 + this.side1;
        int y2 = y1 + this.side1;

        int x3 = x2 + side2;
        int y3 = y2 - side2;

        if ((xCoordinate < x1 && yCoordinate < y1)
                && (xCoordinate < x2 && yCoordinate < y2)
                && (xCoordinate < x3 && yCoordinate < y3)) {

            return false;
        }
        if ((xCoordinate > x1 && yCoordinate > y1)
                && (xCoordinate > x2 && yCoordinate > y2)
                && (xCoordinate > x3 && yCoordinate > y3)) {

            return false;
        }

        return true;
    }

}
