package assignment2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestInsert {

    @Test
    public void testImageOperation1() {

        List<InsertImages> imagelist = new ArrayList<InsertImages>();

        InsertImages image = new InsertImages(1, "abc",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image1 = new InsertImages(1, "bsd",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image2 = new InsertImages(1, "def",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image3 = new InsertImages(1, "fgh",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");

        imagelist.add(image);
        imagelist.add(image1);
        imagelist.add(image2);
        imagelist.add(image3);

        ImageOperation imageopr = new ImageOperation();

        assertEquals(4, imageopr.insert(1, imagelist));

    }

    @Test
    public void testImageOperation2() {

        List<InsertImages> imagelist = new ArrayList<InsertImages>();

        InsertImages image = new InsertImages(2, "Image1",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image1 = new InsertImages(2, "Image2",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image2 = new InsertImages(2, "Image3",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image3 = new InsertImages(2, "Image4",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image4 = new InsertImages(2, "Image5",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image5 = new InsertImages(2, "Image6",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image6 = new InsertImages(2, "Image7",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");
        InsertImages image7 = new InsertImages(2, "Image8",
                "D:\\New folder\\GET2018\\GET2018\\DBMS-Assignment-2");

        imagelist.add(image);
        imagelist.add(image1);
        imagelist.add(image2);
        imagelist.add(image3);
        imagelist.add(image4);
        imagelist.add(image5);
        imagelist.add(image6);
        imagelist.add(image7);

        ImageOperation imageopr = new ImageOperation();

        assertEquals(8, imageopr.insert(1, imagelist));

    }

}
