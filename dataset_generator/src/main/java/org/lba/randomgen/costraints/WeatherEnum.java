package org.lba.randomgen.costraints;

import java.util.HashMap;
import java.util.Map;

public enum WeatherEnum {

	SUNNY("SUNNY",1),
	RAINY("RAINY",2),
	SNOWY("SNOWY",3),
	WINDY("	WINDY",4),
	//
	CLOUDY("CLOUDY",5),
	PARTLY_CLOUDY("PARTLY_CLOUDY",6),
	SLEETING("SLEETING",7),
	STORMY("STORMY",8),
	HAILING("HAILING",9), 
	FOGGY("FOGGY",10), 
	INVALID_VALUE("INVALID_VALUE",-1)
	;

	/**/
	private static final Map<String, WeatherEnum> BY_FIELD = new HashMap<>();
	private static final Map<Integer, WeatherEnum> BY_NUMBER = new HashMap<>();

	static {
		for (WeatherEnum e : values()) {
			BY_FIELD.put(e.value, e);
			BY_NUMBER.put(e.number, e);
		}
	}

	public static WeatherEnum valueOfField(String label) {
		return BY_FIELD.get(label);
	}

	public static WeatherEnum valueOfNumber(int number) {
		return BY_NUMBER.get(number);
	}
	/**/

	private String value;
	private int number;

	WeatherEnum(String value,int num) {
		this.value = value;
		this.number = num;
	}

	public String getValue() {
		return value;
	}

	public int getNumber() {
		return number;
	}

	public static WeatherEnum getFromEnumStringValue(String value) {

		WeatherEnum result = WeatherEnum.INVALID_VALUE;

		for (WeatherEnum d: WeatherEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}

		return result;
	}

	public static WeatherEnum getFromEnumIntValue(int value) {

		WeatherEnum result = WeatherEnum.INVALID_VALUE;

		for (WeatherEnum d: WeatherEnum.values()) {
			if(value == d.getNumber() ) {
				result = d;
			}
		}

		return result;
	}

	public static WeatherEnum getFromEnumKey(String sampleEnumKey) {
		WeatherEnum result = WeatherEnum.INVALID_VALUE;

		for (WeatherEnum d: WeatherEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = WeatherEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}

		return result;
	}
}
