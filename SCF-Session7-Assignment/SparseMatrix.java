
//Class for sparse matrix Operations

package SCF_Session7_Assignment;

public final class SparseMatrix {

    final private int row;
    final private int column;
    final private int IndexOfNonZero[][];

    /**
     * Parameterized Constructor for initialization of values
     * 
     * @param row
     * @param column
     * @param IndexOfNonZero
     */
    SparseMatrix(int row, int column, int IndexOfNonZero[][]) {
        this.row = row;
        this.column = column;
        this.IndexOfNonZero = IndexOfNonZero;
    }

    // Helper functions START !!

    /**
     * Helper function to check if two matrix are valid for addition
     * 
     * @param row
     * @param column
     * @param sparse2
     * @return true or false
     */
    private boolean checkForSquareMatrix(SparseMatrix sparse) {
        if (this.row != sparse.row || this.column != sparse.column) {
            return false;
        }
        return true;
    }

    /**
     * Helper function to check if two matrix are valid for multiplication
     * 
     * @param row
     * @param column
     * @param sparse2
     * @return true or false
     */
    private boolean checkForMultiply(SparseMatrix sparse2) {
        if (this.row != sparse2.column) {
            return false;
        }
        return true;
    }

    /**
     * Helper function to sort
     * 
     * @param array
     * @return
     */
    private int[][] sort(int array[][]) {
        for (int index = 0; index < array.length; index++) {
            for (int index2 = 0; index2 < (array.length - 1) - index; index2++) {
                if (array[index2][0] > array[index2 + 1][0]) {
                    for (int index3 = 0; index3 < 3; index3++) {
                        // swapping for row index2 and column index3
                        int temp = array[index2][index3];
                        array[index2][index3] = array[index2 + 1][index3];
                        array[index2 + 1][index3] = temp;
                    }
                }
                if (array[index2][0] == array[index2 + 1][0]
                        && array[index2][1] > array[index2 + 1][1]) {
                    for (int index3 = 1; index3 < 3; index3++) {
                        // swapping for row index2 and column index3
                        int temp = array[index2][index3];
                        array[index2][index3] = array[index2 + 1][index3];
                        array[index2 + 1][index3] = temp;
                    }
                }
            }
        }
        return array;
    }

    /**
     * Helper function for making deep copy
     * 
     * @param array
     * @return array with deep copy
     */
    private int[][] getDeepCopy(int array[][]) {
        int newArray[][] = new int[this.IndexOfNonZero.length][this.IndexOfNonZero[0].length];

        // Making a deep copy of new array references
        for (int row = 0; row < this.IndexOfNonZero.length; row++) {
            for (int column = 0; column < this.IndexOfNonZero[0].length; column++) {
                newArray[row][column] = this.IndexOfNonZero[row][column];
            }
        }
        return newArray;
    }

    // Helper Function END !!

    /**
     * Function to transpose a matrix;
     * 
     * @return transpose[][];
     */
    public int[][] transposeMatrix() {

        int transpose[][] = this.getDeepCopy(IndexOfNonZero);

        // Swaping rows and column to have transposed result
        for (int row = 0, column = 0; row < transpose.length; row++) {

            int temporary = transpose[row][column];
            transpose[row][column] = transpose[row][column + 1];
            transpose[row][column + 1] = temporary;
        }
        return transpose;
    }

    /**
     * Function to check two sparse matrix are symmetrical or not
     * 
     * @return true or false
     */
    public boolean isSymmetrical() {

        // Making deep copy to make class remain immutable

        int newArray[][] = this.getDeepCopy(IndexOfNonZero);
        SparseMatrix sparse = new SparseMatrix(newArray.length,
                newArray[0].length, newArray);
        int transpose[][] = sparse.transposeMatrix();

        // Here 0 and 1 denotes the fix row number and column number of sparse
        // matrix non-zero element
        for (int index = 0; index < transpose.length; index++) {
            if (newArray[index][0] != transpose[index][0]
                    && newArray[index][1] != transpose[index][1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Addition of two Sparse Matrix
     * 
     * @param sparse2
     * @return Add result in 2D array
     */
    public int[][] addTwoMatrix(SparseMatrix sparse2) throws AssertionError {
        if (!this.checkForSquareMatrix(sparse2)) {
            throw new AssertionError("Not a square matrtix for addition");
        }
        int AddOfMatrix[][] = new int[this.IndexOfNonZero.length
                + sparse2.IndexOfNonZero.length][this.IndexOfNonZero[0].length];

        int newIndex = 0;

        // Here 0,1,2 are the fix index length of row ,column and element of
        // sparse matrix
        for (int index = 0; index < this.IndexOfNonZero.length; index++) {
            AddOfMatrix[newIndex][0] = this.IndexOfNonZero[index][0];
            AddOfMatrix[newIndex][1] = this.IndexOfNonZero[index][1];
            AddOfMatrix[newIndex][2] = this.IndexOfNonZero[index][2];
            newIndex++;
        }

        for (int index = 0; index < sparse2.IndexOfNonZero.length; index++) {
            AddOfMatrix[newIndex][0] = sparse2.IndexOfNonZero[index][0];
            AddOfMatrix[newIndex][1] = sparse2.IndexOfNonZero[index][1];
            AddOfMatrix[newIndex][2] = sparse2.IndexOfNonZero[index][2];
            newIndex++;
        }

        this.sort(AddOfMatrix);

        int Addition[][] = new int[AddOfMatrix.length][AddOfMatrix[0].length];

        int newIndexAdd = 0;
        int count = 0;

        // Here 0,1,2 are the fix index length of row ,column and element of
        // sparse matrix
        for (int index = 0; index < Addition.length - 1; index++) {
            if (AddOfMatrix[index][0] == AddOfMatrix[index + 1][0]
                    && AddOfMatrix[index][1] == AddOfMatrix[index + 1][1]) {

                Addition[index][0] = AddOfMatrix[index][0]
                        + AddOfMatrix[index + 1][0];

                Addition[index][1] = AddOfMatrix[index][1]
                        + AddOfMatrix[index + 1][1];

                Addition[index][2] = AddOfMatrix[index][2]
                        + AddOfMatrix[index + 1][2];
                index++;
                newIndexAdd++;
                count++;
            } else {
                Addition[index][0] = AddOfMatrix[index][0];
                Addition[index][1] = AddOfMatrix[index][1];
                Addition[index][2] = AddOfMatrix[index][2];
                newIndexAdd++;
            }
        }

        this.sort(Addition);

        int ArrayAfterAddition[][] = new int[newIndexAdd][Addition[0].length];

        // Here 0,1,2 are the fix index length of row ,column and element of
        // sparse matrix

        for (int index = 0; index < newIndexAdd; index++) {

            ArrayAfterAddition[index][0] = Addition[index + count][0];
            ArrayAfterAddition[index][1] = Addition[index + count][1];
            ArrayAfterAddition[index][2] = Addition[index + count][2];

        }
        return ArrayAfterAddition;
    }

    /**
     * Function to multiply two sparse matrix
     * 
     * @param sparse2
     * @return multiplication of matrix
     */
    public int[][] multiply(SparseMatrix sparse2) throws AssertionError {
        if (!this.checkForMultiply(sparse2)) {
            throw new AssertionError("Invalid Size");
        }
        int k = 0; // Temporary index for storing multiplication of matrix
        int matrix[][] = sparse2.getDeepCopy(IndexOfNonZero);
        int multiply[][] = new int[this.IndexOfNonZero.length
                + sparse2.IndexOfNonZero.length][this.IndexOfNonZero[0].length];

        matrix = sparse2.transposeMatrix();
        sort(matrix);
        int index1, index2;

        for (index1 = 0; index1 < IndexOfNonZero.length;) {

            int row = IndexOfNonZero[index1][0];

            for (index2 = 0; index2 < matrix.length;) {

                int column = matrix[index2][0];

                // temporary pointers created to add all
                // multiplied values to obtain current
                // element of result matrix
                int tempa = index1;
                int tempb = index2;

                int sum = 0;

                // iterate over all elements with
                // same row and col value
                // to calculate result[r]
                while (tempa < IndexOfNonZero.length
                        && IndexOfNonZero[tempa][0] == row
                        && tempb < matrix.length && matrix[tempb][0] == column) {

                    if (IndexOfNonZero[tempa][1] < matrix[tempb][1])

                        // skip a
                        tempa++;

                    else if (IndexOfNonZero[tempa][1] > matrix[tempb][1])

                        // skip b
                        tempb++;

                    else

                        // same col, so multiply and increment
                        sum += IndexOfNonZero[tempa++][2] * matrix[tempb++][2];
                }

                if (sum != 0) {
                    // result.insert(r, c, sum);

                    multiply[k][0] = row;
                    multiply[k][1] = column;
                    multiply[k][2] = sum;

                    k++;
                }

                while (index2 < matrix.length && matrix[index2][0] == column)

                    // jump to next column
                    index2++;
            }
            while (index1 < IndexOfNonZero.length
                    && IndexOfNonZero[index1][0] == row)

                // jump to next row
                index1++;
        }
        int multiplyTwoSparse[][] = new int[k][this.IndexOfNonZero[0].length];

        for (int index = 0; index < k; index++) {

            multiplyTwoSparse[index][0] = multiply[index][0];
            multiplyTwoSparse[index][1] = multiply[index][1];
            multiplyTwoSparse[index][2] = multiply[index][2];

        }
        return multiplyTwoSparse;
    }

    public static void main(String args[]) {

        // Stored non-zero index in a 2D array
        int sparse1[][] = new int[][] { { 0, 2, 1 }, { 1, 1, 3 }, { 2, 1, 4 } };
        int sparse2[][] = new int[][] { { 0, 2, 1 }, { 1, 0, 1 }, { 1, 2, 2 },
                { 2, 1, 2 } };

        SparseMatrix sparseMat1 = new SparseMatrix(3, 3, sparse1);
        SparseMatrix sparseMat2 = new SparseMatrix(3, 3, sparse2);

        System.out.println("Check for symmetry : ");
        System.out.println(sparseMat1.isSymmetrical());
        System.out.println(sparseMat2.isSymmetrical());

        System.out.println("Before  transpose of sparse 1 : ");
        for (int row = 0; row < sparse1.length; row++) {
            for (int column = 0; column < sparse1[0].length; column++) {
                System.out.print(sparse1[row][column]);
            }
            System.out.println();
        }

        System.out.println("After Transpose of matrix Sparse1");
        int transpose[][] = sparseMat1.transposeMatrix();
        // int transposeSort1[][] = new int[3][3];
        // int transposeSort1[][] = sparseMat1.sort(transpose);
        for (int row1 = 0; row1 < transpose.length; row1++) {
            for (int column1 = 0; column1 < transpose[0].length; column1++) {
                System.out.print(transpose[row1][column1]);
            }
            System.out.println();
        }

        System.out.println("Before  transpose of sparse 2 : ");
        for (int row = 0; row < sparse2.length; row++) {
            for (int column = 0; column < sparse2[0].length; column++) {
                System.out.print(sparse2[row][column]);
            }
            System.out.println();
        }

        System.out.println("After Transpose of matrix Sparse2");
        int transpose1[][] = sparseMat2.transposeMatrix();
        // int transposeSort1[][] = new int[3][3];
        // int transposeSort2[][] = sparseMat2.sort(transpose1);
        for (int row1 = 0; row1 < transpose1.length; row1++) {
            for (int column1 = 0; column1 < transpose1[0].length; column1++) {
                System.out.print(transpose1[row1][column1]);
            }
            System.out.println();
        }
        // sparseMat2.isSymmetrical();
        int addOfTwoMatrix[][] = sparseMat1.addTwoMatrix(sparseMat2);
        System.out.println("Addition of sparse1 and sparse2 : ");
        for (int row = 0; row < addOfTwoMatrix.length; row++) {
            for (int column = 0; column < addOfTwoMatrix[0].length; column++) {
                System.out.print(addOfTwoMatrix[row][column]);
            }
            System.out.println();
        }

        System.out.println("Multiplication of sparse1 and sparse2");
        int multiply[][] = sparseMat1.multiply(sparseMat2);
        for (int row1 = 0; row1 < multiply.length; row1++) {
            for (int column1 = 0; column1 < multiply[0].length; column1++) {
                System.out.print(multiply[row1][column1]);
            }
            System.out.println();
        }

    }
}
