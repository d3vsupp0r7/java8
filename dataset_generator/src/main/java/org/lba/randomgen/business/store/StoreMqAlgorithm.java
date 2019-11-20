package org.lba.randomgen.business.store;

import org.lba.randomgen.csv.generator.RandomGeneratorAlgorithm;

public class StoreMqAlgorithm {

	public static String buildMq(String[] mqs) {
		int mqsIndex = RandomGeneratorAlgorithm.getRandomNumberInRange(0, mqs.length-1);
		String mqsCsv = mqs[mqsIndex];
		return mqsCsv;
	}
}
