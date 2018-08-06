package nestedList;

/**
 * 
 * Interface for representing a nested list
 *
 */
public interface List {
    int getSum();

    int getLargest();

    int Search(int value);

    // Function to extract a value according to given pattern
    int getValue(String pattern);
}
