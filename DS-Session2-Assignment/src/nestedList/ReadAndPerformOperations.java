package nestedList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadAndPerformOperations implements nestedList.List {

    List<Object> listOfList = new ArrayList<Object>();

    // Initializing list object

    public ReadAndPerformOperations(List<Object> listOflist) {
        this.listOfList.addAll(listOflist);

    }

    // Getter method to get the list

    public List<Object> getListOfList() {
        return listOfList;
    }

    // End getter method

    /**
     * Function to return the sum of the list
     */
    @SuppressWarnings("unchecked")
    @Override
    public int getSum() {
        int getSumOfList = 0;

        Iterator<Object> outter = listOfList.iterator();
        while (outter.hasNext()) {
            Object outObject = outter.next();

            if (outObject instanceof List) {
                Iterator<Object> inner = ((List<Object>) outObject).iterator();
                while (inner.hasNext()) {
                    Object inObject = inner.next();

                    int inValue = (Integer) inObject;
                    getSumOfList += inValue;
                }

            } else {
                int outValue = (Integer) outObject;
                getSumOfList += outValue;
            }
        }

        return getSumOfList;
    }

    /**
     * Function to return the largest number from the list
     */
    @SuppressWarnings("unchecked")
    @Override
    public int getLargest() {
        int largest = 0;
        Iterator<Object> outter = listOfList.iterator();
        while (outter.hasNext()) {
            Object outObject = outter.next();

            if (outObject instanceof List) {
                Iterator<Object> inner = ((List<Object>) outObject).iterator();
                while (inner.hasNext()) {
                    Object inObject = inner.next();

                    int inValue = (Integer) inObject;
                    if (inValue > largest) {
                        largest = inValue;
                    }
                }

            } else {
                int outValue = (Integer) outObject;
                if (outValue > largest) {
                    largest = outValue;
                }
            }
        }
        return largest;
    }

    @SuppressWarnings("unchecked")
    @Override
    public int Search(int value) {

        int Subindexindex = 0;
        int index = 0;

        Iterator<Object> outter = listOfList.iterator();
        while (outter.hasNext()) {
            Object outObject = outter.next();

            if (outObject instanceof List) {

                Iterator<Object> inner = ((List<Object>) outObject).iterator();
                while (inner.hasNext()) {
                    Object inObject = inner.next();

                    int inValue = (Integer) inObject;
                    if (inValue == value) {
                        System.out.println("SubIndex in Index : " + index);
                        return Subindexindex;
                    }
                    Subindexindex++;
                }
                index++;
            } else {

                int outValue = (Integer) outObject;
                if (outValue == value) {
                    return index;
                }
                index++;
            }
        }
        return 0;
    }

    /**
     * Function to extract element with the given pattern
     */
    @SuppressWarnings("unchecked")
    @Override
    public int getValue(String pattern) {

        int elementedExtracted = 0;
        pattern.trim();
        int i = 0;

        if (listOfList.size() < pattern.length()) {
            throw new AssertionError(
                    "Size of list is smaller than pattern size");
        }

        while (i < pattern.length()) {

            // If there is T remove the head
            if (pattern.charAt(i) == 'T') {
                listOfList.remove(0);

                // if there is H and at last index there is list throw error
            } else if (pattern.charAt(i) == 'H' && i == pattern.length()) {

                if (listOfList.get(0) instanceof List) {

                    throw new AssertionError("!! Error !!");

                }

            } else {
                // if H and instance of list than iterate inside the list and
                // extract the element
                if (listOfList.get(0) instanceof List) {

                    Iterator<Object> inner = ((List<Object>) listOfList.get(0))
                            .iterator();

                    while (inner.hasNext()) {
                        Object inObject = inner.next();

                        int inValue = (Integer) inObject;
                        elementedExtracted = inValue;
                        break;
                    }

                } else {
                    elementedExtracted = (Integer) listOfList.get(0);
                }

            }
            i++;
        }
        return elementedExtracted;

    }

}
