package counselling;

//Interface for Queue

public interface Queue<T> {

    /**
     * Function to add element in queue
     * 
     * @param element
     */
    boolean addElement(T element);

    /**
     * Function to remove element
     * 
     * @param element
     */
    T removeElement();

    boolean isEmpty();

}