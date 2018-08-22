package assignment3;

import static org.junit.Assert.*;

import org.junit.Test;

//Test class for checking delete product from database
public class TestUpdateProduct {

    @Test
    public void testdelete1() {
        UpdateOperation update = new UpdateOperation();
        assertEquals(0, update.deleteproduct());
    }

    @Test
    public void testdelete2() {
        UpdateOperation update = new UpdateOperation();
        assertNotEquals(1, update.deleteproduct());
    }

}
