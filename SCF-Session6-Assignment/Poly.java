package AssignmentClasses;

/**
 * Mutable class for Operation on Polynomials
 * 
 * evaluate add multiply degree
 */
public final class Poly {
    
    final private int cofficient[];

    /**
     * Constructor for initialization of cofficient and power of polinomial in
     * array
     * 
     * @param cofficient
     * @param power
     */
    Poly(int cofficient[]) {
        this.cofficient = cofficient;
    }

    /**
     * Helper function powerCalc(int,float) to compute power of element
     * 
     * @param power
     * @param value
     * @return powerCalc after calculating power
     */
    public float powerCalc(int power, float value) {
        float powerCalc = 1;
        if (power == 0) {
            return 1;
        }
        for (int index = 0; index < power; index++) {
            powerCalc *= value;
        }
        return powerCalc;
    }

    /**
     * Function to evaluate polynomial
     * 
     * @param value
     * @return result computed from polynomial
     */
    public float evaluate(float value) {
        float result = 0;

        // Here index1 is for Power and index2 is for cofficient
        for (int index1 = this.cofficient.length - 1, index2 = 0; index1 >= 0; index1--, index2++) {
            int cofficient = this.cofficient[index2];
            result += cofficient * this.powerCalc(index1, value);
        }

        return result;
    }

    /**
     * Function to find degree of polynomial
     * 
     * @return degree of polynomial
     */
    public int degree() {
        return this.cofficient.length - 1;
    }

    /**
     * Function to add two polynomials
     * 
     * @param polynomial
     * @return addition of polynomial
     */
    public int[] addTwoPoly(Poly polynomial) {

        // If polynomial1 length is smaller than polynomial2 interchange the
        // places of polynomials
        if (polynomial.cofficient.length > this.cofficient.length) {
            int result[] = polynomial.addTwoPoly(this);
            return result;
        }

        int resultPoly[] = new int[this.cofficient.length];

        // Here index1 is for first Polynomial and index2 is for second
        // polynomial
        for (int index1 = this.cofficient.length - 1, index2 = polynomial.cofficient.length - 1; index1 >= 0; index1--, index2--) {
            if (index2 >= 0) {
                resultPoly[index1] = this.cofficient[index1]
                        + polynomial.cofficient[index2];
            } else {
                resultPoly[index1] = this.cofficient[index1];
            }
        }
        return resultPoly;
    }

    /**
     * Function to multiply two polynomials
     * 
     * @param polynomial
     * @return multiply of polynomial
     */
    public int[] multiplyTwoPoly(Poly polynomial) {
        int multiplyPoly[] = new int[(this.cofficient.length + polynomial.cofficient.length) - 1];

        for (int index1 = this.cofficient.length - 1; index1 >= 0; index1--) {
            for (int index2 = polynomial.cofficient.length - 1; index2 >= 0; index2--) {

                multiplyPoly[index1 + index2] = multiplyPoly[index1 + index2]
                        + this.cofficient[index1]
                        * polynomial.cofficient[index2];

            }
        }

        return multiplyPoly;
    }

    public static void main(String args[]) {

        Poly polynomial1 = new Poly(new int[] { 1, 1 }); // X+1
        Poly polynomial2 = new Poly(new int[] { 2, 2, 1 }); // 2X^2+2^X+1

        System.out.println("Evaluate Results : " + polynomial1.evaluate(2));
        System.out.println("Degree : " + polynomial1.degree());

        System.out.println("Evaluate Results : " + polynomial2.evaluate(1));
        System.out.println("Degree : " + polynomial2.degree());

        System.out.println("Sum of Polynomial1 and Polynomial2 : ");
        int polySum[] = polynomial1.addTwoPoly(polynomial2);
        for (int i = 0; i < polySum.length; i++) {
            System.out.print("   " + polySum[i] + "   ");
        }
        System.out.println();
        System.out.println("Product of Polynomial1 and Polynomial2 : ");
        int polyMultiply[] = polynomial2.multiplyTwoPoly(polynomial1);
        for (int i = 0; i < polyMultiply.length; i++) {
            System.out.print("   " + polyMultiply[i] + "   ");
        }

    }
}
