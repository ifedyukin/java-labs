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
			if (wordArray[i].matches("^-*[02468]+")) {
				result += wordArray[i] + " ";
			}
		}

		return (result.length() == 0 ? "No result!" : result);
	}

	private StringHandler() {
	}

}
