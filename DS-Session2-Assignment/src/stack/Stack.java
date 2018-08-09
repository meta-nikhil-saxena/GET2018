package stack;

public interface Stack<T> {
	
	boolean push(T element);

    boolean pop();

	boolean show();

	T peek();
	
	boolean isEmpty();
}