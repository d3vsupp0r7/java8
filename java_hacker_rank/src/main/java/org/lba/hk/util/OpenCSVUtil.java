//package org.lba.hk.util;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.net.URISyntaxException;
//import java.net.URL;
//import java.util.List;
//
//import org.apache.log4j.Logger;
//
//import com.opencsv.bean.CsvToBean;
//import com.opencsv.bean.CsvToBeanBuilder;
//import com.opencsv.exceptions.CsvException;
//import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
//
//public class OpenCSVUtil {
//
//	static final Logger logger = Logger.getLogger(OpenCSVUtil.class);
//
//	public static void main(String[] args) throws IOException, URISyntaxException {
//
//		logger.debug("** OpenCSVUtil - START **");
//		/*1. Read file*/
//		OpenCSVUtil simpleArrayNum3 = new OpenCSVUtil();
//		File file = simpleArrayNum3.getFileFromResources("csv/data01/data-ex2.csv");
//		String csvFilename =  file.getAbsolutePath();
//		
//		/*2. define the split char*/
//		String splitChar = " ";
//
//		/*3. process CSV records - valid and invalid csv record format*/
//		CsvToBean<CompareTripletsCSVTestDataMapper> openCsvObject = getOpenCSVObject(csvFilename);
//		List<CompareTripletsCSVTestDataMapper> testCases = getCsvValidRecord(openCsvObject);
//		List<CsvException> invalidCsvRecords = getCsvInvalidRecord(openCsvObject);
//		
//		/*4. process only valid csv records*/
//		for (CompareTripletsCSVTestDataMapper currentTestRecord : testCases) {
//
//			/*4.1 step executed for every test case inside csv file*/
//			/**/
//		}
//
//		logger.debug("** SimpleArrayNumUsingOpenCSVLibrary - END **");
//	}
//
//	/**
//	 * Parse csv file using opencsv library
//	 * @param csvFilename
//	 * @return
//	 * @throws FileNotFoundException
//	 */
//	private static CsvToBean<CompareTripletsCSVTestDataMapper> getOpenCSVObject(String csvFilename) throws FileNotFoundException {
//		
//		CsvToBean<CompareTripletsCSVTestDataMapper> openCsvObject = new CsvToBeanBuilder<CompareTripletsCSVTestDataMapper>(new FileReader(csvFilename))
//				.withType(CompareTripletsCSVTestDataMapper.class)
//				.withIgnoreQuotations(true)
//				.withThrowExceptions(false)
//				.build();
//		
//		return openCsvObject;
//	}
//	
//	/**
//	 * Get list of only valid csv records
//	 * @param beans
//	 * @return list of valid parsed csv records
//	 */
//	public static List<CompareTripletsCSVTestDataMapper> getCsvValidRecord(CsvToBean<CompareTripletsCSVTestDataMapper> beans){
//		
//		final List<CompareTripletsCSVTestDataMapper> validProcessedReport = beans.parse();
//		validProcessedReport.stream().forEach((user) -> {
//			logger.info("Parsed data:" + user.toString());
//		});
//		
//		return validProcessedReport;
//	}
//	
//	/**
//	 * Process only invalid CSV records
//	 * @param beans
//	 * @return list of invalid parsed csv records
//	 */
//	public static List<CsvException> getCsvInvalidRecord(CsvToBean<CompareTripletsCSVTestDataMapper> beans){
//		
//		List<CsvException> exceptions = beans.getCapturedExceptions();
//		for (CsvException csvException : exceptions) {
//
//			if(csvException instanceof CsvRequiredFieldEmptyException) {
//				CsvRequiredFieldEmptyException out = (CsvRequiredFieldEmptyException)csvException;
//				logger.error("Inconsistent data:" + out.toString());
//				logger.error("Record error at line: " + out.getLineNumber());
//			}
//		}
//		
//		return exceptions;
//	}
//	
//	/**
//	 * Process valid and invalid csv record together
//	 * @param csvFilename
//	 * @return
//	 * @throws FileNotFoundException
//	 */
//	private static List<CompareTripletsCSVTestDataMapper> processCSVRecords(String csvFilename) throws FileNotFoundException {
//			
//		CsvToBean<CompareTripletsCSVTestDataMapper> beans = new CsvToBeanBuilder<CompareTripletsCSVTestDataMapper>(new FileReader(csvFilename))
//				.withType(CompareTripletsCSVTestDataMapper.class)
//				.withIgnoreQuotations(true)
//				.withThrowExceptions(false)
//				.build();
//
//		final List<CompareTripletsCSVTestDataMapper> testCases = beans.parse();
//		testCases.stream().forEach((user) -> {
//			logger.info("Parsed data:" + user.toString());
//		});
//		
//
//		List<CsvException> exceptions = beans.getCapturedExceptions();
//		for (CsvException csvException : exceptions) {
//
//			if(csvException instanceof CsvRequiredFieldEmptyException) {
//				CsvRequiredFieldEmptyException out = (CsvRequiredFieldEmptyException)csvException;
//				logger.error("Inconsistent data:" + out.toString());
//				logger.error("Record error at line: " + out.getLineNumber());
//			}
//		}
//		
//		return testCases;
//	}
//
//	
//	/**
//	 * Get file from classpath, resources folder
//	 * @param fileName
//	 * @return
//	 */
//	private File getFileFromResources(String fileName) {
//
//		ClassLoader classLoader = getClass().getClassLoader();
//
//		URL resource = classLoader.getResource(fileName);
//		if (resource == null) {
//			throw new IllegalArgumentException("File is not found!");
//		} else {
//			return new File(resource.getFile());
//		}
//
//	}
//}
