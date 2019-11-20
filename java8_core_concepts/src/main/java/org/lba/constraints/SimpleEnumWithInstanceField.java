package org.lba.constraints;

public enum SimpleEnumWithInstanceField {

	MONDAY("MONDAY_VALUE"),
	TUESDAY("TUESDAY_VALUE"),
	WEDNESDAY("WEDNESDAY_VALUE"),
	THURSDAY("THURSDAY_VALUE"),
	FRIDAY("FRIDAY_VALUE"),
	SATURDAY("SATURDAY_VALUE"),
	SUNDAY("SUNDAY_VALUE"),
	INVALID_VALUE("INVALID_VALUE")
	;

	private String field;

	SimpleEnumWithInstanceField(String field) {
		this.field = field;
	}

	public String field() {
		return field;
	}
	
	public static SimpleEnumWithInstanceField getFromEnumValue(String value) {
		
		SimpleEnumWithInstanceField result = SimpleEnumWithInstanceField.INVALID_VALUE;
		
		for (SimpleEnumWithInstanceField d: SimpleEnumWithInstanceField.values()) {
			if(value.equalsIgnoreCase(d.field()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static SimpleEnumWithInstanceField getFromEnumKey(String sampleEnumKey) {
	SimpleEnumWithInstanceField result = SimpleEnumWithInstanceField.INVALID_VALUE;
		
		for (SimpleEnumWithInstanceField d: SimpleEnumWithInstanceField.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = SimpleEnumWithInstanceField.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
