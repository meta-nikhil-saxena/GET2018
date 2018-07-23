package AssignmentClasses;
/**
 * Class for Searching with Operation :
 * 
 * arrayLinearSearch(int[],int)
 * It has one more function for its operation :
 * linearSearchOperation(int[],int,int) : Performs internal searching Operation for arrayLinearSearch(int[],int)
 * 
 * binarySearch(int[],int)
 * It has one more function for its operation : 
 * binarySearchOperation(int[],int,int,int) : Performs internal search operation for binarySearch(int[],int)
 */


public class Search {

    /**
     * Helping Function to do Linear Search
     * 
     * @param array
     *            for linear search
     * @param value
     *            for which searching is done for
     * @param index
     *            for which array helps in traversing
     * @return index of element found else returns -1 if not found
     */
    int linearSearchOperation(int array[], int value, int index) {
        if (index < array.length) {
            if (array[index] == value) {
                return index;
            } else {
                return linearSearchOperation(array, value, index + 1);
            }
        }
        return -1;
    }

    /**
     * Function for Linear Search
     * 
     * @param array
     *            for linear search
     * @param value
     *            for which search is done
     * @return start index help in linearSearch function to traverse
     */
    public int arrayLinearSearch(int array[], int value) {
        int startIndex = 0;
        int indexOfElement = linearSearchOperation(array, value, startIndex);
        return indexOfElement;
    }

    /**
     * Helping function for Binary Search
     * 
     * @param array
     * @param startIndex
     * @param lastIndex
     * @param value
     * @return Index of element found
     */
    int binarySearchOperation(int array[], int startIndex, int lastIndex,
            int value) {
        if (lastIndex >= startIndex) {
            int midIndex = (startIndex + lastIndex) / 2;
            if (array[midIndex] == value) {
                return midIndex;
            }
            if (array[midIndex] > value) {
                return binarySearchOperation(array, startIndex, midIndex - 1,
                        value);
            }
            return binarySearchOperation(array, midIndex + 1, lastIndex, value);
        }
        return -1;
    }

    /**
     * Function for Binary Search
     * 
     * @param array
     * @param value
     * @return Index of element found
     */
    public int binarySearch(int array[], int value) {
        int startIndex = 0;
        int lastIndex = array.length - 1;
        int indexOfElement = binarySearchOperation(array, startIndex,
                lastIndex, value);
        return indexOfElement;
    }

    
    public static void main(String args[]) {
        System.out.println(new Search().arrayLinearSearch(new int[] { 1, 5, 6,
                4 }, 4));
        System.out.println(new Search().binarySearch(new int[] { 1, 4, 5,
                6 }, 4));
        
    }
}
