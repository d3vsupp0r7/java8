package org.lba.randomgen.config.costraints;

public enum GeneratorConfigEnum {
	
	SAVE_PATH_CSV("save.path.csv"),
	SAVE_PATH_PDF("save.path.pdf"),
	SAVE_PATH_XLS("save.path.xls"),
	//
	FILENAME_CSV_OUTPUT("filename_csv_output"),
	FILENAME_PDF_OUTPUT("filename_pdf_output"),
	FILENAME_XLS_OUTPUT("filename_xls_output"),
	//
	CSV_EXTENSION("csv_extension"),
	PDF_EXTENSION("pdf_extension"),
	EXCEL_EXTENSION("excel_extension"),
	//
	GENERATOR_ITERATIONS("generator_iterations"),
	GENERATOR_HEADERS("generator_headers"),
	//
	WEIGHT_SEPARATOR("weight_separator"),
	ITEM_SEPARATOR("item_separator"),
	//
	YEARS("years"),
	DATE_PATTERN_FULL("date_pattern_full"),
	//
	CLASSIFICATION_RESULTS("classification_results"),
	INVALID_VALUE("INVALID_VALUE")
	;

	private String value;

	GeneratorConfigEnum(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	
	public static GeneratorConfigEnum getFromEnumValue(String value) {
		
		GeneratorConfigEnum result = GeneratorConfigEnum.INVALID_VALUE;
		
		for (GeneratorConfigEnum d: GeneratorConfigEnum.values()) {
			if(value.equalsIgnoreCase(d.getValue()) ) {
				result = d;
			}
		}
		
		return result;
	}

	public static GeneratorConfigEnum getFromEnumKey(String sampleEnumKey) {
		
		GeneratorConfigEnum result = GeneratorConfigEnum.INVALID_VALUE;
		
		for (GeneratorConfigEnum d: GeneratorConfigEnum.values()) {
			if(sampleEnumKey.equalsIgnoreCase(d.name()) ) {
				result = GeneratorConfigEnum.valueOf(sampleEnumKey.toUpperCase());
			}
		}
		
		return result;
	}
}
