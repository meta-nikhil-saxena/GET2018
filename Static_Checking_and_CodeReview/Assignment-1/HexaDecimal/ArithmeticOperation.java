package HexaDecimal;

public class ArithmeticOperation {
	HexaCalc conversion = new HexaCalc();
	Comparison compare = new Comparison();

	String add(String hexadecimal1, String hexadecimal2) {

		int add = conversion.hexaToDecimal(hexadecimal1)
				+ conversion.hexaToDecimal(hexadecimal2);

		return conversion.decimalToHexa(add);

	}

	String subtract(String hexadecimal1, String hexadecimal2) {
		if (compare.compareGreaterHexadecimal(hexadecimal1, hexadecimal2)) {
			int subtract = conversion.hexaToDecimal(hexadecimal1)
					- conversion.hexaToDecimal(hexadecimal2);

			return conversion.decimalToHexa(subtract);
		}
		return "Please input Hexadecimal code Correctly <<First String should be Greater than Second>>";

	}

	String multiply(String hexadecimal1, String hexadecimal2) {
		int multiply = conversion.hexaToDecimal(hexadecimal1)
				* conversion.hexaToDecimal(hexadecimal2);

		return conversion.decimalToHexa(multiply);

	}

	String divide(String hexadecimal1, String hexadecimal2) {
		if (compare.compareGreaterHexadecimal(hexadecimal1, hexadecimal2)) {
			int divide = conversion.hexaToDecimal(hexadecimal1)
					/ conversion.hexaToDecimal(hexadecimal2);

			return conversion.decimalToHexa(divide);
		}
		return "Please input Hexadecimal code Correctly <<First String should be Greater than Second>>";

	}
}
