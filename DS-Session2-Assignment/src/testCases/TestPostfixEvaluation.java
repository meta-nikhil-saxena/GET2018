package testCases;
import static org.junit.Assert.*;
import operations.PostfixEvaluation;

import org.junit.Test;

public class TestPostfixEvaluation {

    // Positive Test
    @Test
    public void testForPostfix() {
        PostfixEvaluation postfix = new PostfixEvaluation("22 3 1 * + 9 +");
        assertEquals(34, postfix.postfixOperation());
    }

    // Positive Test
    @Test
    public void testForPostfix2() {
        PostfixEvaluation postfix = new PostfixEvaluation("2 3 1 * + 9 +");
        assertEquals(14, postfix.postfixOperation());
    }

    // Positive Test
    @Test
    public void testForPostfix3() {
        PostfixEvaluation postfix = new PostfixEvaluation("1 3 1 * + 9 +");
        assertEquals(13, postfix.postfixOperation());
    }

    // Positive Test
    @Test
    public void testForPostfix4() {
        PostfixEvaluation postfix = new PostfixEvaluation("22 3 100 * + 9 +");
        assertEquals(331, postfix.postfixOperation());
    }

    // Negative Test
    @Test
    public void testNegative() {
        PostfixEvaluation postfix = new PostfixEvaluation("22 3 1 * + 9 +");
        assertNotEquals(331, postfix.postfixOperation());
    }

}
