package assignment4;

import static org.junit.Assert.*;

import org.junit.Test;

//Test case to check item displayed from the database
public class TestDisplayCategory {

    @Test
    public void testDisplayCategory1() {
        DisplayParentOperation display = new DisplayParentOperation();
        assertEquals(1, display.displayCategory().get(0).getId());
        assertEquals("ELECTRONICS", display.displayCategory().get(0).getName());
        assertEquals(1, display.displayCategory().get(0).getCount());
    }

    @Test
    public void testDisplayCategory2() {
        DisplayParentOperation display = new DisplayParentOperation();
        assertNotEquals(0, display.displayCategory().get(0).getId());
        assertNotEquals("CTRS", display.displayCategory().get(0).getName());
        assertNotEquals(0, display.displayCategory().get(0).getCount());
    }
}
