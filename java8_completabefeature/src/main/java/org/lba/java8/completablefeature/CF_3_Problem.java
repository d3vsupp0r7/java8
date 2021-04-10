package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_3_Problem {

	public static void main(String[] args) {
		/**
		 * Use of CompletableFuture as function param
		 */
		/**/
		int value = 7;
		/**/
		CompletableFuture<Integer> feature = new CompletableFuture<Integer>();
		/**/
		getReady(feature);
		/**/
		feature.complete(value);
	}
	
	/**
	 * 
	 * @param feature
	 */
	public static void getReady(CompletableFuture<Integer> feature) {
		feature.thenApply(var -> var * 5)
		.thenApply(var -> var + 20)
		.thenAccept(var -> System.out.println("Value: " + var + " - Current Thread: " + Thread.currentThread()));
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
