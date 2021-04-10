package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_6_Problem {

	public static void main(String[] args) {

		/**
		 * Problem: combine output
		 */
		getValueAsync(5).thenAccept(output -> System.out.println(output));
		/*we need sleep*/
		sleepMainThread();

	}

	public static CompletableFuture<Integer> getValueAsync(int value){
		return CompletableFuture.supplyAsync(() -> process(value));
	}

	public static int process(int x) {
		sleepMainThread();
		return x*4;
	}

	public static void sleepMainThread() {
		try {
			Thread.sleep(3000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

}
