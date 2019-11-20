package org.lba.randomgen.business;

import org.lba.randomgen.csv.generator.RandomGeneratorAlgorithm;

public class WeatherAlgorithm {

	public static String buildWeather(String[] weather) {
		int weatherIndex = RandomGeneratorAlgorithm.getRandomNumberInRange(0, weather.length-1);
		String weatherCsv = weather[weatherIndex];
		return weatherCsv;
	}
	
	public static double getWeatherWeigth(String weather) {

			if(weather.equals("sunny")) {
				return 1;
			}else if(weather.equals("windy")) {
				return 0.75;
			}else if(weather.equals("snowy")) {
				return 0.25;
			}else {
				return 0.50;
			}
		
	}
}
