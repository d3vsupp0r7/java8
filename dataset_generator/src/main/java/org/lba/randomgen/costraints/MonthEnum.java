package org.lba.randomgen.costraints;

import java.util.HashMap;
import java.util.Map;

public enum MonthEnum {

	JANUARY("JANUARY",1),
	FEBRUARY("FEBRUARY",2),
	MARCH("MARCH",3),
	APRIL("APRIL",4),
	MAY("MAY",5),
	JUNE("JUNE",6),
	JULY("JULY",7), 
	AUGUST("AUGUST",8), 
	SEPTEMBER("SEPTEMBER",9), 
	OCTOBER("OCTOBER",10), 
	NOVEMBER("NOVEMBER",11), 
	DECEMBER("DECEMBER",12), 
	INVALID_VALUE("INVALID_VALUE",-1)
	;

	/**/
	private static final Map<String, MonthEnum> BY_FIELD = new HashMap<>();
	private static final Map<Integer, MonthEnum> BY_NUMBER = new HashMap<>();

	static {
		for (MonthEnum e : values()) {
			BY_FIELD.put(e.value, e);
			BY_NUMBER.put(e.number, e);
		}
	}

	public static MonthEnum valueOfField(String label) {
		return BY_FIELD.get(label);
	}

	public static MonthEnum valueOfNumber(int number) {
		return BY_NUMBER.get(number);
	}
	/**/

	private String value;
	private int number;

	MonthEnum(String value,int num) {
		this.value = value;
		this.number = num;
	}

	public String getValue() {
		return value;
	}

	public int getNumber() {
		return number;
	}

	public static MonthEnum getFromEnumStringValue(String value) {

		MonthEnum result = MonthEnum.INVALID_VALUE;

		for (MonthEnum d: MonthEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}

		return result;
	}

	public static MonthEnum getFromEnumIntValue(int value) {

		MonthEnum result = MonthEnum.INVALID_VALUE;

		for (MonthEnum d: MonthEnum.values()) {
			if(value == d.getNumber() ) {
				result = d;
			}
		}

		return result;
	}

	public static MonthEnum getFromEnumKey(String sampleEnumKey) {
		MonthEnum result = MonthEnum.INVALID_VALUE;

		for (MonthEnum d: MonthEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = MonthEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}

		return result;
	}
}
