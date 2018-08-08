package string;

import java.util.HashMap;
import java.util.Map;

public class UniqueCharacterInString {

	Map<String, Integer> cache = new HashMap<String, Integer>();

	private String stringRecieved;

	// Getter START
	public String getStringRecieved() {
		return stringRecieved;
	}

	public void setStringRecieved(String stringRecieved) {
		this.stringRecieved = stringRecieved;
	}

	// Getter END

	/**
	 * Helper function to count the string and return unique number of char in
	 * String
	 * 
	 * @return
	 */
	public int checkUniqueinStringAndSet() {
		int count = 0;
		for (int i = 0; i < this.stringRecieved.length(); i++) {
			boolean flag = false;
			for (int j = 0; j < i; j++) {
				if (this.stringRecieved.charAt(j) == this.stringRecieved.charAt(i)) {
					flag = true;
					break;
				}
			}
			if (!flag && this.stringRecieved.charAt(i) != ' ') {
				count++;
			}
		}
		cache.put(stringRecieved, count);
		return count;
	}

	/**
	 * Function to check from cache and return number of count
	 * 
	 * @return
	 */
	public int CheckAndreturnUniqueNumberInString() {

		if (cache.containsKey(stringRecieved.trim())) {
			return cache.get(stringRecieved.trim());
		} else {
			return this.checkUniqueinStringAndSet();

		}

	}

	public static void main(String args[]) {
		UniqueCharacterInString unique = new UniqueCharacterInString();
		unique.setStringRecieved("Nikhil");
		System.out.println(unique.CheckAndreturnUniqueNumberInString());
		unique.setStringRecieved("Nikhil Saxena");
		System.out.println(unique.CheckAndreturnUniqueNumberInString());
	}

}
