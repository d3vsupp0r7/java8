package org.lba.randomgen.date;

public class WeekAlgorithm {

	public static double weekWeigth(int weekNumber) {

		double weekWeight = 0;

		if(weekNumber <= 12 || (weekNumber >=40 && weekNumber<=51) ) {
			weekWeight = 1.5;
		}else if(weekNumber >12 && weekNumber<=25 ) {
			weekWeight = 1.3;
		}else {
			weekWeight = 0.8;
		}

		return weekWeight;
	}

}
