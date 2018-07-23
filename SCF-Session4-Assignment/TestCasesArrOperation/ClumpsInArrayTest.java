package TestCasesArrOperation;

import ArrOperation.*;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Test class for ClumpsInArray
 *
 */
public class ClumpsInArrayTest {

    ArrOperation operation = new ArrOperation();
    int Case1Array[] = { 1, 2, 2, 3, 4, 4 };
    int Case2Array[] = { 1, 1, 2, 1, 1 };
    int Case3Array[] = { 1, 1, 1, 1, 1 };
    int Case4Array[] = { 1, 1, 1, 1, 4, 5, 2, 2, 2, 2 };

    /**
     * Test case to show AssertionError if AssertionError found : Test is Passed
     * If Not found AssertionError : Test is Failed and respective error is shown.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionError() {
        operation.clumpInArray(Case1Array);
        operation.clumpInArray(Case2Array);
        operation.clumpInArray(Case3Array);
        operation.clumpInArray(Case4Array);
    }

    @Test
    public void test1() {
        Assert.assertEquals(2, operation.clumpInArray(Case1Array));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, operation.clumpInArray(Case2Array));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, operation.clumpInArray(Case3Array));
    }

    @Test
    public void test4() {
        Assert.assertEquals(2, operation.clumpInArray(Case4Array));
    }

}
