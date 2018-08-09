

import static org.junit.Assert.*;

import org.junit.Test;

import queue.QueueByLinkedList;

/**
 * 
 * Test class to test queue class implemented through linkedlist
 *
 */

public class TestQueueByLinkedList {

    QueueByLinkedList queue = new QueueByLinkedList();

    @Test
    public void testForLinkedListAdd() {
        assertEquals(true, queue.addElement(4));
        assertEquals(true, queue.addElement(5));
    }

    @Test
    public void testForLinkedListRemove() {
        queue.addElement(4);
        queue.addElement(5);

        assertEquals(true, queue.removeElement());
    }

    @Test
    public void testForLinkedListEmpty() {
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testForLinkedListShow() {
        queue.addElement(4);
        queue.addElement(5);

        assertEquals(true, queue.show());
    }

}
