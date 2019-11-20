package org.lba.randomgen.csv.costraints;

public enum CSVGeneratorStoreConfig {

	DAY("D"),
	WEEK_OF_YEAR("W"),
	STORE("S"),
	PRODUCT("P"),
	QUANTITY_SOLD("Q"),
	INVALID_VALUE("INVALID_VALUE")
	;

	private String field;

	CSVGeneratorStoreConfig(String field) {
		this.field = field;
	}

	public String field() {
		return field;
	}
	
	public static CSVGeneratorStoreConfig getFromEnumValue(String value) {
		
		CSVGeneratorStoreConfig result = CSVGeneratorStoreConfig.INVALID_VALUE;
		
		for (CSVGeneratorStoreConfig d: CSVGeneratorStoreConfig.values()) {
			if(value.equalsIgnoreCase(d.field()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static CSVGeneratorStoreConfig getFromEnumKey(String sampleEnumKey) {
		CSVGeneratorStoreConfig result = CSVGeneratorStoreConfig.INVALID_VALUE;
		
		for (CSVGeneratorStoreConfig d: CSVGeneratorStoreConfig.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = CSVGeneratorStoreConfig.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
