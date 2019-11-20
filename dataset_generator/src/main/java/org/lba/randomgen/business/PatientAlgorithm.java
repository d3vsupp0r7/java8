package org.lba.randomgen.business;

import org.lba.randomgen.csv.generator.RandomGeneratorAlgorithm;

public class PatientAlgorithm {

	public static String buildPatients(String[] patients) {
		int patientsIndex = RandomGeneratorAlgorithm.getRandomNumberInRange(0, patients.length-1);
		String patientsCsv = patients[patientsIndex];
		return patientsCsv;
	}
}
