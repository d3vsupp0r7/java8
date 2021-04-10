package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_1_3_Solution_CompletableFeature_ThreadSleep {

	public static void main(String[] args) {

		/*Solution: Run longNetworkProcess in background*/
		System.out.println("... START PROCESS ...");
		/*IMPO: Not showing result because it's running in different thread.
		 * This means that we have:
		 *  -)MAIN PROCESS (PROCESS_A)
		 *  -) COMPLETABLEFEATURE (PROCESS_B)
		 *  
		 *  */
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenAccept(integerValueReturnedFromLongNetworkingProcess -> System.out.println("Finish of CompletableValue calculation: " + integerValueReturnedFromLongNetworkingProcess));
		System.out.println("... DONE PROCESS ...");
		
		System.out.println("... SLEEP OF PROCESS_A TO ATTEND FINISH OF PROCESS_B  ...");
		sleepMainThread();
		System.out.println("... DONE SLEEP OF PROCESS_A TO ATTEND FINISH OF PROCESS_B  ...");
		
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
		
		sleepMainThread();
		return value * 10;
	}
	
	public static void sleepMainThread() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
