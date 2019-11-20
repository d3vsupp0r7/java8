package org.lba.constraints;

import java.util.HashMap;
import java.util.Map;

public enum SimpleEnumWithMultipleInstanceField {

	MONDAY("MONDAY_VALUE",1),
	TUESDAY("TUESDAY_VALUE",2),
	WEDNESDAY("WEDNESDAY_VALUE",3),
	THURSDAY("THURSDAY_VALUE",4),
	FRIDAY("FRIDAY_VALUE",5),
	SATURDAY("SATURDAY_VALUE",6),
	SUNDAY("SUNDAY_VALUE",7),
	INVALID_VALUE("INVALID_VALUE",-1)
	;

	/**/
	private static final Map<String, SimpleEnumWithMultipleInstanceField> BY_FIELD = new HashMap<>();
	private static final Map<Integer, SimpleEnumWithMultipleInstanceField> BY_NUMBER = new HashMap<>();

	static {
		for (SimpleEnumWithMultipleInstanceField e : values()) {
			BY_FIELD.put(e.field, e);
			BY_NUMBER.put(e.number, e);
		}
	}

	public static SimpleEnumWithMultipleInstanceField valueOfField(String label) {
		return BY_FIELD.get(label);
	}

	public static SimpleEnumWithMultipleInstanceField valueOfNumber(int number) {
		return BY_NUMBER.get(number);
	}
	/**/

	private String field;
	private int number;

	SimpleEnumWithMultipleInstanceField(String field,int num) {
		this.field = field;
		this.number = num;
	}

	public String field() {
		return field;
	}

	public int getNumber() {
		return number;
	}

	public static SimpleEnumWithMultipleInstanceField getFromEnumStringValue(String value) {

		SimpleEnumWithMultipleInstanceField result = SimpleEnumWithMultipleInstanceField.INVALID_VALUE;

		for (SimpleEnumWithMultipleInstanceField d: SimpleEnumWithMultipleInstanceField.values()) {
			if(value.equalsIgnoreCase(d.field()) ) {
				result = d;
			}
		}

		return result;
	}

	public static SimpleEnumWithMultipleInstanceField getFromEnumIntValue(int value) {

		SimpleEnumWithMultipleInstanceField result = SimpleEnumWithMultipleInstanceField.INVALID_VALUE;

		for (SimpleEnumWithMultipleInstanceField d: SimpleEnumWithMultipleInstanceField.values()) {
			if(value == d.getNumber() ) {
				result = d;
			}
		}

		return result;
	}

	public static SimpleEnumWithMultipleInstanceField getFromEnumKey(String sampleEnumKey) {
		SimpleEnumWithMultipleInstanceField result = SimpleEnumWithMultipleInstanceField.INVALID_VALUE;

		for (SimpleEnumWithMultipleInstanceField d: SimpleEnumWithMultipleInstanceField.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = SimpleEnumWithMultipleInstanceField.valueOf(sampleEnumKey.toUpperCase());
			}
		}

		return result;
	}

}
