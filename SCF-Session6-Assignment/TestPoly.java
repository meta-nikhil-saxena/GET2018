package AssignmentClasses;

import org.junit.Assert;
import org.junit.Test;

//Class to test for poly class
public class TestPoly {

    Poly polynomial1 = new Poly(new int[] { 1, 1 });
    Poly polynomial2 = new Poly(new int[] { 2, 2, 1 });

    /**
     * Test to check evaluate function
     */
    // Positive test case
    @Test
    public void testEvaluate() {
        float result = polynomial1.evaluate(2);
        Assert.assertEquals(3, result, 0.0002);
    }

    @Test
    public void testEvaluate2() {
        float result = polynomial2.evaluate(1);
        Assert.assertEquals(5, result, 0.0002);
    }

    // Negative test case
    @Test
    public void testNegativeEvaluate() {
        float result = polynomial1.evaluate(2);
        Assert.assertNotEquals(5, result, 0.0002);
    }

    @Test
    public void testNegativeEvaluate2() {
        float result = polynomial2.evaluate(1);
        Assert.assertNotEquals(56, result, 0.0002);
    }

    /**
     * Test to add two poly function
     */
    @Test
    public void testadd() {
        int result[] = polynomial1.addTwoPoly(polynomial2);
        Assert.assertArrayEquals(new int[] { 2, 3, 2 }, result);
    }

    // Negative test case
    @Test
    public void testNegativeadd() {
        int result[] = polynomial1.addTwoPoly(polynomial2);
        Assert.assertNotEquals(new int[] { 3, 3, 3 }, result);
    }

    /**
     * Test to multiply two poly function
     */
    @Test
    public void testMultiply() {
        int result[] = polynomial1.multiplyTwoPoly(polynomial2);
        Assert.assertArrayEquals(new int[] { 2, 4, 3, 1 }, result);
    }

    // Negative test case
    @Test
    public void testNegativeMultiply() {
        int result[] = polynomial1.multiplyTwoPoly(polynomial2);
        Assert.assertNotEquals(new int[] { 3, 3, 3 }, result);
    }

}
