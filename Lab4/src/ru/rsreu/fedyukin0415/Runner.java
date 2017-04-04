package ru.rsreu.fedyukin0415;

import java.util.Locale;
import ru.rsreu.fedyukin0415.resourcer.Resourcer;

public class Runner {

	public static int MAX_RANGE_VALUE = 10;
	public static int MIN_RANGE_VALUE = 0;
	
	private Runner() {
	}
	
	public static void main(String[] args) {
		
		StringBuilder result;
		Locale.setDefault(Locale.US);
		result = new StringBuilder();

		SumOfRowsWithMaxElementsCalulator arrayObject = new SumOfRowsWithMaxElementsCalulator(3, 5, 0, 4, 2, 2, 7);
		arrayObject.fill(MIN_RANGE_VALUE, MAX_RANGE_VALUE);
		
		result.append(Resourcer.getString("message.origin")).append("\n").append(arrayObject).append("\n\n");

		result.append(Resourcer.getString("message.worked")).append("\n")
				.append(arrayObject.sumOfStringsWithMaxElements());

		System.out.println(result);

	}

}