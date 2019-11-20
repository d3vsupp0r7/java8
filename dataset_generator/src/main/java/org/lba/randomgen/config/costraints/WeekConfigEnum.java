package org.lba.randomgen.config.costraints;

public enum WeekConfigEnum {

	WEEKS_YEARS_AS_LIST("weeks_years_as_list"),
	YEAR_WEEKS("year_weeks"),
	THREE_MONTH_WEEKS("3_month_weeks"),
	SIX_MONTH_WEEKS("6_month_weeks"),
	NINE_MONTH_WEEKS("9_month_weeks"),
	THREE_MONTH_WEEKS_AVERAGE("3_month_weeks_average"),
	SIX_MONTH_WEEKS_AVERAGE("6_month_weeks_average"),
	NINE_MONTH_WEEKS_AVERAGE("9_month_weeks_average"),
	INVALID_VALUE("invalid_value")
	;
	
	private String value;

	WeekConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static WeekConfigEnum getFromEnumValue(String value) {
		
		WeekConfigEnum result = WeekConfigEnum.INVALID_VALUE;
		
		for (WeekConfigEnum d: WeekConfigEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static WeekConfigEnum getFromEnumKey(String sampleEnumKey) {
		WeekConfigEnum result = WeekConfigEnum.INVALID_VALUE;
		
		for (WeekConfigEnum d: WeekConfigEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = WeekConfigEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
