package AssignmentClasses;

final class Poly {
    private int cofficient[];

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
     * Function powerCalc(int,float) to compute power of element
     * 
     * @param power
     * @param value
     * @return powerCalc after calculating power
     */
    float powerCalc(int power, float value) {
        float powerCalc = 1;
        if (power == 0) {
            return 1;
        }
        for (int i = 0; i < power; i++) {
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
    float evaluate(float value) {
        float result = 0;

        for (int i = this.cofficient.length - 1, k = 0; i >= 0; i--, k++) {
            int cofficient = this.cofficient[k];
            result += cofficient * this.powerCalc(i, value);
        }

        return result;
    }

    /**
     * Function to find degree of polynomial
     * 
     * @return degree of polynomial
     */
    int degree() {
        return this.cofficient.length - 1;
    }

    /**
     * Function to add two polynomials
     * 
     * @param polynomial
     * @return addition of polynomial
     */
    int[] addTwoPoly(Poly polynomial) {

        int resultPoly[] = new int[this.cofficient.length];

        for (int i = resultPoly.length - 1, k = polynomial.cofficient.length - 1; i >= 0; i--, k--) {
            if (k >= 0) {
                resultPoly[i] = this.cofficient[i] + polynomial.cofficient[k];
            } else {
                resultPoly[i] = this.cofficient[i];
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
    int[] multiplyTwoPoly(Poly polynomial) {
        int multiplyPoly[] = new int[(this.cofficient.length + polynomial.cofficient.length) - 1];

        for (int i = this.cofficient.length - 1; i >= 0; i--) {
            for (int j = polynomial.cofficient.length - 1; j >= 0; j--) {

                multiplyPoly[i + j] = multiplyPoly[i + j] + this.cofficient[i]
                        * polynomial.cofficient[j];

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
        int polySum[] = polynomial2.addTwoPoly(polynomial1);
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
