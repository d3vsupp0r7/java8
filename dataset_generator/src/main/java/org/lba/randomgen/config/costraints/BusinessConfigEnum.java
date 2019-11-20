package org.lba.randomgen.config.costraints;

public enum BusinessConfigEnum {

	STORES("stores"),
	PRODUCTS("products"),
	WEATHER_TIME_SLOTS("weather_time_slots"),
	STORE_ACTIVE_TEMINALS("store_active_teminals"),
	STORE_MQS("store_mqs"),
	ACTIVE_PATIENTS("active_patients"),
	WEATHER("weather"),
	INVALID_VALUE("invalid_value")
	;
	
	private String value;

	BusinessConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static BusinessConfigEnum getFromEnumValue(String value) {
		
		BusinessConfigEnum result = BusinessConfigEnum.INVALID_VALUE;
		
		for (BusinessConfigEnum d: BusinessConfigEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static BusinessConfigEnum getFromEnumKey(String sampleEnumKey) {
		BusinessConfigEnum result = BusinessConfigEnum.INVALID_VALUE;
		
		for (BusinessConfigEnum d: BusinessConfigEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = BusinessConfigEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
