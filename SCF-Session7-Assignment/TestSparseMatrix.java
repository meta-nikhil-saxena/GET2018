import org.junit.Assert;
import org.junit.Test;

public class TestSparseMatrix {
    int sparse1[][] = new int[][] { { 0, 2, 1 }, { 1, 1, 3 }, { 2, 1, 4 } };
    int sparse2[][] = new int[][] { { 0, 2, 1 }, { 1, 0, 1 }, { 1, 2, 2 },
            { 2, 1, 2 } };

    SparseMatrix sparseMat1 = new SparseMatrix(3, 3, sparse1);
    SparseMatrix sparseMat2 = new SparseMatrix(3, 3, sparse2);

    /**
     * Test cases for Transpose of matrix
     */
    @Test
    public void testCheckTranspose1() {
        int result[][] = sparseMat1.transposeMatrix();
        Assert.assertArrayEquals(new int[][] { { 2, 0, 1 }, { 1, 1, 3 },
                { 1, 2, 4 } }, result);
    }

    @Test
    public void testCheckTranspose2() {
        int result[][] = sparseMat2.transposeMatrix();
        int expected[][] = { { 2, 0, 1 }, { 0, 1, 1 }, { 2, 1, 2 }, { 1, 2, 2 } };
        Assert.assertArrayEquals(expected, result);
    }

    /**
     * Test case to check symmetry of two matrix
     */
    @Test
    public void testCheckSymmetry1() {
        boolean result = sparseMat1.isSymmetrical();
        Assert.assertEquals(false, result);
    }

    @Test
    public void testCheckSymmetry2() {
        boolean result = sparseMat2.isSymmetrical();
        Assert.assertEquals(false, result);
    }

    /**
     * Test case to check addition of two matrix
     */

    @Test
    public void testCheckAddition() {

        int result[][] = sparseMat1.addTwoMatrix(sparseMat2);
        int expected[][] = { { 0, 4, 2 }, { 1, 0, 1 }, { 1, 1, 3 },
                { 1, 2, 2 }, { 4, 2, 6 } };
        Assert.assertArrayEquals(expected, result);

    }

    /**
     * Test case to check multiplication of two matrix
     */

    @Test
    public void testCheckMultiply() {

        int result[][] = sparseMat1.multiply(sparseMat2);
        int expected[][] = { { 0, 1, 2 }, { 1, 0, 3 }, { 1, 2, 6 },
                { 2, 0, 4 }, { 2, 2, 8 } };
        Assert.assertArrayEquals(expected, result);

    }
}
