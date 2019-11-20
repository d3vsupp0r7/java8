package org.lba.randomgen.business.store;

import org.lba.randomgen.csv.generator.RandomGeneratorAlgorithm;

public class StoreTerminalAlgorithm {

	public static String buildTerminals(String[] teminals) {
		int terminalsIndex = RandomGeneratorAlgorithm.getRandomNumberInRange(0, teminals.length-1);
		String terminalsCsv = teminals[terminalsIndex];
		return terminalsCsv;
	}
}
