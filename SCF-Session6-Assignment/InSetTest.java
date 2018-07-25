package AssignmentClasses;

//Class to Test InSet class
import org.junit.Assert;
import org.junit.Test;

public class InSetTest {

    InSet set1 = new InSet(new int[] { 1, 2, 3, 4, 5 });
    InSet set2 = new InSet(new int[] { 1, 2, 3, 6, 7, 9, 4, 5 });

    /**
     * Test cases for size() function
     */
    // Positive test cases for size()
    @Test
    public void testSize1() {
        Assert.assertEquals(5, set1.size());
    }

    @Test
    public void testSize2() {
        Assert.assertEquals(8, set2.size());
    }

    // Negative Test cases for size()
    @Test
    public void NegativeTestSize1() {
        Assert.assertNotEquals(1, set1.size());
    }

    @Test
    public void NegativeTestSize2() {
        Assert.assertNotEquals(10, set2.size());
    }

    /**
     * Test Cases for isMember(int) function
     */
    // Positive Test cases for isMember(int)
    @Test
    public void testisMenber1() {
        Assert.assertEquals(true, set1.isMember(4));
    }

    @Test
    public void testisMenber2() {
        Assert.assertEquals(true, set2.isMember(5));
    }

    // Negative test cases for isMember(int)
    @Test
    public void NegativeTestisMember1() {
        Assert.assertNotEquals(true, set1.isMember(10));
    }

    @Test
    public void NegativeTestisMember2() {
        Assert.assertNotEquals(false, set2.isMember(4));
    }

    /**
     * Test cases for isSubset(InSet) function
     */
    // Positive test cases
    @Test
    public void testIsSubset1() {
        Assert.assertEquals(false, set1.isSubset(set2));
    }

    @Test
    public void testIsSubset2() {
        Assert.assertEquals(true, set2.isSubset(set1));
    }

    // Negative test cases
    @Test
    public void testNegativeIsSubset1() {
        Assert.assertNotEquals(true, set1.isSubset(set2));
    }

    @Test
    public void testNegativeIsSubset2() {
        Assert.assertNotEquals(false, set2.isSubset(set1));
    }

    /**
     * Test cases for compliment() function
     */
    // Positive test cases
    @Test
    public void testCompliment1() {
        int actual[] = set1.getComplement();
        Assert.assertArrayEquals(new int[] { 100, 200, 456, 234, 890, 990, 100,
                210, 500, 700, 900 }, actual);
    }

    @Test
    public void testCompliment2() {
        int actual[] = set2.getComplement();
        Assert.assertArrayEquals(new int[] { 100, 200, 456, 234, 890, 990, 100,
                210, 500, 700, 900 }, actual);
    }

    // Negative test cases
    @Test
    public void testNegativeCompliment1() {
        int actual[] = set1.getComplement();
        Assert.assertNotEquals(new int[] { 200, 456, 234, 890, 990, 100, 210,
                500, 700, 900 }, actual);
    }

    @Test
    public void testNegativeCompliment2() {
        int actual[] = set2.getComplement();
        Assert.assertNotEquals(new int[] { 234, 890, 990, 100, 210, 500, 700,
                900 }, actual);
    }

    /**
     * Test cases for unionOfSets(this.InSet,InSet) function
     */
    // Positive test cases
    @Test
    public void testUnion1() {
        int actual[] = set1.unionOfSets(set2);
        Assert.assertArrayEquals(new int[] { 1, 2, 3, 4, 5 }, actual);
    }

    // Negative test cases
    @Test
    public void testNegativeUnion1() {
        int actual[] = set1.unionOfSets(set2);
        Assert.assertNotEquals(new int[] { 1, 2, 3 }, actual);
    }

}
