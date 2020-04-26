package org.lba.hk.algorithms.warmup.ex01.simplearraysum;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.lba.hk.util.BasicJavaUtility;

public class SimpleArrayNumWithExitCommandAndMultipleIterations {

	private static final String EXIT_FOR_ARRAY_SCAN = "exit";
	private static final Integer EXIT_FOR_SIZE_SCAN = -1;
	/*
	 * Complete the simpleArraySum function below.
	 */
	static int simpleArraySum(int[] ar) {
		/*
		 * Write your code here.
		 */
		int sum = 0;

		for(int i = 0; i < ar.length; i++){
			sum += ar[i];
		}

		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException, URISyntaxException {

		System.out.println("** SimpleArrayNumWithExitCommandAndMultipleIterations: using input from user with exit commands - START **");
		String response = "";

		do {
			
			/*2. read  arraySize, only valid integer > 0 */
			System.out.print("Enter array size number (-1 to exit): ");
			while (!scanner.hasNextInt()) {
				System.out.println("Please insert a valid number for array size (number > 0) : ");
				scanner.next();
			}


			int arCount = scanner.nextInt();
			/*2.1 Check exit */
			if(arCount == EXIT_FOR_SIZE_SCAN) {
				exitProgram();
			}

			System.out.println("\tNumber entered: " + arCount);
			int[] ar = new int[arCount];
			/*?*/
			scanner.nextLine();
			/*Scan array elements*/
			System.out.print("Enter array elements (type exit as first element to close program): ");
			String[] arItems = scanner.nextLine().split(" ");
			/*Check exit from array elements scan*/
			if(arItems[0].equalsIgnoreCase(EXIT_FOR_ARRAY_SCAN)) {
				exitProgram();
			}

			/*Post read validation*/
			boolean validParsedCSVRecord = validateArraySizeConsistency(arCount,arItems);
			boolean validNumericArray = validateIsAllNumericArrayElements(arItems);

			if(validParsedCSVRecord && validNumericArray) {

				for (int arItr = 0; arItr < arCount; arItr++) {
					int arItem = Integer.parseInt(arItems[arItr].trim());
					ar[arItr] = arItem;
				}

				/*Call function to solve problem assignement*/
				int result = simpleArraySum(ar);
				System.out.println("Result: " + String.valueOf(result));
			}

			System.out.print("Do you wanna quit ? (y/n) ");
			response = scanner.next();
			

		}
		while(!response.toUpperCase().matches("Y|YE|YES"));
		/**/
		if (response.matches("[yY]")) {
			System.out.println("Goodbye");
		}
		System.out.println("** SimpleArrayNumWithExitCommandAndMultipleIterations: using input from user with exit commands - END **");
	}

	private static void exitProgram() {
		System.out.println("... bye ...");
		System.exit(0);
	}

	/**
	 * Check validity for test case
	 * @param arCount : size must be integer > 0
	 * @param arItems : array that cointains data to sum
	 * @return true if validity check are passed, false otherwise
	 */
	private static boolean validateArraySizeConsistency(int arCount, String[] arItems) { 
		boolean result = true;

		if(arCount<=0) {
			System.out.println("The number of the array must be a positive number > 0");
			result = false;

		}

		if(arCount!=arItems.length) {
			System.out.println("The size of array and elements present into array have different size:"
					+ "size declared: " + arCount + " - arraySize: " + arItems.length
					);
			result = false;
		}

		return result;
	}

	/**
	 * Check if an arrays contains only integer values
	 * @param arItems
	 * @return true if array contains only integer values, false otherwise
	 */
	private static boolean validateIsAllNumericArrayElements(String[] arItems) {

		boolean result = true;

		for(int i =0; i < arItems.length; i++) {
			String currentItem = arItems[i];
			result = BasicJavaUtility.isNumericInteger(currentItem);
			if(!result) {
				System.out.println("Item: " + currentItem + " on array position: " + i + " is not a integer value");
				break;
			}
		}

		return result;
	}
}
