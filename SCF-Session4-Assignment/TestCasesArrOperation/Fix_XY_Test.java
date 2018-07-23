package TestCasesArrOperation;

import ArrOperation.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Test class for Fix_XY
 *
 */
public class Fix_XY_Test {

    ArrOperation operation = new ArrOperation();
    int Case1Array[] = { 5, 4, 9, 4, 9, 5 };
    int Case2Array[] = { 1, 4, 1, 5 };
    int Case3Array[] = { 1, 4, 1, 5, 5, 4, 1 };
    int Case4Array[] = { 1, 2, 5, 4, 6 };

    /**
     * Test case to show AssertionError if AssertionError found : Test is Passed
     * If Not found AssertionError : Test is Failed and respective error is shown.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionError() {
        operation.fix_XY(Case1Array, 4, 5);
        operation.fix_XY(Case2Array, 4, 5);
        operation.fix_XY(Case3Array, 4, 5);
        operation.fix_XY(Case4Array, 4, 5);

    }

    @Test
    public void test1() {
        int case1Expected[] = { 9, 4, 5, 4, 5, 9 };
        Assert.assertArrayEquals(case1Expected,
                operation.fix_XY(Case1Array, 4, 5));
    }

    @Test
    public void test2() {
        int case2Expected[] = { 1, 4, 5, 1 };
        Assert.assertArrayEquals(case2Expected,
                operation.fix_XY(Case2Array, 4, 5));
    }

    @Test
    public void test3() {
        int case3Expected[] = { 1, 4, 5, 1, 1, 4, 5 };
        Assert.assertArrayEquals(case3Expected,
                operation.fix_XY(Case3Array, 4, 5));
    }

    @Test
    public void test4() {
        int case4Expected[] = { 1, 2, 6, 4, 5 };
        Assert.assertArrayEquals(case4Expected,
                operation.fix_XY(Case4Array, 4, 5));
    }
}
