package org.lba.randomgen.business;

public class ClassificationRatioAlgorithm {

	public static StringBuilder generateClassByRation(double ratio) {

		StringBuilder builder = new StringBuilder();

		if(ratio<=33) {
			builder.append("Low");	
		}else if (ratio > 33 && ratio <= 66) {
			builder.append("Medium");
		}else {
			builder.append("High");	
		}

		return builder;
	}
}
