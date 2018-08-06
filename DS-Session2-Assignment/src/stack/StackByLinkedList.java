package stack;

import java.util.Scanner;

public class StackByLinkedList<T> implements Stack<T> {

    static Scanner sc = new Scanner(System.in);
    public Node<T> top = null;

    /**
     * Operation push(element)
     * 
     * @param element
     *            to be pushed into stack
     */
    public boolean push(T element) {

        try {

            Node<T> newNode = new Node<T>(element);

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

        if (!this.isEmpty()) {
            Node<T> temp = top;
            top = top.next;
            temp.next = null;
            return true;

        }

        return false;

        /**
         * Function to return the element from top of stack
         */
    }

    public T peek() {

        if (!this.isEmpty()) {
            T element = top.data;
            return element;
        }
        return null;
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

            Node<T> traverse = top;

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

    /**
     * Function to check wether stack is empty or not
     */
    public boolean isEmpty() {
        if (top == null) {
            return true;
        }
        return false;
    }
}