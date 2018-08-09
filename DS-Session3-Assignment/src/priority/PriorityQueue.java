package priority;

import java.util.Scanner;

public class PriorityQueue implements Queue {

    private QueueItem queue[];
    static Scanner sc = new Scanner(System.in);

    private int rear;

    public PriorityQueue(QueueItem[] queue) {
        this.queue = queue;
        rear = 0;
    }

    public QueueItem[] getQueue() {
        return queue;
    }

    /**
     * Function to add element in queue
     */

    @Override
    public boolean addElement(int element, int priority) {

        if (this.isFull()) {
            throw new AssertionError("Queue is full");
        }

        QueueItem queueItem = new QueueItem();
        queueItem.setItem(element);
        queueItem.setPriority(priority);

        queue[rear] = queueItem;
        rear++;

        return true;
    }

    /**
     * Function to remove element from queue according to highest priority
     */

    @Override
    public boolean deleteHighestPriorityElement() {
        if (isEmpty()) {
            throw new AssertionError("Queue is Empty");
        }

        int highestPriorityElement = this.getHighestPriorityElement();
        int indexToDelete = 0;

        for (int i = 0; i < rear; i++) {
            if (this.queue[i].getItem() == (highestPriorityElement)) {
                indexToDelete = i;
            }

        }

        for (int i = indexToDelete; i < rear - 1; i++) {
            queue[i] = queue[i + 1];
        }
        rear--;

        return true;
    }

    /**
     * Function to get the highest priority element
     */
    @Override
    public int getHighestPriorityElement() {

        if (isEmpty()) {
            throw new AssertionError("Queue is Empty");
        }

        int highestPriority = 0;
        int highestPriorityElement = 0;
        // Loop for calculating highest priority
        for (int i = 0; i < rear; i++) {

            if (highestPriority < this.queue[i].getPriority()) {

                highestPriority = this.queue[i].getPriority();

                highestPriorityElement = this.queue[i].getItem();

            }
        }
        return highestPriorityElement;
    }

    /**
     * Function to show items in queue
     */
    public void show() {
        for (int i = 0; i < rear; i++) {
            System.out.println(queue[i].getItem());
        }
    }

    /**
     * Function to check if queue is empty
     */
    @Override
    public boolean isEmpty() {
        boolean result = false;
        if (rear == 0) {
            result = true;
        }
        return result;
    }

    /**
     * Function to check queue is full
     */
    @Override
    public boolean isFull() {
        boolean result = false;
        if (rear == queue.length) {
            result = true;
        }
        return result;
    }

    public static void main(String args[]) {

        QueueItem[] queueArray = new QueueItem[6];

        Queue queue = new PriorityQueue(queueArray);

        int choice;

        do {
            System.out.println("1. Add to Queue(element)");
            System.out.println("2. delete highest priority");
            System.out.println("3. Get highest priority");
            System.out.println("4. show");
            System.out.println("5. EXIT");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                System.out.println("Enter the element : ");
                int element = sc.nextInt();
                int priority = sc.nextInt();

                System.out.println(queue.addElement(element, priority));
                break;
            }
            case 2: {
                System.out.println(queue.deleteHighestPriorityElement());
                break;
            }
            case 3: {
                System.out.println(queue.getHighestPriorityElement());
                break;
            }

            case 4: {
                queue.show();
                break;
            }
            case 5: {
                System.exit(0);
            }
            default:
                System.out.println("Enter the valid choice:");
            }
        } while (true);

    }

}
