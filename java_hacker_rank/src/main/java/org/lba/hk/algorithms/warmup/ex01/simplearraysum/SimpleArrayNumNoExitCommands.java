package org.lba.hk.algorithms.warmup.ex01.simplearraysum;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.lba.hk.util.BasicJavaUtility;

public class SimpleArrayNumNoExitCommands {

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

		System.out.println("** SimpleArrayNumNoExitCommands: using input from user - START **");
		
		/*1. Configure the out writer*/
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		/*2. read  arraySize */
		System.out.print("Enter array size number (-1 to exit): ");
		while (!scanner.hasNextInt()) {
			System.out.println("Please insert a valid number for array size (number > 0) : ");
			scanner.next();
		}
		
		int arCount = scanner.nextInt();
		
		System.out.println("\tNumber entered: " + arCount);
		int[] ar = new int[arCount];
		/*?*/
		scanner.nextLine();
		/**/
		System.out.print("Enter array elements: ");
		String[] arItems = scanner.nextLine().split(" ");

		boolean validNumericArray = validateNumericArray(arItems);
		boolean validParsedCSVRecord = validateProcessedTestRecord(arCount,arItems);

		if(validParsedCSVRecord && validNumericArray) {

			for (int arItr = 0; arItr < arCount; arItr++) {
				int arItem = Integer.parseInt(arItems[arItr].trim());
				ar[arItr] = arItem;
			}

			int result = simpleArraySum(ar);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();

		}

		bufferedWriter.close();
		System.out.println("** SimpleArrayNumNoExitCommands: using input from user - END **");
	}

	/**
	 * Check validity for test case
	 * @param arCount : size must be integer > 0
	 * @param arItems : array that cointains data to sum
	 * @return true if validity check are passed, false otherwise
	 */
	private static boolean validateProcessedTestRecord(int arCount, String[] arItems) { 
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
	private static boolean validateNumericArray(String[] arItems) {

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
