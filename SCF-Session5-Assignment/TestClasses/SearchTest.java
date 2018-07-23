package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import AssignmentClasses.Search;

public class SearchTest {
    Search operation = new Search();

    @Test
    public void linearSearchTest1() {
        int caseArray[] = { 2, 3, 4, 7, 9, 2 };
        assertEquals(3, operation.arrayLinearSearch(caseArray, 7));
    }

    @Test
    public void linearSearchTest2() {
        int caseArray[] = { 2, 3, 4, 7, 9, 2 };
        assertEquals(1, operation.arrayLinearSearch(caseArray, 3));
    }

    @Test
    public void linearSearchTest3() {
        int caseArray[] = { 2, 3, 4, 7, 9, 2 };
        assertEquals(-1, operation.arrayLinearSearch(caseArray, 8));
    }

    @Test
    public void linearSearchTest4() {
        int caseArray[] = { 2, 3, 4, 7, 9, 2 };
        assertEquals(0, operation.arrayLinearSearch(caseArray, 2));
    }

    // Test cases for binary Search

    @Test
    public void binaSearchTest1() {
        int caseArray[] = { 1, 2, 3, 4, 5, 6, 7 };
        assertEquals(5, operation.binarySearch(caseArray, 6));
    }

    @Test
    public void binearSearchTest2() {
        int caseArray[] = { 7, 8, 9, 10, 66, 88 };
        assertEquals(1, operation.binarySearch(caseArray, 8));
    }

    @Test
    public void binearSearchTest3() {
        int caseArray[] = { 1, 9, 11, 12 };
        assertEquals(-1, operation.binarySearch(caseArray, 8));
    }

    @Test
    public void binearSearchTest4() {
        int caseArray[] = { 6, 8, 18, 20 };
        assertEquals(0, operation.binarySearch(caseArray, 6));
    }

}
