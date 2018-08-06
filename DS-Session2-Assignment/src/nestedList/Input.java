package nestedList;


import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

public class Input {

    // Creating json object
    List<Object> listOfList = new ArrayList<Object>();
    Scanner scanInput = new Scanner(System.in);

    public List<Object> inputInObject()  {

        System.out.println("Enter element in list : ");
        // Entering element inside list
        listOfList.add(scanInput.nextInt());
        listOfList.add(scanInput.nextInt());

        // Creating new list inside the list
        List<Object> newList = new ArrayList<Object>();
        System.out.println("Enter element inside list of list : ");
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());

        listOfList.add(newList);

        // Creating new list inside the list
        newList = new ArrayList<Object>();
        System.out.println("Enter element inside list of list : ");
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());
        newList.add(scanInput.nextInt());

        listOfList.add(newList);

        return listOfList;
    }
}
