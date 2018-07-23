package TestCasesArrOperation;

import ArrOperation.*;
import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Test class for SplitArray
 *
 */
public class SplitArrayTest {

    ArrOperation operation = new ArrOperation();
    int Case1Array[] = { 1, 1, 1, 2, 1 };
    int Case2Array[] = { 2, 1, 1, 2, 1 };
    int Case3Array[] = { 1, 1 };
    int Case4Array[] = { 1, 2, 5, 2, 10 };

    /**
     * Test case to show AssertionError if AssertionError found : Test is Passed
     * If Not found AssertionError : Test is Failed and respective error is shown.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionError() {
        operation.splitArray(Case1Array);
        operation.splitArray(Case2Array);
        operation.splitArray(Case3Array);
        operation.splitArray(Case4Array);
    }

    @Test
    public void test1() {
        Assert.assertEquals(3, operation.splitArray(Case1Array));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-1, operation.splitArray(Case2Array));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, operation.splitArray(Case3Array));
    }

    @Test
    public void test4() {
        Assert.assertEquals(4, operation.splitArray(Case4Array));
    }

}
