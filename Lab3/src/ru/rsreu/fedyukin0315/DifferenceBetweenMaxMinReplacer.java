package ru.rsreu.fedyukin0315;

import java.util.Arrays;

public class DifferenceBetweenMaxMinReplacer {
	private int[] arrayBody;
	private int minIndex = 0;
	private int maxIndex = 0;
	private int count = 0;

	public DifferenceBetweenMaxMinReplacer(int... args) {
		this.arrayBody = new int[args.length];
		setArrayElements(args);
	}

	public void setArrayElements(int... args) {
		int length = args.length;
		for (int i = 0; i < length; i++) {
			this.arrayBody[i] = args[i];
		}
	}

	public int getCount() {
		return this.count;
	}
	
	private void indicesOfMinMax() {
		int length = this.arrayBody.length;
		for (int i = 0; i < length; i++) {
			if (this.arrayBody[i] < this.arrayBody[this.minIndex]) {
				this.minIndex = i;
			}

			if (this.arrayBody[i] > this.arrayBody[this.maxIndex]) {
				this.maxIndex = i;
			}
		}
	}

	public void assignElemsBetweenMinMax() {
		this.indicesOfMinMax();
		int indexDifference = this.maxIndex - this.minIndex;
		int elementDifference = this.arrayBody[this.maxIndex]
				- this.arrayBody[this.minIndex];
		
		int begin = indexDifference > 0 ? this.minIndex : this.maxIndex;
		int end = indexDifference < 0 ? this.minIndex : this.maxIndex;

		for (int i = begin + 1; i < end; i++) {
			this.arrayBody[i] = elementDifference;
			this.count++;
		}
	}

	@Override
	public String toString() {
		return Arrays.toString(this.arrayBody);
	}

}
