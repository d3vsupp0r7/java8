package org.lba.hk.algorithms.warmup.ex01.simplearraysum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.InvalidParameterException;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.hk.util.BasicJavaUtility;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class SimpleArrayNumUsingOpenCSVLibrary {

	static final Logger logger = Logger.getLogger(SimpleArrayNumUsingOpenCSVLibrary.class);
	
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

	public static void main(String[] args) throws IOException, URISyntaxException {

		logger.debug("** SimpleArrayNumUsingOpenCSVLibrary - START **");
		/*1. Read file*/
		SimpleArrayNumUsingOpenCSVLibrary simpleArrayNum3 = new SimpleArrayNumUsingOpenCSVLibrary();
		File file = simpleArrayNum3.getFileFromResources("csv/data01/data-ex1.csv");
		String csvFilename =  file.getAbsolutePath();
		if(csvFilename.contains("%20")) {
			csvFilename = csvFilename.replaceAll("%20", " ");
		}
		
		/*2. define the split char*/
		String splitChar = " ";

		/*3. process CSV records - valid and invalid csv record format*/
		CsvToBean<SimpleArrayNumCSVTestDataMapper> openCsvObject = getOpenCSVObject(csvFilename);
		List<SimpleArrayNumCSVTestDataMapper> testCases = getCsvValidRecord(openCsvObject);
		List<CsvException> invalidCsvRecords = getCsvInvalidRecord(openCsvObject);
		
		/*4. process only valid csv records*/
		for (SimpleArrayNumCSVTestDataMapper currentTestRecord : testCases) {

			/*4.1 step executed for every test case inside csv file*/
			int arCount = Integer.parseInt(currentTestRecord.getArraySize());
			int[] ar = new int[arCount];
			/**/
			String arItemsTestCase = currentTestRecord.getArrayElements();
			String[] arItems = arItemsTestCase.split(splitChar); 

			boolean validParsedCSVRecord = validateProcessedTestRecord(arCount,arItems);
			boolean validNumericArray = validateNumericArray(arItems);

			if(validParsedCSVRecord && validNumericArray) {
				
				for (int arItr = 0; arItr < arCount; arItr++) {
					int arItem = Integer.parseInt(arItems[arItr].trim());
					ar[arItr] = arItem;
				}

				int result = simpleArraySum(ar);

				logger.debug("Result: " + result);

			}
		}

		logger.debug("** SimpleArrayNumUsingOpenCSVLibrary - END **");
	}

	/**
	 * Parse csv file using opencsv library
	 * @param csvFilename
	 * @return
	 * @throws FileNotFoundException
	 */
	private static CsvToBean<SimpleArrayNumCSVTestDataMapper> getOpenCSVObject(String csvFilename) throws FileNotFoundException {
		
		CsvToBean<SimpleArrayNumCSVTestDataMapper> openCsvObject = new CsvToBeanBuilder<SimpleArrayNumCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(SimpleArrayNumCSVTestDataMapper.class)
				.withIgnoreQuotations(true)
				.withThrowExceptions(false)
				.build();
		
		return openCsvObject;
	}
	
	/**
	 * Get list of only valid csv records
	 * @param beans
	 * @return list of valid parsed csv records
	 */
	public static List<SimpleArrayNumCSVTestDataMapper> getCsvValidRecord(CsvToBean<SimpleArrayNumCSVTestDataMapper> beans){
		
		final List<SimpleArrayNumCSVTestDataMapper> validProcessedReport = beans.parse();
		validProcessedReport.stream().forEach((user) -> {
			logger.info("Parsed data:" + user.toString());
		});
		
		return validProcessedReport;
	}
	
	/**
	 * Process only invalid CSV records
	 * @param beans
	 * @return list of invalid parsed csv records
	 */
	public static List<CsvException> getCsvInvalidRecord(CsvToBean<SimpleArrayNumCSVTestDataMapper> beans){
		
		List<CsvException> exceptions = beans.getCapturedExceptions();
		for (CsvException csvException : exceptions) {

			if(csvException instanceof CsvRequiredFieldEmptyException) {
				CsvRequiredFieldEmptyException out = (CsvRequiredFieldEmptyException)csvException;
				logger.error("Inconsistent data:" + out.toString());
				logger.error("Record error at line: " + out.getLineNumber());
			}
		}
		
		return exceptions;
	}
	
	/**
	 * Process valid and invalid csv record together
	 * @param csvFilename
	 * @return
	 * @throws FileNotFoundException
	 */
	private static List<SimpleArrayNumCSVTestDataMapper> processCSVRecords(String csvFilename) throws FileNotFoundException {
			
		CsvToBean<SimpleArrayNumCSVTestDataMapper> beans = new CsvToBeanBuilder<SimpleArrayNumCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(SimpleArrayNumCSVTestDataMapper.class)
				.withIgnoreQuotations(true)
				.withThrowExceptions(false)
				.build();

		final List<SimpleArrayNumCSVTestDataMapper> testCases = beans.parse();
		testCases.stream().forEach((user) -> {
			logger.info("Parsed data:" + user.toString());
		});
		

		List<CsvException> exceptions = beans.getCapturedExceptions();
		for (CsvException csvException : exceptions) {

			if(csvException instanceof CsvRequiredFieldEmptyException) {
				CsvRequiredFieldEmptyException out = (CsvRequiredFieldEmptyException)csvException;
				logger.error("Inconsistent data:" + out.toString());
				logger.error("Record error at line: " + out.getLineNumber());
			}
		}
		
		return testCases;
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
	private static boolean validateProcessedTestRecord(int arCount, String[] arItems) { 
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

	/**
	 * This method throws exceptions if vality check for test cases are not passed
	 * @param arCount : size must be integer > 0
	 * @param arItems : array that cointains data to sum
	 */
	private static void validateProcessedTestRecordWithExceptions(int arCount, String[] arItems) {

		if(arCount<=0) {
			throw new InvalidParameterException("The number of the array must be a positive number > 0");
		}

		if(arCount!=arItems.length) {
			throw new InvalidParameterException("The size of array and elements present into array have different size:"
					+ "size declared: " + arCount + " - arraySize: " + arItems.length
					);
		}

	}

	/**
	 * Get file from classpath, resources folder
	 * @param fileName
	 * @return
	 */
	private File getFileFromResources(String fileName) {

		ClassLoader classLoader = getClass().getClassLoader();

		URL resource = classLoader.getResource(fileName);
		if (resource == null) {
			throw new IllegalArgumentException("File is not found!");
		} else {
			return new File(resource.getFile());
		}

	}
}
