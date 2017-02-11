package ru.rsreu.fedyukin0215;

public class StringHandler {

	/*
	 * Check each line
	 */
	public static String[] stringArrayHandle(String[] stringArray) {
		String[] resultArray = new String[stringArray.length];

		for (int i = 0; i < stringArray.length; i++) {
			String string = stringArray[i].trim();

			if (string.length() == 0) {
				resultArray[i] = "Empty string!";
			} else {
				resultArray[i] = consistEvenNums(string.split(" "));
			}
		}

		return resultArray;
	}

	/*
	 * Check each word
	 */
	public static String consistEvenNums(String[] wordArray) {
		String result = "";

		for (int i = 0; i < wordArray.length; i++) {
			try {
				int num = Integer.parseInt(wordArray[i]);

				if (numHandle(num)) {
					result += wordArray[i] + " ";
				}
			} catch (NumberFormatException e) {
				result += "";
			}
		}

		return result;
	}

	/*
	 * Check even nums
	 */
	public static boolean numHandle(int num) {
		String string = Integer.toString(num);
		boolean result = true;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) != '0' && string.charAt(i) != '2'
					&& string.charAt(i) != '4' && string.charAt(i) != '6'
					&& string.charAt(i) != '8' && string.charAt(i) != '-') {
				result = false;
			}
		}

		return result;
	}

	private StringHandler() {
	}

}
