package graphics;

import java.util.Date;

import interfaceModule.Shape;

public class Rectangle implements Shape {

    private int length;
    private int width;
    private int xCoordinate;
    private int yCoordinate;
    private Date date;

    private final String SHAPE = "RECTANGLE";

    public Rectangle(int length, int width, Point point) {
        this.length = length;
        this.width = width;

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

    public int getLength() {
        return length;
    }

    public int getWidth() {
        return width;
    }

    public int getXcoordinate() {
        return xCoordinate;
    }

    public int getYcoordinate() {
        return yCoordinate;
    }

    // Setters and getters END

    public float getArea() {

        return this.length * this.width;
    }

    public float getPerimeter() {

        return (2 * (this.length + this.width));
    }

    public String getOrigin() {

        return "(" + this.xCoordinate + "," + this.yCoordinate + ")";
    }

    public boolean isPointEnclosed(Point point) {
        int xCoordinate = point.getxCoordinate();
        int yCoordinate = point.getyCoordinate();

        int x1 = this.xCoordinate;
        int y1 = this.yCoordinate;

        int x2 = x1;
        int y2 = y1 + this.length;

        int x3 = x1 + this.width;
        int y3 = y2;

        int x4 = x3;
        int y4 = y1;

        if ((xCoordinate < x1 && yCoordinate < y1)
                && (xCoordinate < x2 && yCoordinate < y2)
                && (xCoordinate < x3 && yCoordinate < y3)
                && (xCoordinate < x4 && yCoordinate < y4)) {

            return false;
        }
        if ((xCoordinate > x1 && yCoordinate > y1)
                && (xCoordinate > x2 && yCoordinate > y2)
                && (xCoordinate > x3 && yCoordinate > y3)
                && (xCoordinate > x4 && yCoordinate > y4)) {

            return false;
        }

        return true;

    }

}
