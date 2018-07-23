package ArrOperation;

/**
 * Array Operation containing following operation :
 * 
 * maxMirrorInArray(int[]) clumpInArray(int[]) fix_XY(int[]) splitArray(int[])
 */

public class ArrOperation {
    Fix_XY_Operation operation_XY = new Fix_XY_Operation();

    /**
     * Calculates Max mirror length in array
     * 
     * @param array
     * @return max length
     */
    public int maxMirrorLengthInArray(int array[]) {

        operation_XY.checkEmpty(array);

        int count = 0, maxCount = 0;

        for (int i = 0; i < array.length - 1; i++) {
            int k = i;
            for (int j = array.length - 1; (j >= 0 && k < array.length); j--) {
                if (array[j] != array[k]) {
                    count = 0;
                }
                if (array[j] == array[k]) {
                    k++;
                    count++;

                    if (count > array.length) {
                        break;
                    }

                    if (count >= maxCount) {
                        maxCount = count;
                    }

                }

            }
        }
        return maxCount;
    }

    /**
     * Calculates max numbers of Adjacent elements in array
     * 
     * @param array
     * @return max adjacent elements
     */
    public int clumpInArray(int array[]) {

        operation_XY.checkEmpty(array);

        int n, count = 0;

        for (int i = 0; i < array.length - 1; i++) {
            n = array[i];
            if (n == array[i + 1]) {
                count++;
                for (int j = i + 2; j < array.length; j++) {
                    if (n == array[j]) {
                        i = j;
                    } else {
                        break;
                    }
                }
            }
        }
        return count;
    }

    /**
     * function for giving a new array with x and y at correct positions
     * 
     * @param array
     * @param x
     * @param y
     * @return array with correct positioning elements
     */
    public int[] fix_XY(int array[], int x, int y) {

        operation_XY.checkEmpty(array);
        operation_XY.checkNumberOf_XY(array, x, y);
        operation_XY.checkTwoAdjacent_X(array, x);
        operation_XY.checkLastIndex(array, x);

        int index_X = 0, index_Y = 0, j = 0;

        for (int i = 0; i < array.length - 1; i++) {
            if (x == array[i]) {
                if (y != array[i + 1]) {
                    for (; j < array.length; j++) {
                        if (y == array[j]) {
                            index_X = i;
                            index_Y = j;
                            i = index_X + 1;
                            j = index_X + 2;
                            break;
                        }
                    }
                    operation_XY.swapInArray(array, index_X, index_Y);
                }
            }
        }
        return array;
    }

    /**
     * Split array function so that both sides sum are equal
     * 
     * @param array
     * @return the index from which array can be split
     */
    public int splitArray(int array[]) {

        int sum1 = 0, sum2 = 0;

        for (int i = 0; i < array.length; i++) {
            sum1 = 0;
            sum2 = 0;
            for (int j = 0; j <= i; j++) {
                sum1 += array[j];
            }
            for (int k = i + 1; k < array.length; k++) {
                sum2 += array[k];
                if (sum2 > sum1) {
                    break;
                }

            }
            if (sum1 == sum2) {
                return i + 1;
            }
        }
        return -1;

    }

    public static void main(String args[]) {

    }

}
