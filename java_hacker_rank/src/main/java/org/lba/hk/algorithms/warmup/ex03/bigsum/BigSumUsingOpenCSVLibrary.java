package org.lba.hk.algorithms.warmup.ex03.bigsum;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.lba.hk.util.ArrayValidationUtil;
import org.lba.hk.util.BasicJavaUtility;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class BigSumUsingOpenCSVLibrary {

	static final Logger logger = Logger.getLogger(BigSumUsingOpenCSVLibrary.class);

	private static final int MIN_INT_RANGE = 1;
	private static final int MAX_INT_RANGE = 10;
	private static final int ZERO= 0;
	
	// Complete the aVeryBigSum function below.
    static long aVeryBigSum(long[] ar) {
    	
    	long sum = 0;

		for(int i = 0; i < ar.length; i++){
			sum += ar[i];
		}

		return sum;
    }

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {

		logger.debug("** BigSumUsingOpenCSVLibrary - START **");
		/*1. Read file*/
		BigSumUsingOpenCSVLibrary simpleArrayNum3 = new BigSumUsingOpenCSVLibrary();
		File file = simpleArrayNum3.getFileFromResources("csv/data01/data-ex3.csv");
		String csvFilename =  file.getAbsolutePath();

		/*2. define the split char*/
		String splitChar = " ";

		/*3. process CSV records - valid and invalid csv record format*/
		CsvToBean<BigSumCSVTestDataMapper> openCsvObject = getOpenCSVObject(csvFilename);
		List<BigSumCSVTestDataMapper> testCases = getCsvValidRecord(openCsvObject);
		List<CsvException> invalidCsvRecords = getCsvInvalidRecord(openCsvObject);

		/*4. process only valid csv records*/
		for (BigSumCSVTestDataMapper currentTestRecord : testCases) {

			/*4.1 step executed for every test case inside csv file*/
			/*4.2 - validation-1*/
			logger.debug("TestCase: " + currentTestRecord.toString());
			/**/
			String arraySizeString = currentTestRecord.getArraySize();
			boolean validArraySize = BasicJavaUtility.isPositiveNumericIntegerInRange(arraySizeString,MIN_INT_RANGE, MAX_INT_RANGE);
			/**/
			String[] arrayElements = currentTestRecord.getArrayElements().split(splitChar); 
			boolean validNumericArray = ArrayValidationUtil.validatePositiveNumericArrayWithElementValueInRangeBigInteger(arrayElements,ZERO,Long.MAX_VALUE);
		
			if(validArraySize && validNumericArray) {
				
				long[] ar = new long[arrayElements.length];
				
				for (int arItr = 0; arItr < arrayElements.length; arItr++) {
					long arItem = Long.parseLong(arrayElements[arItr].trim());
					ar[arItr] = arItem;
				}

				long result = aVeryBigSum(ar);
				System.out.println("Result: " + result);
			}
		}

		logger.debug("** BigSumUsingOpenCSVLibrary - END **");
	}

	

	/**
	 * Parse csv file using opencsv library
	 * @param csvFilename
	 * @return
	 * @throws FileNotFoundException
	 */
	private static CsvToBean<BigSumCSVTestDataMapper> getOpenCSVObject(String csvFilename) throws FileNotFoundException {

		CsvToBean<BigSumCSVTestDataMapper> openCsvObject = new CsvToBeanBuilder<BigSumCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(BigSumCSVTestDataMapper.class)
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
	public static List<BigSumCSVTestDataMapper> getCsvValidRecord(CsvToBean<BigSumCSVTestDataMapper> beans){

		final List<BigSumCSVTestDataMapper> validProcessedReport = beans.parse();
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
	public static List<CsvException> getCsvInvalidRecord(CsvToBean<BigSumCSVTestDataMapper> beans){

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
	private static List<BigSumCSVTestDataMapper> processCSVRecords(String csvFilename) throws FileNotFoundException {

		CsvToBean<BigSumCSVTestDataMapper> beans = new CsvToBeanBuilder<BigSumCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(BigSumCSVTestDataMapper.class)
				.withIgnoreQuotations(true)
				.withThrowExceptions(false)
				.build();

		final List<BigSumCSVTestDataMapper> testCases = beans.parse();
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
