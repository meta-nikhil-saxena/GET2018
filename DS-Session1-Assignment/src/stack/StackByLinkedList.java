package stack;

import queue.Node;

import java.util.Scanner;

public class StackByLinkedList implements Stack {

    static Scanner sc = new Scanner(System.in);
    Node top = null;

    /**
     * Operation push(element)
     *
     * @param element
     *            to be pushed into stack
     */
    public boolean push(int element) {

        try {

            Node newNode = new Node(element);

            newNode.next = top;
            top = newNode;

            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Operation pop()
     * 
     * @return true or false
     */
    public boolean pop() {

        try {

            if (top == null) {
                System.out.println("Stack UnderFlow");
            } else {

                top = top.next;
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }

    /**
     * Operation to show elements in Stack Operation to check wether stack is
     * Empty
     */
    public boolean show() {
        try {
            if (top == null) {
                System.out.println("Stack is Empty");
            }

            Node traverse = top;

            while (traverse != null) {
                System.out.println("Stack Element --> " + traverse.data);
                traverse = traverse.next;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[]) {

        Stack stack = new StackByLinkedList();

        int choice;

        do {
            System.out.println("1. Push(element)");
            System.out.println("2. Pop()");
            System.out.println("3. show() or check stack isEmpty()");
            System.out.println("4. EXIT");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                System.out.println("Enter the element to be pushed : ");
                System.out.println(stack.push(sc.nextInt()));
                break;
            }
            case 2: {
                System.out.println(stack.pop());
                break;
            }
            case 3: {
                System.out.println(stack.show());
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
