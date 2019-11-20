package org.lba.randomgen.config.costraints;

public enum DayConfigEnum {

	DAYS_ANNUAL("days_annual"),
	DAYS_LEAP_YEAR("days_leap_year"),
	DAYS_INTO_3_MONTH("days_into_3_month"),
	DAYS_INTO_3_MONTH_LEAP_YEAR("days_into_3_month_leap_year"),
	DAYS_INTO_6_MONTH("days_into_6_month"),
	DAYS_INTO_6_MONTH_LEAP_YEAR("days_into_6_month_leap_year"),
	DAYS_INTO_9_MONTH("days_into_9_month"),
	DAYS_INTO_9_MONTH_LEAP_YEAR("days_into_9_month_leap_year"),
	DAY_WITH_WEIGHT("day_with_weight"),
	DAYS_LABEL("days_label"),
	DAYS_NUMBER("days_number"),
	DAY_OF_WEEK("day_of_week"),
	MONDAY_WEIGHT("monday_weight"),
	TUESDAY_WEIGHT("tuesday_weight"),
	WEDNESDAY_WEIGHT("wednesday_weight"),
	THURSDAY_WEIGHT("thursday_weight"),
	FRIDAY_WEIGHT("friday_weight"),
	SATURDAY_WEIGHT("saturday_weight"),
	SUNDAY_WEIGHT("sunday_weight"),
	INVALID_VALUE("invalid_value")
	;
	
	private String value;

	DayConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static DayConfigEnum getFromEnumValue(String value) {
		
		DayConfigEnum result = DayConfigEnum.INVALID_VALUE;
		
		for (DayConfigEnum d: DayConfigEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static DayConfigEnum getFromEnumKey(String sampleEnumKey) {
		DayConfigEnum result = DayConfigEnum.INVALID_VALUE;
		
		for (DayConfigEnum d: DayConfigEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = DayConfigEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
