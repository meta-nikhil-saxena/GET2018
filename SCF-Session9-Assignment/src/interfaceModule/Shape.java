package interfaceModule;

import java.util.Date;

//Interface to define shapes functionallity
public interface Shape {

    float getArea();

    float getPerimeter();

    String getOrigin();

    boolean isPointEnclosed(int x,int y);

    String getType();

    Date getDate();

    int getXcoordinate();

    int getYcoordinate();

    void setDate(Date date);
}
