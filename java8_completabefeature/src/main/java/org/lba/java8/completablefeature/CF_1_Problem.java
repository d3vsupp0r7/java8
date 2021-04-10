package org.lba.java8.completablefeature;

public class CF_1_Problem {

	public static void main(String[] args) {

		int solution = longNetworkProcess(5);
		/**/
		System.out.println(solution);
		/**/
	}

	/**
	 * Simulate a long process
	 * @param value
	 * @return
	 */
	public static int longNetworkProcess(int value) {
		try {
			Thread.sleep(2000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return value * 10;
	}
}
