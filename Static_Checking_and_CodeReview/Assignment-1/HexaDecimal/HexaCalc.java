package HexaDecimal;

import java.util.Scanner;

public class HexaCalc {

	static ArithmeticOperation arithmeticCalculation = new ArithmeticOperation();
	static Comparison compare = new Comparison();

	/**
	 * @param hexadecimal
	 * @return decimal
	 */
	int hexaToDecimal(String hexadecimal) {

		int decimal = 0, base = 1;
		char hexvalue[] = hexadecimal.toCharArray();

		for (int i = hexvalue.length - 1; i >= 0; i--) {
			if (hexvalue[i] >= '1' && hexvalue[i] <= '9') {
				decimal += (hexvalue[i] - 48) * base;
				base = base * 16;
			} else if (hexvalue[i] >= 'A' && hexvalue[i] <= 'F') {
				decimal += (hexvalue[i] - 55) * base;
				base = base * 16;
			} else {
				System.out.println("Invalid Hexadecimal Code");
			}
		}
		return decimal;
	}

	/**
	 * @param decimal
	 * @return hexadecimal
	 */
	String decimalToHexa(int decimal) {
		String hexadecimal = "", newhexadecimal = "";
		int remainder;

		while (decimal != 0) {

			remainder = decimal % 16;
			if (remainder < 10) {
				hexadecimal = hexadecimal
						+ Character.toString((char) (remainder + 48));
			} else {
				hexadecimal = hexadecimal
						+ Character.toString((char) (remainder + 55));
			}
			decimal = decimal / 16;
		}
		for (int i = hexadecimal.length() - 1; i >= 0; i--) {
			newhexadecimal += hexadecimal.charAt(i);
		}
		return newhexadecimal;
	}

	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		String hexadecimal1 = "", hexadecimal2 = "";
		int choice;
		String add, subtract, multiply, divide;

		do {
			System.out.println("1. Input Hexadecimal ");
			System.out.println("2. Add ");
			System.out.println("3. Subtract");
			System.out.println("4. Multiply");
			System.out.println("5. Divide");
			System.out.println("6. Compare");
			System.out.println("7. EXIT");

			System.out.println("Enter your choice:");
			choice = sc.nextInt();

			switch (choice) {
			case 1: {
				System.out.println("Enter Hexa decimal code 1 -->> ");
				hexadecimal1 = sc.next();
				System.out.println("Enter Hexa decimal code 2 -->> ");
				hexadecimal2 = sc.next();
				break;
			}
			case 2: {
				add = arithmeticCalculation.add(hexadecimal1, hexadecimal2);
				System.out.println("HexaDecimal code After Addition : " + add);
				break;
			}
			case 3: {
				subtract = arithmeticCalculation.subtract(hexadecimal1,
						hexadecimal2);
				System.out.println("HexaDecimal code After Subtraction : "
						+ subtract);
				break;
			}
			case 4: {
				multiply = arithmeticCalculation.multiply(hexadecimal1,
						hexadecimal2);
				System.out.println("HexaDecimal code After Multiply : "
						+ multiply);
				break;
			}
			case 5: {
				divide = arithmeticCalculation.divide(hexadecimal1,
						hexadecimal2);
				System.out.println("HexaDecimal code After Divide : " + divide);
				break;
			}
			case 6: {
				if (compare.compareGreaterHexadecimal(hexadecimal1,
						hexadecimal2)) {
					System.out.println("Hexadecimal " + hexadecimal1
							+ " is Greater than " + hexadecimal2);
				}
				if (compare.compareSmallerHexadecimal(hexadecimal1,
						hexadecimal2)) {
					System.out.println("Hexadecimal " + hexadecimal1
							+ " is Smaller than " + hexadecimal2);
				}
				if (compare.compareEqualHexadecimal(hexadecimal1, hexadecimal2)) {
					System.out.println("Hexadecimal " + hexadecimal1
							+ " is Equal to " + hexadecimal2);
				}
				break;
			}
			case 7: {
				System.exit(0);
				break;
			}
			default: {
				System.out.println("Invalid choice");
				break;
			}

			}
		} while (true);
	}
}
