package operations;

import stack.Stack;
import stack.StackByLinkedList;

public class InfixToPostfix {

    Stack<String> stackOfOperators = new StackByLinkedList<String>();
    ValidationInExpression validate = new ValidationInExpression();

    String infixExpression;

    // Constructor to initialize the expression
    public InfixToPostfix(String infixExpression) {

        this.infixExpression = infixExpression;

    }

    /**
     * Helper function to check the precedence of the operator
     * 
     * @param operator
     * @return precedence in form of int
     */
    public int checkPrecedence(String operator) {

        switch (operator) {
        case "(":
        case ")":
        case "[":
        case "]":
            return 10;

        case "*":
        case "/":
        case "%":
            return 2;

        case "+":
        case "-":
            return 3;

        case "<":
        case ">":
        case "<=":
        case ">=":
            return 4;

        case "==":
        case "!=":
            return 5;

        case "&&":
            return 6;
        case "||":
            return 7;
        }

        return 0;
    }

    /**
     * Function to convert infix to postfix expression
     * 
     * @return
     */
    public String convertInfixToPostfix() {
        String resultingPostfixExpression = "";
        if (validate.checkValidity(this.infixExpression)) {
            throw new AssertionError("Invalid Postfix equation");
        }

        String tokens[] = this.infixExpression.split(" ");
        int index = 0;

        while (index < tokens.length) {

            // Check if it is alphabet
            if (validate.checkForAlbhabet(tokens[index])) {

                resultingPostfixExpression += tokens[index];

                // check if it is numeric
            } else if (validate.checkForNumeric(tokens[index])) {

                resultingPostfixExpression += tokens[index];

                // if ( is found push into stack
            } else if ("(".equals(tokens[index])) {

                stackOfOperators.push(tokens[index]);

                // if ) found pop till ( is found
            } else if (")".equals(tokens[index])) {

                while (!("(").equals(stackOfOperators.peek())
                        && !stackOfOperators.isEmpty()) {

                    resultingPostfixExpression += stackOfOperators.peek();

                    stackOfOperators.pop();
                }
                if (!stackOfOperators.isEmpty()
                        && !("(").equals(stackOfOperators.peek())) {
                    return "invalid";
                }

                stackOfOperators.pop();

            } else {

                if (!stackOfOperators.isEmpty()
                        && this.checkPrecedence(tokens[index]) >= this
                                .checkPrecedence(stackOfOperators.peek())) {

                    resultingPostfixExpression += stackOfOperators.peek();
                    stackOfOperators.pop();

                }
                stackOfOperators.push(tokens[index]);

            }

            index++;
        }
        // pop rest of the elements from stack and append in string
        while (!stackOfOperators.isEmpty()) {

            resultingPostfixExpression += stackOfOperators.peek();
            stackOfOperators.pop();
        }
        return resultingPostfixExpression;
    }

    public static void main(String args[]) {
        InfixToPostfix expression = new InfixToPostfix(
                "A + ( B * C - ( D / E - F ) * G ) * H");

        System.out.println(expression.convertInfixToPostfix());

    }
}
