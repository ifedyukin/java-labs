package ru.rsreu.fedyukin0215;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		/*
		 * Input
		 */
		Scanner in = new Scanner(System.in);

		System.out.print("Enter numbers of strings: n=");
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] stringArray = new String[stringCount];
		for (int i = 0; i < stringArray.length; i++) {
			System.out.printf("Enter %d string: ", i + 1);
			stringArray[i] = in.nextLine();
		}

		in.close();

		/*
		 * Output
		 */
		String[] resultArray = StringHandler.stringArrayHandle(stringArray);
		for (int i = 0; i < resultArray.length; i++) {
			System.out.printf("String %d: %s \n", i + 1, resultArray[i]);
		}

	}

	private Runner() {
	}

}
