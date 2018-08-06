package operations;

import stack.Stack;
import stack.StackByLinkedList;

public class PostfixEvaluation {

    private String postfixExpression;
    Stack<Integer> stack = new StackByLinkedList<Integer>();
    ValidationInExpression validate = new ValidationInExpression();

    // Constructor to initialize postfix String
    public PostfixEvaluation(String postfixExpression) {
        this.postfixExpression = postfixExpression;
    }

    /**
     * Function to evaluate postfix expression
     * 
     * @return evaluated value
     */
    public int postfixOperation() {

        int i = 0;

        if (validate.checkValidity(this.postfixExpression)) {
            throw new AssertionError("Invalid Postfix equation");
        }

        String tokenString[] = postfixExpression.split(" ");

        while (i < tokenString.length) {

            if (validate.checkForNumeric(tokenString[i])) {

                stack.push(Integer.parseInt(tokenString[i]));

            } else {

                switch (tokenString[i]) {

                case "+": {
                    int element1 = stack.peek();
                    stack.pop();
                    int element2 = stack.peek();
                    stack.pop();
                    stack.push(element2 + element1);
                    break;
                }
                case "-": {
                    int element1 = stack.peek();
                    stack.pop();
                    int element2 = stack.peek();
                    stack.pop();
                    stack.push(element2 - element1);
                    break;
                }
                case "*": {
                    int element1 = stack.peek();
                    stack.pop();
                    int element2 = stack.peek();
                    stack.pop();
                    stack.push(element2 * element1);
                    break;
                }
                case "/": {
                    int element1 = stack.peek();
                    stack.pop();
                    int element2 = stack.peek();
                    stack.pop();
                    stack.push(element2 / element1);
                    break;

                }
                }
            }
            i++;
        }
        return stack.peek();
    }

    public static void main(String args[]) {
        PostfixEvaluation postfix = new PostfixEvaluation(
                "10 12 * 9 13 * + 11 -");
        System.out.println(postfix.postfixOperation());
    }
}
