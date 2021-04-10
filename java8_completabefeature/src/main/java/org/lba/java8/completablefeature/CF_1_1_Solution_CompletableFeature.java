package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_1_1_Solution_CompletableFeature {

	public static void main(String[] args) {

		/*Solution: Run longNetworkProcess in background*/
		System.out.println("... START PROCESS ...");
		/*IMPO: Not showing result because it's running in different thread*/
		CompletableFuture.supplyAsync(()->longNetworkProcess(5));
		System.out.println("... DONE PROCESS ...");
//		/**/
//		System.out.println("... START PROCESS ...");
//		/**/
//		int solution = longNetworkProcess(5);
//		/**/
//		System.out.println(solution);
//		/**/
//		System.out.println("... DONE PROCESS ...");
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
