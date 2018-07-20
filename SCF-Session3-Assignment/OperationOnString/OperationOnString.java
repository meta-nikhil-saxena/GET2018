/**
 * Class for String operations with following functions :
 * 
 * CompareStrings(String,String)
 * reverseString(String)
 * CaseChange(String)
 * LongestWordFromString(String)
 */

package OperationOnString;

public class OperationOnString {

	/**
	 * Function for string comparison just linke equals() in java Strings
	 * 
	 * @param string1
	 * @param string2
	 * @return 1 if both equals , 0 if both are not equal
	 */
	int CompareStrings(String string1, String string2) {
		int length = string1.length();
		int length1 = string2.length();

		if (length == length1) {
			char characterSequence1[] = string1.toCharArray();
			char characterSequence2[] = string2.toCharArray();

			for (int i = 0; i < length; i++) {
				if (characterSequence1[i] == characterSequence2[i]) {
					continue;
				} else {
					return 0;
				}
			}
		} else {
			return 0;
		}
		return 1;
	}

	/**
	 * Function for reverse a string
	 * 
	 * @param string
	 * @return reversed string
	 */
	String reverseString(String string) {
		char charSequence[] = string.toCharArray();
		String newReversedString = "";
		int length = string.length();

		for (int i = length - 1; i >= 0; i--) {
			newReversedString += charSequence[i];
		}
		return newReversedString;
	}

	/**
	 * Function for changing the case of a string
	 * 
	 * @param string
	 * @return lowercase --> uppercase And uppercase --> lowercase in a whole
	 *         String
	 */
	String CaseChange(String string) {

		int length = string.length();
		String newString = "";

		for (int i = 0; i < length; i++) {
			char temporary = string.charAt(i);
			if (temporary >= 65 && temporary <= 90) {
				temporary = (char) (temporary + 32);
				newString += temporary;
			} else if (temporary >= 97 && temporary <= 122) {
				temporary = (char) (temporary - 32);
				newString += temporary;
			} else {
				newString += " ";

			}
		}

		return newString;
	}

	/**
	 * Function to find Largest word from the string
	 * 
	 * @param string
	 * @return word which is largest, if both word are same then @return last
	 *         word
	 */
	String LongestWordFromString(String string) {
		int length = 0, maxLength = 0;
		String newMaxString = "";
		String stringArray[] = string.split(" ");
		for (String insideLoopString : stringArray) {
			length = insideLoopString.length();
			if (maxLength < length) {
				maxLength = length;
				newMaxString = insideLoopString;
			} else if (maxLength == length) {
				return stringArray[(stringArray.length) - 1];
			} else {
				continue;
			}
		}
		return newMaxString;
	}
}