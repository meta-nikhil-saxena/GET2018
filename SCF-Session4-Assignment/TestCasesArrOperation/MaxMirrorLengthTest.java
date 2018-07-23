package TestCasesArrOperation;

import ArrOperation.*;
import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 * Test class for MaxMirrorLength
 *
 */
public class MaxMirrorLengthTest {
    ArrOperation operation = new ArrOperation();
    int Case1Array[] = { 1, 2, 3, 4, 5, 3, 2, 1 };
    int Case2Array[] = { 1, 2, 1 };
    int Case3Array[] = { 1, 2, 3, 4, 3, 2, 1 };
    int Case4Array[] = { 1, 4, 5, 6, 7, 4, 1 };

    /**
     * Test case to show AssertionError if AssertionError found : Test is Passed
     * If Not found AssertionError : Test is Failed and respective error is shown.
     */
    @Test(expected = AssertionError.class)
    public void testAssertionError() {
        operation.maxMirrorLengthInArray(Case1Array);
        operation.maxMirrorLengthInArray(Case2Array);
        operation.maxMirrorLengthInArray(Case3Array);
        operation.maxMirrorLengthInArray(Case4Array);
    }

    @Test
    public void test1() {
        assertEquals(3, operation.maxMirrorLengthInArray(Case1Array));
    }

    @Test
    public void test2() {
        assertEquals(3, operation.maxMirrorLengthInArray(Case2Array));
    }

    @Test
    public void test3() {
        assertEquals(7, operation.maxMirrorLengthInArray(Case3Array));
    }

    @Test
    public void test4() {
        assertEquals(2, operation.maxMirrorLengthInArray(Case4Array));
    }

}
