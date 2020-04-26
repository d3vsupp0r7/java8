package org.lba.hk.algorithms.warmup.ex02.comparetriplets;

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

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CompareTripletsUsingOpenCSVLibrary {

	static final Logger logger = Logger.getLogger(CompareTripletsUsingOpenCSVLibrary.class);

	private static final int MIN_INT_RANGE = 1;
	private static final int MAX_INT_RANGE = 100;
	
	/**
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

		List<Integer> result = new ArrayList<>();
		int aPoint = 0;
		int bPoint = 0;
		/**/
		if(a.size()-b.size()==0) {
			for(int i = 0; i < a.size(); i++) {
			
				if(a.get(i)>b.get(i)) {
					aPoint++;
				}else if(a.get(i)<b.get(i)) {
					bPoint++;
				}
			}
		}
		result.add(aPoint);
		result.add(bPoint);
		/**/
		return result;
	}

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static void main(String[] args) throws IOException, URISyntaxException {

		logger.debug("** CompareTripletsUsingOpenCSVLibrary - START **");
		/*1. Read file*/
		CompareTripletsUsingOpenCSVLibrary simpleArrayNum3 = new CompareTripletsUsingOpenCSVLibrary();
		File file = simpleArrayNum3.getFileFromResources("csv/data01/data-ex2.csv");
		String csvFilename =  file.getAbsolutePath();
		if(csvFilename.contains("%20")) {
			csvFilename = csvFilename.replaceAll("%20", " ");
		}

		/*2. define the split char*/
		String splitChar = " ";

		/*3. process CSV records - valid and invalid csv record format*/
		CsvToBean<CompareTripletsCSVTestDataMapper> openCsvObject = getOpenCSVObject(csvFilename);
		List<CompareTripletsCSVTestDataMapper> testCases = getCsvValidRecord(openCsvObject);
		List<CsvException> invalidCsvRecords = getCsvInvalidRecord(openCsvObject);

		/*4. process only valid csv records*/
		for (CompareTripletsCSVTestDataMapper currentTestRecord : testCases) {

			/*4.1 step executed for every test case inside csv file*/
			/*4.2 - validation-1*/
			logger.debug("TestCase: " + currentTestRecord.toString());
			/**/
			String aliceItemsTestCase = currentTestRecord.getAliceArray();
			String[] aliceItems = aliceItemsTestCase.split(splitChar); 
			boolean aliceValidNumericArray = ArrayValidationUtil.validatePositiveNumericArrayWithElementValueInRange(aliceItems,MIN_INT_RANGE,MAX_INT_RANGE);
			/*4.2 - validation-2*/
			String bobItemsTestCase = currentTestRecord.getBobArray();
			String[] bobItems = bobItemsTestCase.split(splitChar); 
			boolean bobValidNumericArray = ArrayValidationUtil.validatePositiveNumericArrayWithElementValueInRange(bobItems,MIN_INT_RANGE,MAX_INT_RANGE);
			/*4.2 - validation-3*/
			boolean validSameArraySize = ArrayValidationUtil.validateSameArrayDimensions(aliceItems, bobItems);

			/*4.3 Integer array parsing*/
			List<Integer> a = parseStringArrayToIntArray(aliceItems);
			List<Integer> b = parseStringArrayToIntArray(bobItems);

			if(aliceValidNumericArray && bobValidNumericArray && validSameArraySize) {
				/**/
				List<Integer> result = compareTriplets(a,b);
				logger.debug("Result: " + result.toString());
				/**/
			}
		}

		logger.debug("** CompareTripletsUsingOpenCSVLibrary - END **");
	}

	private static List<Integer> parseStringArrayToIntArray(String[] arrayToConvert) {
		List<Integer> result = new ArrayList<>();

		for (int i = 0; i < arrayToConvert.length; i++) {
			int aItem = Integer.parseInt(arrayToConvert[i]);
			result.add(aItem);
		}

		return result;
	}

	/**
	 * Parse csv file using opencsv library
	 * @param csvFilename
	 * @return
	 * @throws FileNotFoundException
	 */
	private static CsvToBean<CompareTripletsCSVTestDataMapper> getOpenCSVObject(String csvFilename) throws FileNotFoundException {

		CsvToBean<CompareTripletsCSVTestDataMapper> openCsvObject = new CsvToBeanBuilder<CompareTripletsCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(CompareTripletsCSVTestDataMapper.class)
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
	public static List<CompareTripletsCSVTestDataMapper> getCsvValidRecord(CsvToBean<CompareTripletsCSVTestDataMapper> beans){

		final List<CompareTripletsCSVTestDataMapper> validProcessedReport = beans.parse();
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
	public static List<CsvException> getCsvInvalidRecord(CsvToBean<CompareTripletsCSVTestDataMapper> beans){

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
	private static List<CompareTripletsCSVTestDataMapper> processCSVRecords(String csvFilename) throws FileNotFoundException {

		CsvToBean<CompareTripletsCSVTestDataMapper> beans = new CsvToBeanBuilder<CompareTripletsCSVTestDataMapper>(new FileReader(csvFilename))
				.withType(CompareTripletsCSVTestDataMapper.class)
				.withIgnoreQuotations(true)
				.withThrowExceptions(false)
				.build();

		final List<CompareTripletsCSVTestDataMapper> testCases = beans.parse();
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
