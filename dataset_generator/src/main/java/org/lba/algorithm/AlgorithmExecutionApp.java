package org.lba.algorithm;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.lba.randomgen.business.ClassificationRatioAlgorithm;
import org.lba.randomgen.business.PatientAlgorithm;
import org.lba.randomgen.business.WeatherAlgorithm;
import org.lba.randomgen.business.store.StoreMqAlgorithm;
import org.lba.randomgen.business.store.StoreTerminalAlgorithm;
import org.lba.randomgen.config.costraints.BusinessConfigEnum;
import org.lba.randomgen.config.costraints.DayConfigEnum;
import org.lba.randomgen.config.costraints.GeneratorConfigEnum;
import org.lba.randomgen.config.costraints.WeekConfigEnum;
import org.lba.randomgen.csv.generator.CSVPrinter;
import org.lba.randomgen.date.WeekAlgorithm;
import org.lba.randomgen.util.PropertyReaderSingleton;

public class AlgorithmExecutionApp {

	static final Logger logger = Logger.getLogger(AlgorithmExecutionApp.class);
	
	public static void main(String[] args) {

		try {

			int yearsStatisticAnalisysPeriod = Integer.parseInt(PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.YEARS.getValue()) );
			
			//Headers
			String headers[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(GeneratorConfigEnum.GENERATOR_HEADERS.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			//Weeks
			String week[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(WeekConfigEnum.WEEKS_YEARS_AS_LIST.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			//Day		
			String dayNumber[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(DayConfigEnum.DAYS_NUMBER.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );

			//Data population examples
			String timeSlot[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(BusinessConfigEnum.WEATHER_TIME_SLOTS.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			
			String teminals[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(BusinessConfigEnum.STORE_ACTIVE_TEMINALS.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			
			String mqs[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(BusinessConfigEnum.STORE_MQS.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			
			String patients[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(BusinessConfigEnum.ACTIVE_PATIENTS.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );
			
			String weather[] = PropertyReaderSingleton.getInstance().getTokenizedPropertyAsStringArray(BusinessConfigEnum.WEATHER.getValue(),
					PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.WEIGHT_SEPARATOR.getValue()) );


			StringBuilder builderH = new StringBuilder();

			DateTime dateTime = DateTime.now();
			String pattern = PropertyReaderSingleton.getInstance().getProperty(GeneratorConfigEnum.DATE_PATTERN_FULL.getValue());
			String result = dateTime.toString(pattern);
			logger.debug("Result: " + result);

			//
			String[] parts = result.split(" ");
			String dateFile = parts[0];
			String timeFile = parts[1].replace(":", "_");
			logger.debug("Date: " + dateFile);
			logger.debug("Time: " + timeFile);

			String dateExecution =  "D_"+dateFile + "_H_"+timeFile;

			logger.debug("Date: " + dateTime.toString());

			File fout = new File("dataset_"+"Y_"+yearsStatisticAnalisysPeriod+"_timeslot"+"_record_"+dateExecution+".csv");
			File foutRatio = new File("dataset_ratio_"+"Y_"+yearsStatisticAnalisysPeriod+"_timeslot"+"_record_"+dateExecution+".csv");
			/**/
			FileOutputStream fos = new FileOutputStream(fout);
			FileOutputStream fosRatio = new FileOutputStream(foutRatio);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			BufferedWriter bwRatio = new BufferedWriter(new OutputStreamWriter(fosRatio));

			String headerCsv = CSVPrinter.buildHeader(headers, builderH);
			/**/
			bw.write(headerCsv);
			bw.newLine();

			bwRatio.write(headerCsv);
			bwRatio.newLine();
			//DBG: logger.debug(headerCsv);

			for(int yearIndex = 0; yearIndex < yearsStatisticAnalisysPeriod; yearIndex++) {

				for(int i = 0; i < week.length; i++) {

					double weekWeight = WeekAlgorithm.weekWeigth(Integer.parseInt(week[i]) );
					
					for(int dayIndex = 0; dayIndex <= 6; dayIndex++) {

						for(int timeSlotIndex = 0; timeSlotIndex < timeSlot.length ; timeSlotIndex++) {
							String[] resultFileWrite = datasetAlghoritm(weekWeight, dayNumber, timeSlot,timeSlotIndex, teminals, mqs, patients, weather, Integer.parseInt(week[i]),
									dayIndex);


							bw.write(resultFileWrite[0]);
							bw.newLine();
							//
							bwRatio.write(resultFileWrite[1]);
							bwRatio.newLine();
						}
					}//end day


				}//end week

			}

			bw.close();
			bwRatio.close();

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String[] datasetAlghoritm(double weekWeight, String[] dayNumber, String[] timeSlot, int timeSlotIndex, String[] teminals,
			String[] mqs, String[] patients, String[] weather, int weekNumber, int dayIndex) {

		String resultCalculation[] = new String[2];

		int dayNumberPicked = Integer.parseInt(dayNumber[dayIndex]);
		double dayWeight = 0;
		String patientsCsv = "";
		String terminalsCsv ="";
		String timeSlotPicked ="";
		String mqsCsv = "";
		String classRatio ="";
		int ratio = 0;
		String weatherCsv="";
		double weatherWeigth=0;
		double resultRatio = 0;

		StringBuffer buffer = new StringBuffer();
		switch (dayIndex) {

		case 5:
			dayWeight = 0.75;
			patientsCsv = PatientAlgorithm.buildPatients(patients);
			terminalsCsv = StoreTerminalAlgorithm.buildTerminals(teminals);
			timeSlotPicked = timeSlot[timeSlotIndex];
			mqsCsv = StoreMqAlgorithm.buildMq(mqs);
			ratio =  Integer.parseInt(patientsCsv)/Integer.parseInt(terminalsCsv);
			weatherCsv = WeatherAlgorithm.buildWeather(weather);
			weatherWeigth = WeatherAlgorithm.getWeatherWeigth(WeatherAlgorithm.buildWeather(weather));

			resultRatio = ratio * weekWeight * dayWeight * weatherWeigth;
			logger.debug("RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio);
			classRatio = ClassificationRatioAlgorithm.generateClassByRation(resultRatio).toString(); 
			//
			buffer.append(weekNumber+","+
					dayNumberPicked+","+
					timeSlotPicked+","+
					terminalsCsv+","+
					mqsCsv+","+
					patientsCsv+","+
					weatherCsv+","+
					classRatio);

			resultCalculation[0] = buffer.toString();
			resultCalculation[1] = "RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio;

			return resultCalculation;
		case 6:
			dayWeight = 0.50;
			patientsCsv = PatientAlgorithm.buildPatients(patients);
			terminalsCsv = StoreTerminalAlgorithm.buildTerminals(teminals);
			timeSlotPicked = timeSlot[timeSlotIndex];
			mqsCsv = StoreMqAlgorithm.buildMq(mqs);
			ratio =  Integer.parseInt(patientsCsv)/Integer.parseInt(terminalsCsv);
			weatherCsv = WeatherAlgorithm.buildWeather(weather);
			weatherWeigth = WeatherAlgorithm.getWeatherWeigth(WeatherAlgorithm.buildWeather(weather));

			resultRatio = ratio * weekWeight * dayWeight * weatherWeigth;
			logger.debug("RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio);
			classRatio = ClassificationRatioAlgorithm.generateClassByRation(resultRatio).toString(); 
			//
			buffer.append(weekNumber+","+
					dayNumberPicked+","+
					timeSlotPicked+","+
					terminalsCsv+","+
					mqsCsv+","+
					patientsCsv+","+
					weatherCsv+","+
					classRatio);

			resultCalculation[0] = buffer.toString();
			resultCalculation[1] = "RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio;

			return resultCalculation;

		default:
			dayWeight = 1;
			patientsCsv = PatientAlgorithm.buildPatients(patients);
			terminalsCsv = StoreTerminalAlgorithm.buildTerminals(teminals);
			timeSlotPicked = timeSlot[timeSlotIndex];
			mqsCsv = StoreMqAlgorithm.buildMq(mqs);
			ratio =  Integer.parseInt(patientsCsv)/Integer.parseInt(terminalsCsv);
			weatherCsv = WeatherAlgorithm.buildWeather(weather);
			weatherWeigth = WeatherAlgorithm.getWeatherWeigth(WeatherAlgorithm.buildWeather(weather));

			resultRatio = ratio * weekWeight * dayWeight * weatherWeigth;
			logger.debug("RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio);
			classRatio = ClassificationRatioAlgorithm.generateClassByRation(resultRatio).toString(); 
			//

			buffer.append(weekNumber+","+
					dayNumberPicked+","+
					timeSlotPicked+","+
					terminalsCsv+","+
					mqsCsv+","+
					patientsCsv+","+
					weatherCsv+","+
					classRatio);

			resultCalculation[0] = buffer.toString();
			resultCalculation[1] = "RatioResult[weekNumber:"+weekNumber+",day:"+dayNumberPicked+"]=" + resultRatio;

			return resultCalculation;

		}//end day switch
	}

	

}
