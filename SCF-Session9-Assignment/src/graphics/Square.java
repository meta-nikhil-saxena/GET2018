package graphics;

import java.util.Date;

import interfaceModule.Shape;

public class Square implements Shape {

    private int side;
    private int xCoordinate;
    private int yCoordinate;
    private Date date;
    private final String SHAPE = "SQUARE";

    public Square(int side, Point point) {
        this.side = side;

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

    public int getXcoordinate() {
        return xCoordinate;
    }

    public int getYcoordinate() {
        return yCoordinate;
    }

    public int getSide() {
        return side;
    }

    // Setters and getters END

    public float getArea() {
        float area;
        area = this.side * this.side;

        return area;
    }

    public float getPerimeter() {
        float perimeter;
        perimeter = 4 * this.side;
        return perimeter;
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
        int y2 = y1 + this.side;

        int x3 = x1 + this.side;
        int y3 = y2;

        int x4 = x1 + this.side;
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
