package org.lba.sample.opencsv.csv2bean.ex1.tests;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class OpenCSVReadTests {

	static final Logger logger = Logger.getLogger(OpenCSVReadTests.class);

	@Test
	public void test_simple_CSV_readAllDataWellFormatted() {

		logger.info("test_simple_CSV_readAllDataWellFormatted - START");
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("csv/data01/data-ex1.csv").getFile());
		assertTrue(file.exists());
		
		String csvFilename =  file.getAbsolutePath();
		try {
			List<TestBeanCSVMapper> csvObjectsList = new CsvToBeanBuilder(new FileReader(csvFilename))
					.withType(TestBeanCSVMapper.class).build().parse();
			// print details of Bean object 
			for (TestBeanCSVMapper e : csvObjectsList) { 
				logger.debug(e); 
			} 
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		logger.info("test_simple_CSV_readAllDataWellFormatted - END");
	}

	@Test
	public void test_simple_CSV_readOnlySomeData() {

		logger.info("test_simple_CSV_readOnlySomeData - START");
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("csv/data01/data-ex1.2.csv").getFile());
		assertTrue(file.exists());
		String csvFilename =  file.getAbsolutePath();
		try {
			List<TestBeanCSVMapper> beans = new CsvToBeanBuilder(new FileReader(csvFilename))
					.withType(TestBeanCSVMapper.class).build().parse();
			// print details of Bean object 
			for (TestBeanCSVMapper e : beans) { 
				System.out.println(e); 
			} 
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		logger.info("test_simple_CSV_readOnlySomeData - END");
	}

	@Test
	public void test_simple_CSV_read_CorruptedCSVDataFormat() {

		logger.info("test_simple_CSV_read_CorruptedCSVDataFormat - START");
		
		ClassLoader classLoader = this.getClass().getClassLoader();
		File file = new File(classLoader.getResource("csv/data01/data-ex1.3.csv").getFile());
		assertTrue(file.exists());
		String csvFilename =  file.getAbsolutePath();
		
		try {
			CsvToBean beans = new CsvToBeanBuilder(new FileReader(csvFilename))
					.withType(TestBeanCSVMapper.class)
					.withIgnoreQuotations(true)
					.withThrowExceptions(false)
					.build();

			final List<TestBeanCSVMapper> users = beans.parse();//2
			users.stream().forEach((user) -> {
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

			// print details of Bean object 
			for (TestBeanCSVMapper e : users) { 
				System.out.println(e); 
			} 
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		logger.info("test_simple_CSV_read_CorruptedCSVDataFormat - END");
	}
}
