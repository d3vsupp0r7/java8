package org.lba.hk.algorithms.warmup.ex01.simplearraysum;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.lba.hk.util.BasicJavaUtility;

public class SimpleArrayNumUsingLog4j {

	static final Logger logger = Logger.getLogger(SimpleArrayNumUsingLog4j.class);

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

		logger.debug("** SimpleArrayNumUsingLog4j: using input from user [LOG4J] - START **");

		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

		logger.debug("Enter array size number: ");
		int arCount = Integer.parseInt(scanner.nextLine().trim());

		int[] ar = new int[arCount];

		logger.debug("Enter array elements: ");
		String[] arItems = scanner.nextLine().split(" ");

		/*Post read validation*/
		boolean validParsedCSVRecord = validateArraySizeConsistency(arCount,arItems);
		boolean validNumericArray = validateIsAllNumericArrayElements(arItems);

		if(validParsedCSVRecord && validNumericArray) {
			for (int arItr = 0; arItr < arCount; arItr++) {
				int arItem = Integer.parseInt(arItems[arItr].trim());
				ar[arItr] = arItem;
			}

			int result = simpleArraySum(ar);

			bufferedWriter.write(String.valueOf(result));
			bufferedWriter.newLine();

			bufferedWriter.close();
		}

		logger.debug("** SimpleArrayNumUsingLog4j: using input from user [LOG4J] - END **");
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
				logger.debug("Item: " + currentItem + " on array position: " + i + " is not a integer value");
				break;
			}
		}

		return result;
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
			logger.debug("The number of the array must be a positive number > 0");
			result = false;

		}

		if(arCount!=arItems.length) {
			logger.debug("The size of array and elements present into array have different size:"
					+ "size declared: " + arCount + " - arraySize: " + arItems.length
					);
			result = false;
		}

		return result;
	}
}
