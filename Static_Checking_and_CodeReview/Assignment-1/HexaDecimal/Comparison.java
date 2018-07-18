/**
 * Class for Comparison
 * whether hexadecimal 1 is greater than hexadecimal 2 or,
 * smaller or,
 * Equal
 */
package HexaDecimal;

public class Comparison {
	boolean compareGreaterHexadecimal(String hexadecimal1, String hexadecimal2) {
		int compare = hexadecimal1.compareTo(hexadecimal2);
		if (compare > 0) {
			return true;
		}
		return false;
	}

	boolean compareSmallerHexadecimal(String hexadecimal1, String hexadecimal2) {
		int compare = hexadecimal1.compareTo(hexadecimal2);
		if (compare < 0) {
			return true;
		}
		return false;
	}

	boolean compareEqualHexadecimal(String hexadecimal1, String hexadecimal2) {
		int compare = hexadecimal1.compareTo(hexadecimal2);
		if (compare == 0) {
			return true;
		}
		return false;
	}
}
