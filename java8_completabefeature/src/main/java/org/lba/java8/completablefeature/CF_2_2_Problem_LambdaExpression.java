package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_2_2_Problem_LambdaExpression {

	public static void main(String[] args) {
		
		/**
		 * Objective 3
		 * Call chain: thenApply
		 * OUTPUT:
		 * 1) Call of longNetworkProcess with 5 -> return 50
		 * 2) pass 50 to method: performSomeAction -> 50%2 ==> +1 ==> output 51
		 * 3)  thenAccept call returns 51 as output
		 * 
		 */
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenApply(valueForInput -> performSomeAction(valueForInput))
		.thenAccept(returnedValue -> System.out.println(returnedValue)
				);
		
		sleepMainThread();
		
		/**
		 * Objective 3
		 * Call chain: thenApply
		 * OUTPUT:
		 * 1) Call of longNetworkProcess with 5 -> return 50
		 * 2) pass 50 to method: performSomeAction -> 50%2 ==> +1 ==> output 51
		 * 3)  thenAccept call returns 51 as output
		 * 
		 */
		System.out.println("thenApply - chain example - lambda expression");
		CompletableFuture.supplyAsync(()->longNetworkProcess(5))
		.thenApply(CF_2_2_Problem_LambdaExpression::performSomeAction)
		.thenApply(CF_2_2_Problem_LambdaExpression::performSomeAction)
		.thenAccept(System.out::println);
		
		sleepMainThread();
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
}
