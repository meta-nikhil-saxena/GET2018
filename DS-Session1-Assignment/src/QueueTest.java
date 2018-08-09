

import static org.junit.Assert.*;

import org.junit.Test;

import queue.Queue;
import queue.QueueUsingArray;

public class QueueTest {

    /**
     * Helper function to check wether the element exist in the queue which is
     * entered or not
     * 
     * @param element
     * @return true or false
     */
    boolean checkElementinQueue(int element, int queue[]) {

        for (int i = 0; i < queue.length; i++) {
            if (element == queue[i]) {
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

        Queue queue = new QueueUsingArray();
        QueueUsingArray.queue = new int[4];
        int element = 4;
        queue.addElement(element);

        int queueArray[] = QueueUsingArray.queue;

        assertEquals(true, this.checkElementinQueue(element, queueArray));
    }

    @Test
    public void testForEmpty() {

        Queue queue = new QueueUsingArray();
        QueueUsingArray.queue = new int[] {};
        QueueUsingArray.rear = 0;
        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testForFull() {

        Queue queue = new QueueUsingArray();

        QueueUsingArray.queue = new int[] { 1, 2, 3, 4, 5, 6 };
        QueueUsingArray.rear = QueueUsingArray.queue.length;

        assertEquals(true, queue.isFull());
    }

    @Test
    public void testForRemoveElement() {

        Queue queue = new QueueUsingArray();
        QueueUsingArray.queue = new int[] { 1, 2, 3 };
        QueueUsingArray.rear = 3;

        queue.removeElement();

        boolean actual = this.checkElementinQueue(1, QueueUsingArray.queue);

        assertEquals(false, actual);
    }

}
