package org.lba.randomgen.config.costraints;

public enum MonthConfigEnum {

	MONTHS_WITH_WEIGHT("months_with_weight"),
	JANUARY_WEIGHT("january_weight"),
	FEBRUARY_WEIGHT("february_weight"),
	MARCH_WEIGHT("march_weight"),
	APRIL_WEIGHT("april_weight"),
	MAY_WEIGHT("may_weight"),
	JUNE_WEIGHT("june_weight"),
	JULY_WEIGHT("july_weight"),
	AUGUST_WEIGHT("august_weight"),
	SEPTEMBER_WEIGHT("september_weight"),
	OCTOBER_WEIGHT("october_weight"),
	NOVEMBER_WEIGHT("november_weight"),
	DECEMBER_WEIGHT("december_weight"),
	INVALID_VALUE("INVALID_VALUE")
	;
	
	private String value;

	MonthConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static MonthConfigEnum getFromEnumValue(String value) {
		
		MonthConfigEnum result = MonthConfigEnum.INVALID_VALUE;
		
		for (MonthConfigEnum d: MonthConfigEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static MonthConfigEnum getFromEnumKey(String sampleEnumKey) {
		MonthConfigEnum result = MonthConfigEnum.INVALID_VALUE;
		
		for (MonthConfigEnum d: MonthConfigEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = MonthConfigEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
