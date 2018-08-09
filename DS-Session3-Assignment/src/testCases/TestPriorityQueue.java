package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import priority.PriorityQueue;
import priority.QueueItem;
import priority.Queue;

public class TestPriorityQueue {

    /**
     * Helper function to check wether the element exist in the queue which is
     * entered or not
     * 
     * @param element
     * @return true or false
     */
    boolean checkElementinQueue(int element, QueueItem queue[]) {

        for (int i = 0; i < queue.length; i++) {
            if (element == queue[i].getItem()) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to test if element is added in the queue
     */
    @Test
    public void testForAddElement() {
        QueueItem queueArray[] = new QueueItem[6];
        Queue queue = new PriorityQueue(queueArray);

        queue.addElement(4, 10);
        queue.addElement(5, 9);
        queue.addElement(6, 8);
        queue.addElement(7, 7);

        QueueItem queueArrayRecieved[] = queue.getQueue();

        assertEquals(true, this.checkElementinQueue(4, queueArrayRecieved));
        assertEquals(true, this.checkElementinQueue(5, queueArrayRecieved));
        assertEquals(true, this.checkElementinQueue(6, queueArrayRecieved));
        assertEquals(true, this.checkElementinQueue(7, queueArrayRecieved));
    }

    /**
     * Function to check the function to get highest priority element
     */
    @Test
    public void testgetHighestPriorityElement() {

        QueueItem queueArray[] = new QueueItem[6];
        Queue queue = new PriorityQueue(queueArray);

        queue.addElement(4, 10);
        queue.addElement(5, 9);
        queue.addElement(6, 8);
        queue.addElement(7, 7);

        assertEquals(4, queue.getHighestPriorityElement());
    }

    /**
     * Function to check the function for removing highest priority element
     */
    @Test
    public void testRemovetHighestPriorityElement() {

        QueueItem queueArray[] = new QueueItem[6];
        Queue queue = new PriorityQueue(queueArray);

        queue.addElement(4, 10);
        queue.addElement(5, 9);
        queue.addElement(6, 8);
        queue.addElement(7, 7);

        assertEquals(true, queue.deleteHighestPriorityElement());
    }

}
