package stack;

/**
 * 
 * Node class to define a node for linked List implementation
 *
 */
public class Node<T> {

    public T data;
    public Node<T> next;

    public Node(T data) {

        this.data = data;

        this.next = null;
    }
}