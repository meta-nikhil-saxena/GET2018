package AssignmentClasses;

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

    public int[][] N_Queen_Board(int chessBoard[][]) {
        int rowValue = 0;
        if (funcOperation(chessBoard, rowValue)) {
            return chessBoard;
        }
        return new int[][] {};

    }
}
