package ru.rsreu.fedyukin0215;

public class EvenNumsStringsFinder {

	private EvenNumsStringsFinder() {
	}

	/*
	 * Check each line
	 */
	public static String[] stringsHandler(String[] strings) {
		String[] result = new String[strings.length];

		for (int i = 0; i < strings.length; i++) {
			String string = strings[i].trim();

			if (string.isEmpty()) {
				result[i] = "Empty string!";
			} else {
				String[] words = string.split(" ");
				result[i] = consistEvenNums(words);
			}
		}

		return result;
	}

	/*
	 * Check each word
	 */
	private static String consistEvenNums(String[] words) {
		String result = "";

		for (String word : words) {
			if (word.matches("^-?[02468]+")) {
				result += word + " ";
			}
		}

		return (result.isEmpty() ? "No result!" : result);

	}

}
