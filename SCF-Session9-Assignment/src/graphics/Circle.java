package graphics;

import java.util.Date;

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

    public boolean isPointEnclosed(int xCoordinate,int yCoordinate) {
        // TODO Auto-generated method stub
        return false;
    }

}
