package ru.rsreu.fedyukin0215;

import java.util.Scanner;

public class Runner {
	
	private Runner() {
	}
	
	public static void main(String[] args) {
		try {
			Runner app = new Runner();
			app.startApplication();
		} catch (Exception e) {
			System.err.println("error");
			e.printStackTrace();
		}
	}

	private void startApplication() {
		Scanner in = new Scanner(System.in);

		System.out.print("Enter numbers of strings: n=");
		int stringCount = Integer.parseInt(in.next());
		in.nextLine();

		String[] stringArray = getStrings(in, stringCount);

		in.close();

		String[] resultArray = StringHandler.stringArrayHandle(stringArray);
		
		for (int i = 0; i < resultArray.length; i++) {
			System.out.printf("String %d: %s \n", i+1, resultArray[i]);
		}
	}
	
	private String[] getStrings(Scanner in, int stringCount) {
		String[] stringArray = new String[stringCount];
		
		for (int i = 0; i < stringArray.length; i++) {
			System.out.printf("Enter %d string: ", i + 1);
			stringArray[i] = in.nextLine();
		}
		
		return stringArray;
	}
}
