package AssignmentClasses;

/**
 * Class for LCM and HCF with Operation :
 * 
 * lcm(int,int) It has a helping function for Operation :
 * lcmOperation(int,int,factor)
 * 
 * hcf(int,int)
 */

public class LCMandHCF {

    /**
     * lcmOperation function
     * 
     * @param number1
     * @param number2
     * @param factor
     * @return LCM to lcm function
     */
    int lcmOperation(int number1, int number2, int factor) {
        if (number1 == 1 && number2 == 1) {
            return 1;
        }
        if (factor > number1 && factor > number2) {
            factor = 2;
            return lcmOperation(number1, number2, factor);
        }
        if (number1 % factor == 0 && number2 % factor == 0) {
            return factor
                    * lcmOperation(number1 / factor, number2 / factor,
                            factor + 1);
        }
        if (number1 % factor == 0) {
            return factor * lcmOperation(number1 / factor, number2, factor + 1);
        }
        if (number2 % factor == 0) {
            return factor * lcmOperation(number1, number2 / factor, factor + 1);
        }
        return lcmOperation(number1, number2, factor + 1);
    }

    /**
     * lcm calculation function
     * 
     * @param number1
     * @param number2
     * @return LCM
     */
    public int lcm(int number1, int number2) {
        int factor = 2;
        int lcmOfNumbers = lcmOperation(number1, number2, factor);
        return lcmOfNumbers;
    }

    /**
     * HCF calculation function
     * 
     * @param number1
     * @param number2
     * @return HCF
     */
    public int hcf(int number1, int number2) {
        if (number1 == number2) {
            return number1;
        }
        if (number1 > number2) {
            return hcf(number1 - number2, number2);
        }
        return hcf(number1, number2 - number1);
    }

    public static void main(String args[]) {
        System.out.println(new LCMandHCF().lcm(6, 14));
        System.out.println(new LCMandHCF().hcf(3, 9));

    }
}
