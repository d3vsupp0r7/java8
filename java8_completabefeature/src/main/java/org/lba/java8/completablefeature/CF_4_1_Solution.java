package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_4_1_Solution {

	public static void main(String[] args) {
		/**
		 * Use of CompletableFuture with exceptions.
		 * join: waits for asynchronous task to complete and returns result
		 */
		CompletableFuture.supplyAsync(()->getValue())
		.thenAccept(System.out::println)
		.join();
	}

	public static int getValue() {
		getException();
		return 5;
	}
	
	public static void getException() {
		throw new RuntimeException();
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
