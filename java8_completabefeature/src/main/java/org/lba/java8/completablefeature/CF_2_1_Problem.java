package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_2_1_Problem {

	public static void main(String[] args) {
		
		/**
		 * Objective 2: print thread where code is executed using CompletableFeature
		 * OUTPUT: Current Thread: Thread[ForkJoinPool.commonPool-worker-1,5,main]
		 */
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenAccept(returnedValue -> System.out.println(returnedValue)
				);
	}
	
	/**
	 * Simulate a long process
	 * @param value
	 * @return
	 */
	public static int longNetworkProcess(int value) {
		System.out.println("Current Thread: " + Thread.currentThread());
		
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
