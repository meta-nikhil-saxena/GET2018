package testCases;

import static org.junit.Assert.*;
import operations.InfixToPostfix;

import org.junit.Test;

public class TestInfixToPostfix {

    //Positive Test case 
    @Test
    public void testinfixToPostfix1() {
        InfixToPostfix expression = new InfixToPostfix("( A + B )");
        String result = expression.convertInfixToPostfix();
        assertEquals("AB+", result);
    }
    
    @Test
    public void testinfixToPostfix2() {
        InfixToPostfix expression = new InfixToPostfix("A + ( B * C - ( D / E - F ) * G ) * H");
        String result = expression.convertInfixToPostfix();
        assertEquals("ABC*DE/F-G*-H*+", result);
    }
    
    //Negative TestCase
    @Test
    public void testNegativeinfixToPostfix1() {
        InfixToPostfix expression = new InfixToPostfix("( A + B )");
        String result = expression.convertInfixToPostfix();
        assertNotEquals("AB", result);
    }
    
    @Test
    public void testNegativeinfixToPostfix2() {
        InfixToPostfix expression = new InfixToPostfix("A + ( B * C - ( D / E - F ) * G ) * H");
        String result = expression.convertInfixToPostfix();
        assertNotEquals("ABC*DE/F-G*-H", result);
    }
}
