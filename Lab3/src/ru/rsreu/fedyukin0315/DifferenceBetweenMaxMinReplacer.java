package ru.rsreu.fedyukin0315;

import java.util.Arrays;

public class DifferenceBetweenMaxMinReplacer {
	private int[] arrayBody;

	public DifferenceBetweenMaxMinReplacer(int... args) {
		this.arrayBody = new int[args.length];
		setArrayElements(args);
	}

	private void setArrayElements(int... args) {
		int length = args.length;
		for (int i = 0; i < length; i++) {
			this.arrayBody[i] = args[i];
		}
	}
	
	private int getIndexOfMin(int[] array) {
		int length = array.length;
		int minIndex = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] < array[minIndex]) {
				minIndex = i;
			}
		}
		return minIndex;
	}
	
	private int getIndexOfMax(int[] array) {
		int length = array.length;
		int maxIndex = 0;
		for (int i = 0; i < length; i++) {
			if (array[i] > array[maxIndex]) {
				maxIndex = i;
			}
		}
		return maxIndex;
	}

	public boolean assignElementssBetweenMinMax() {
		int minIndex = getIndexOfMin(this.arrayBody);
		int maxIndex = getIndexOfMax(this.arrayBody);
		
		int indexDifference = maxIndex - minIndex;
		int elementDifference = this.arrayBody[maxIndex]
				- this.arrayBody[minIndex];
		
		int start = indexDifference > 0 ? minIndex : maxIndex;
		int finish = indexDifference < 0 ? minIndex : maxIndex;

		Arrays.fill(this.arrayBody, start + 1, finish, elementDifference);

		return Math.abs(indexDifference) == 1;
	}

	@Override
	public String toString() {
		return Arrays.toString(this.arrayBody);
	}

}
