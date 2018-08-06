package operations;

//Class for validationg the expression
public class ValidationInExpression {

    /**
     * Helper function to count operator in String
     * 
     * @param character
     * @return
     */
    public boolean checkValidity(String expression) {

        int i = 0, countOperator = 0, countDigits = 0;
        String[] tokens = expression.split(" ");
        while (i < tokens.length) {

            if ("+".equals(tokens[i]) || "-".equals(tokens[i])
                    || "*".equals(tokens[i]) || "/".equals(tokens[i])) {

                countOperator++;

            } else {

                countDigits++;

            }

            i++;
        }
        if (countOperator >= countDigits) {
            return true;
        }
        return false;
    }

    /**
     * Helper function to check wether it is numeric or not
     * 
     * @param character
     * @return true or false
     */
    public boolean checkForNumeric(String token) {

        int i = 0, countDigits = 0;

        while (i < token.length()) {

            if (Character.isDigit(token.charAt(i))) {
                countDigits++;
            }
            i++;
        }
        if (countDigits == token.length()) {
            return true;
        }
        return false;
    }

    public boolean checkForAlbhabet(String token) {
        int i = 0, countDigits = 0;

        while (i < token.length()) {
            if (Character.isAlphabetic(token.charAt(i))) {
                countDigits++;
            }
            i++;
        }
        if (countDigits == token.length()) {
            return true;
        }
        return false;
    }
}
