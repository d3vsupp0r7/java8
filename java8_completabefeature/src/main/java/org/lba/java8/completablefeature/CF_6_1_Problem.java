package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_6_1_Problem {

	public static void main(String[] args) {

		/**
		 * Problem: combine output
		 */
		int myVar = 5;
		getValueAsync(myVar)//5*4 = 20
		.thenCombine(getValueAsync2(myVar)//5*10=50
				,(a,b)->a+b)
		.thenAccept(outputElaboration -> System.out.println(outputElaboration));
		/*we need sleep*/
		sleepMainThread();

	}

	public static CompletableFuture<Integer> getValueAsync(int value){
		return CompletableFuture.supplyAsync(() -> process(value));
	}
	
	public static CompletableFuture<Integer> getValueAsync2(int value){
		return CompletableFuture.supplyAsync(() -> process2(value));
	}
	
	public static int process2(int y) {
		sleepMainThread();
		return y*10;
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
