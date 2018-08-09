package counselling;

import java.util.Scanner;

public class QueueByLinkedList<T> implements Queue<T> {

	static Scanner sc = new Scanner(System.in);

	Node<T> front = null;
	Node<T> rear = null;

	/**
	 * Function to add element in the queue
	 * 
	 * @param element
	 * @return true or false
	 */
	public boolean addElement(T element) {

		if (isEmpty()) {
			Node<T> newNode = new Node<T>(element);
			front = newNode;
			rear = newNode;

		} else {
			Node<T> newNode = new Node<T>(element);
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
	public T removeElement() {

		if (isEmpty()) {
			throw new AssertionError("!! Empty !!");
		}
		
		T element;
		
		Node<T> temporary = front;
		element = temporary.data;
		front = temporary.next;
		temporary.next = null;
		
		return element;
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

		Node<T> traverse = front;

		while (traverse != null) {

			System.out.println("element : " + traverse.data);
			traverse = traverse.next;

		}
		return true;
	}

	public static void main(String args[]) {

		QueueByLinkedList<Integer> queue = new QueueByLinkedList<Integer>();

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
				System.out.println(queue.removeElement());
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