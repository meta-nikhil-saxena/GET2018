package AssignmentClasses;

import java.util.Scanner;

/**
 * 
 * N_Qeen problem class
 *
 */
public class N_Queen {

    /**
     * Recursive function for operation and used for back tracking also
     * 
     * @param chessBoard
     * @param row
     * @return
     */
    boolean funcOperation(int chessBoard[][], int row) {
        int length = chessBoard.length;

        if (row >= length) {
            return true;
        }
        for (int column = 0; column < length; column++) {
            if (isCorrectPosition(chessBoard, row, column)) {
                chessBoard[row][column] = 1;

                if (funcOperation(chessBoard, row + 1)) {
                    return true;
                }
                chessBoard[row][column] = 0;

            }
        }

        return false;
    }

    /**
     * Function to check the position for Queen is safe or not
     * 
     * @param chessBoard
     * @param row
     * @param column
     * @return true if position safe or else false
     */
    boolean isCorrectPosition(int chessBoard[][], int row, int column) {
        // Check the vertical of current column if the queen is not there
        // already
        for (int i = 0; i < row; i++) {
            if (chessBoard[i][column] == 1) {
                return false;
            }
        }

        // Check left Upper diagonal
        for (int row1 = row, column1 = column; row1 >= 0 && column1 >= 0; row1--, column1--) {
            if (chessBoard[row1][column1] == 1) {
                return false;
            }
        }

        // check right upper diagonal
        for (int row1 = row, column1 = column; row1 >= 0
                && column1 < chessBoard.length; row1--, column1++) {
            if (chessBoard[row1][column1] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String args[]) {

        N_Queen nqueen = new N_Queen();
        Scanner sc = new Scanner(System.in);

        int row = 0; // Taking Start Index and passing in function to traverse
                     // the board and place queen
        System.out.println("Enter size of 2-D array");
        int size = sc.nextInt();
        int chessBoard[][] = new int[size][size];

        // Only Square matrix can possible
        if (chessBoard.length % 2 != 0) {
            System.out.println("Not possible if not a square matrix");
            System.exit(0);
        }

        System.out.println("Array element entered");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                chessBoard[i][j] = 0;
                System.out.print("     " + chessBoard[i][j] + "     ");
            }
            System.out.println();
        }

        // Function to Perform and fix queen positioning
        if (nqueen.funcOperation(chessBoard, row)) {
            System.out.println();
            System.out.println("Queen Placed At Perfect positioning");
            for (int i = 0; i < chessBoard.length; i++) {
                for (int j = 0; j < chessBoard.length; j++) {
                    System.out.print("     " + chessBoard[i][j] + "     ");
                }
                System.out.println();
            }
        }
    }
}
