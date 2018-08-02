

import static org.junit.Assert.*;

import org.junit.Test;

import stack.Stack;
import stack.StackByArray;

public class StackTest {

    /**
     * Helper function to check wether the element exist in the stack which is
     * entered or not
     * 
     * @param element
     * @return true or false
     */
    boolean checkElementinQueue(int element, int stack[], int length) {

        for (int i = 0; i < length; i++) {
            if (element == stack[i]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to test if element is added in the stack
     */
    @Test
    public void testForAddElement() {

        Stack stack = new StackByArray();
        StackByArray.stackStore = new int[4];
        int element = 4;

        stack.push(element);

        int stackArray[] = StackByArray.stackStore;

        assertEquals(true, this.checkElementinQueue(element, stackArray,
                stackArray.length));
    }
    
    
    /**
     * Function to test if element is removed in the stack
     */

    @Test
    public void testForRemoveElement() {

        Stack stack = new StackByArray();
        StackByArray.stackStore = new int[] { 1, 2, 3 };
        StackByArray.top = 3;

        stack.pop();

        boolean actual = this.checkElementinQueue(3, StackByArray.stackStore,
                StackByArray.stackStore.length - 1);

        assertEquals(false, actual);
    }

}
