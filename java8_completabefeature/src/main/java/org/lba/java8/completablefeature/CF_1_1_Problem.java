package org.lba.java8.completablefeature;

public class CF_1_1_Problem {

	public static void main(String[] args) {

		/**/
		System.out.println("... START PROCESS ...");
		/**/
		int solution = longNetworkProcess(5);
		/**/
		System.out.println(solution);
		/**/
		System.out.println("... DONE PROCESS ...");
	}

	/**
	 * Simulate a long process
	 * @param value
	 * @return
	 */
	public static int longNetworkProcess(int value) {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		return value * 10;
	}
}
