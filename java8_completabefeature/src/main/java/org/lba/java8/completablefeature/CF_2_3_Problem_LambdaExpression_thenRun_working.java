package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_2_3_Problem_LambdaExpression_thenRun_working {

	public static void main(String[] args) {

		/**
		 * Objective 4
		 * Call chain: thenRun
		 * OUTPUT:
		 * 1) Call of longNetworkProcess with 5 -> return 50
		 * 2) pass 50 to method: performSomeAction -> 50%2 ==> +1 ==> output 51
		 * 3)  thenAccept call returns 51 as output
		 * 4) thenRun: Problem the main thread is closed before the thenRun invocation can terminate.
		 *    to avoid this we need to add sleep on main thread. Example 2_3
		 */
		System.out.println("thenApply - chain example - lambda expression");
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenApply(CF_2_3_Problem_LambdaExpression_thenRun_working::performSomeAction)
		.thenApply(CF_2_3_Problem_LambdaExpression_thenRun_working::performSomeAction)
		.thenAccept(System.out::println)
		.thenRun(()->veryLongProcess())
		.thenRun(()->veryLongProcess());

		sleepLongTimeMainThread();
	}

	/**
	 * 
	 * @param value
	 * @return
	 */
	public static int performSomeAction(int value) {

		if(value %2==0) {
			value = value + 1;
		}else {
			value = value + 3;
		}

		return value;

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
	
	public static void sleepLongTimeMainThread() {
		try {
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void veryLongProcess() {

		sleepMainThread();
		System.out.println("Very Long Process - DONE");
	}
}
