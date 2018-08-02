package queue;

import java.util.Scanner;

public class QueueByLinkedList {
    
    static Scanner sc = new Scanner(System.in);
    
    Node front = null;
    Node rear = null;

    /**
     * Function to add element in the queue
     * 
     * @param element
     * @return true or false
     */
    public boolean addElement(int element) {

        if (isEmpty()) {
            Node newNode = new Node(element);
            front = newNode;
            rear = newNode;

        } else {
            Node newNode = new Node(element);
            rear.next = newNode;
            rear = newNode;

        }
        return true;
    }

    /**
     * Funtion to remove element from queue
     * 
     * @return true or false
     */
    public boolean removeElement() {

        if (isEmpty()) {
            return false;
        }

        Node temporary = front;
        front = temporary.next;
        temporary.next = null;

        return true;
    }

    /**
     * Function to check queue is empty
     * 
     * @return true or false
     */
    public boolean isEmpty() {

        if (front == null) {
            return true;
        }
        return false;
    }

    /**
     * Function to show element from queue
     * 
     * @return
     */
    public boolean show() {

        if (isEmpty()) {
            return false;
        }

        Node traverse = front;

        while (traverse != null) {

            System.out.println("element : " + traverse.data);
            traverse = traverse.next;

        }
        return true;
    }

    public static void main(String args[]) {

        QueueByLinkedList queue = new QueueByLinkedList();

        int choice;

        do {
            System.out.println("1. Add to Queue(element)");
            System.out.println("2. Remove from queue");
            System.out.println("3. show");
            System.out.println("4. EXIT");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                System.out.println("Enter the element : ");
                queue.addElement(sc.nextInt());
                break;
            }
            case 2: {
                queue.removeElement();
                break;
            }
            case 3: {
                queue.show();
                break;
            }
            case 4: {
                System.exit(0);
            }
            default:
                System.out.println("Enter the valid choice:");
            }
        } while (true);

    }

}
