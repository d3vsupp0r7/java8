package org.lba.randomgen.csv.generator;

public class CSVPrinter {
	
	public static String buildHeader(String[] headers, StringBuilder builderH) {
		for(int i = 0; i < headers.length; i++) {
			builderH.append(headers[i]+",");
		}

		String headerResult = builderH.toString();
		String headerCsv = headerResult.substring(0,headerResult.length() - 1);
		return headerCsv;
	}

}
