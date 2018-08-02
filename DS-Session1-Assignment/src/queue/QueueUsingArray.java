package queue;

public class QueueUsingArray implements Queue {

    public static int queue[];

    public static int rear;
    public static int front;

    /**
     * Function to add element in queue
     */
    public void addElement(int element) {

        if (!this.isFull()) {

            queue[rear] = element;
            rear++;

        } else {
            throw new AssertionError("!! Queue Full !!");
        }

    }

    /**
     * Function to remove element from queue
     */
    public void removeElement() {

        if (!this.isEmpty()) {
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
            rear--;
        } else {
            throw new AssertionError("!! Queue Empty !!");
        }

    }

    /**
     * Function to check if queue is empty
     */
    public boolean isEmpty() {
        if (rear == 0) {
            return true;
        }
        return false;
    }

    /**
     * Function to check queue is full
     */
    public boolean isFull() {
        if (rear == queue.length) {
            return true;
        }
        return false;
    }

}
