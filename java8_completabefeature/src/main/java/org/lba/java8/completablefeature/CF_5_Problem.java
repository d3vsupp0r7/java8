package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_5_Problem {

	public static void main(String[] args) {
		
		/**
		 * Problem: main thread sleep < another process
		 * so value it's not returned.
		 */
		CompletableFuture.supplyAsync(()->getValue())
		.thenAccept(System.out::println);
		/**/
		sleepMainThread();
		/**/
		System.out.println("Main process has done");
		
	}

	public static int getValue() {
		sleepLongMainThread();
		return 5;
	}
	
	public static void sleepMainThread() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void sleepLongMainThread() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
