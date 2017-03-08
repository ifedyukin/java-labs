package ru.rsreu.fedyukin0315;

import java.util.Locale;

public class Runner {

	public static void main(String[] args) {
		
		StringBuilder result;
		Locale.setDefault(Locale.US);
		result = new StringBuilder();

		//Original array
		DifferenceBetweenMaxMinReplacer arrayObject = new DifferenceBetweenMaxMinReplacer(
				1, -10, -12, 12, 10, 6);
		result.append(Resourcer.getString("message.origin")).append("\n")
				.append(arrayObject).append("\n\n");

		//Array with changed elements between maximum and minimal elements
		arrayObject.assignElemsBetweenMinMax();
		result.append(Resourcer.getString("message.worked")).append("\n")
				.append(arrayObject).append("\n");
		//Check changes
		if (arrayObject.getCount() == 0) {
			result.append(Resourcer.getString("message.noResult")).append("\n");
		}

		System.out.println(result);

	}

	private Runner() {
	}

}
