package org.lba.randomgen.costraints;

import java.util.HashMap;
import java.util.Map;

public enum DayEnum {

	MONDAY("MONDAY",1),
	TUESDAY("TUESDAY",2),
	WEDNESDAY("WEDNESDAY",3),
	THURSDAY("THURSDAY",4),
	FRIDAY("FRIDAY",5),
	SATURDAY("SATURDAY",6),
	SUNDAY("SUNDAY",7), 
	INVALID_VALUE("INVALID_VALUE",-1)
	;

	/**/
	private static final Map<String, DayEnum> BY_FIELD = new HashMap<>();
	private static final Map<Integer, DayEnum> BY_NUMBER = new HashMap<>();

	static {
		for (DayEnum e : values()) {
			BY_FIELD.put(e.value, e);
			BY_NUMBER.put(e.number, e);
		}
	}

	public static DayEnum valueOfField(String label) {
		return BY_FIELD.get(label);
	}

	public static DayEnum valueOfNumber(int number) {
		return BY_NUMBER.get(number);
	}
	/**/

	private String value;
	private int number;

	DayEnum(String value,int num) {
		this.value = value;
		this.number = num;
	}

	public String getValue() {
		return value;
	}

	public int getNumber() {
		return number;
	}

	public static DayEnum getFromEnumStringValue(String value) {

		DayEnum result = DayEnum.INVALID_VALUE;

		for (DayEnum d: DayEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}

		return result;
	}

	public static DayEnum getFromEnumIntValue(int value) {

		DayEnum result = DayEnum.INVALID_VALUE;

		for (DayEnum d: DayEnum.values()) {
			if(value == d.getNumber() ) {
				result = d;
			}
		}

		return result;
	}

	public static DayEnum getFromEnumKey(String sampleEnumKey) {
		DayEnum result = DayEnum.INVALID_VALUE;

		for (DayEnum d: DayEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = DayEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}

		return result;
	}
}
