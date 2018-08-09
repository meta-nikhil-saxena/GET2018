package testCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import nestedList.ReadAndPerformOperations;

import org.junit.Test;

public class TestNestedList {

    // Function to test the getsum function
    @Test
    public void testgetSum() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(1);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(1);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int sum = read.getSum();

        assertEquals(sum, 6);

    }

    @Test
    public void testgetSum2() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(2);
        listOflist.add(3);
        listOflist.add(4);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(1);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int sum = read.getSum();

        assertEquals(sum, 12);

    }

    @Test
    public void testgetSum3() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(1);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(3);
        sublist.add(3);
        sublist.add(3);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int sum = read.getSum();

        assertEquals(sum, 12);

    }

    @Test
    public void testgetSum4() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(1);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(12);
        sublist.add(1);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int sum = read.getSum();

        assertEquals(sum, 17);

    }

    // Function to check the getlargest function
    @Test
    public void testgetLargest() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(1);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int largest = read.getLargest();

        assertEquals(largest, 6);

    }

    @Test
    public void testgetLargest2() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(10);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int largest = read.getLargest();

        assertEquals(largest, 10);

    }

    // Function for test the search function
    @Test
    public void testsearch() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(10);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int index = read.Search(10);

        assertEquals(index, 1);

    }

    @Test
    public void testsearch2() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(10);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int index = read.Search(6);

        assertEquals(index, 1);

    }

    // Test function to check getValue function
    @Test
    public void testgetValue() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(10);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int value = read.getValue("TH");

        assertEquals(value, 10);

    }

    @Test
    public void testgetValue2() {
        List<Object> listOflist = new ArrayList<Object>();

        listOflist.add(1);
        listOflist.add(10);
        listOflist.add(1);

        List<Object> sublist = new ArrayList<Object>();
        sublist.add(1);
        sublist.add(6);
        sublist.add(1);

        listOflist.add(sublist);

        ReadAndPerformOperations read = new ReadAndPerformOperations(listOflist);

        int value = read.getValue("TTH");

        assertEquals(value, 1);

    }

}
