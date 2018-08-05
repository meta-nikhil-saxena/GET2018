package queue;

//Interface for Queue

public interface Queue {

    /**
     * Function to add element in queue
     * 
     * @param element
     */
    boolean addElement(int element);

    /**
     * Function to remove element
     * 
     * @param element
     */
    boolean removeElement();

    boolean isEmpty();

    boolean isFull();

}
