package stack;

//Array implementation of stack

import java.util.Scanner;

public class StackByArray implements Stack {

    static Scanner sc = new Scanner(System.in);
    public static int sizeOfArray, top = -1;
    public static int stackStore[];

    /**
     * Operation : push(element)
     * 
     * @param element
     *            is the value to be pushed in the stack
     */
    public boolean push(int element) {

        // Checking Overflow
        if (top == (stackStore.length) - 1) {
            throw new AssertionError("Stack Overflow");
        } else {
            top++;
            stackStore[top] = element;
            return true;
        }

    }

    /**
     * Operation : pop()
     */
    public boolean pop() {

        // Checking Underflow
        if (top == -1) {
            throw new AssertionError("Stack Underflow");
        } else {
            top--;
            return true;
        }
    }

    /**
     * show() : Display stack elements check if stack isEmpty()
     */
    public boolean show() {
        int show = top;
        if (show == -1) {
            throw new AssertionError("Stack is Empty");
        } else {
            while (show >= 0) {
                System.out.println("Stack Element at Position " + show
                        + " --> " + stackStore[show]);
                show--;
            }
            return true;
        }
    }

    public static void main(String args[]) {

        int choice;

        Stack stack = new StackByArray();

        System.out.println("Enter the size of Array : ");
        sizeOfArray = sc.nextInt();
        stackStore = new int[sizeOfArray];

        do {
            System.out.println("1. Push(element)");
            System.out.println("2. Pop()");
            System.out.println("3. show() or check stack isEmpty()");
            System.out.println("4. EXIT");

            System.out.println("Enter your choice:");
            choice = sc.nextInt();

            switch (choice) {
            case 1: {
                System.out.println("Enter the element to be pushed:");
                stack.push(sc.nextInt());
                break;
            }
            case 2: {
                stack.pop();
                break;
            }
            case 3: {
                stack.show();
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
