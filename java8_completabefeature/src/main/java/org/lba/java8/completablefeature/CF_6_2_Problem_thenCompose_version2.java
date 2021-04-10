package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_6_2_Problem_thenCompose_version2 {

	public static void main(String[] args) {

		/**
		 * Problem: combine output
		 */
		int myVar = 5;
		getValueAsync(myVar)//5*4 = 20
		.thenCompose(outValue1 ->getValueAsync2(outValue1))//20*10 = 200
		.thenAccept(outputElaboration -> System.out.println(outputElaboration));
		/*we need sleep*/
		sleepLongMainThread();

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

	public static void sleepLongMainThread() {
		try {
			Thread.sleep(7000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
