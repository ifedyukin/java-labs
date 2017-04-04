package ru.rsreu.fedyukin0415;

import ru.rsreu.fedyukin0415.resourcer.Resourcer;
import com.prutzkow.twodimarray.TwoDimArray;

public class SumOfRowsWithMaxElementsCalulator extends TwoDimArray {

	public SumOfRowsWithMaxElementsCalulator(int... sizes) {
		super(sizes);
	}

	/**
	 * 
	 * @return Max element of array.
	 */
	private int getMaxElement() {
		int maxElement = this.arrayBody[0][0];

		for (int i = 0; i < super.getRowCount(); i++) {
			for (int j = 0; j < super.getRowLength(i); j++) {
				if (this.arrayBody[i][j] > maxElement) {
					maxElement = this.arrayBody[i][j];
				}
			}
		}

		return maxElement;
	}

	/**
	 * @param array
	 *            - array of integer whose will be checked for contain "element"
	 *            from parameters.
	 * @param element
	 *            - integer element whose will be checked for contain in "array"
	 *            from parameters.
	 * @return True - if array contain element.
	 */
	private boolean isArrayContainElement(int[] array, int element) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == element) {
				return true;
			}
		}

		return false;
	}

	/**
	 * @param array
	 *            - integer array for calculate sum of elements.
	 * @return Sum of array element.
	 */
	private int summArray(int[] array) {
		int sum = 0;

		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}

		return sum;
	}

	/**
	 * Calculate sum of rows with maximum element of the array.
	 * 
	 * @return Strings with message from resources, row number and sum for this
	 *         row. Pattern: "resource.message" *row number*: *sum row
	 *         elements*. Example: Sum of string 2: 32.
	 */
	public String sumOfStringsWithMaxElements() {
		StringBuilder result = new StringBuilder();
		int maxElement = getMaxElement();

		for (int i = 0; i < super.getRowCount(); i++) {
			boolean isElementContain = isArrayContainElement(this.arrayBody[i], maxElement);
			
			if (isElementContain) {
				int arraySum = summArray(this.arrayBody[i]);
				
				result.append(Resourcer.getString("message.sumOfString")).append(i + 1).append(": ")
						.append(arraySum).append("\n");
			}
		}
		
		return result.toString();

	}

	/**
	 * Return: matrix array and length of last row.
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();

		int lastStringLength = this.arrayBody[super.getRowCount() - 1].length;
		result.append(Resourcer.getString("message.lastStringLength")).append(lastStringLength);

		return super.toString() + result.toString();
	}

	/**
	 * Fill array with random numbers in the range [min, max].
	 * 
	 * @param min
	 *            - minimal limit of range.
	 * @param max
	 *            - maximum limit of range.
	 */
	public void fill(int min, int max) {
		for (int i = 0; i < super.getRowCount(); i++) {
			for (int j = 0; j < super.getRowLength(i); j++) {
				int randomNumber = min + (int) (Math.random() * max);

				this.arrayBody[i][j] = randomNumber;
			}
		}
	}
}