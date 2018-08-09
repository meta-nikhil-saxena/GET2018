

import static org.junit.Assert.*;

import org.junit.Test;

import stack.Stack;
import stack.StackByLinkedList;

/**
 * 
 * Test class to test stack class implemented through linkedlist
 *
 */

public class TestStackByLinkedList {

    Stack stack = new StackByLinkedList();

    @Test
    public void testForLinkedListAdd() {
        assertEquals(true, stack.push(4));
        assertEquals(true, stack.push(5));
    }

    @Test
    public void testForLinkedListRemove() {
        stack.push(4);
        stack.push(5);

        assertEquals(true, stack.pop());
    }

    @Test
    public void testForLinkedListShow() {
        stack.push(4);
        stack.push(5);

        assertEquals(true, stack.show());
    }

}
