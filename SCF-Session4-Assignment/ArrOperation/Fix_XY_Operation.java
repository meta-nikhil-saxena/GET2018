package ArrOperation;
// Class for checking some important cases in Array

public class Fix_XY_Operation {

    /**
     * Function for swap two indexes in array
     * 
     * @param array
     * @param index_X
     * @param index_Y
     */
    void swapInArray(int array[], int index_X, int index_Y) {
        int temporaryForSwap;
        temporaryForSwap = array[index_X + 1];
        array[index_X + 1] = array[index_Y];
        array[index_Y] = temporaryForSwap;
    }

    /**
     * Function to check array is empty or not
     * 
     * @param array
     *            throws assertionError if empty
     */
    void checkEmpty(int array[]) {
        if (array.length <= 0) {
            throw new AssertionError("!! Empty Array !!");
        }

    }

    /**
     * Function to check count of X and Y in fix_XY
     * 
     * @param array
     * @param x
     * @param y
     *            throws assertionError
     */
    void checkNumberOf_XY(int array[], int x, int y) {
        int countX = 0, countY = 0;
        for (int i = 0; i < array.length; i++) {
            if (x == array[i]) {
                countX++;
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (y == array[i]) {
                countY++;
            }
        }
        if (countX != countY) {
            throw new AssertionError("!! Unequal number of X and Y");
        }
    }

    /**
     * Function to check two adjacent X
     * 
     * @param array
     * @param x
     *            throws assertionError
     */
    void checkTwoAdjacent_X(int array[], int x) {
        for (int i = 0; i < array.length - 1; i++) {
            if (x == array[i] && x == array[i + 1]) {
                throw new AssertionError("!! There are two Adjacent X !! ");
            }
        }
    }

    /**
     * Function to check if, at last X is not there
     * 
     * @param array
     * @param x
     *            throws assertionError
     */
    void checkLastIndex(int array[], int x) {
        if (array[array.length - 1] == x) {
            throw new AssertionError("!! X cannot be at last Index !! ");
        }
    }

}
