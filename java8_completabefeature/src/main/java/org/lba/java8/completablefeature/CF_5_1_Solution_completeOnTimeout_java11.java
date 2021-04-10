package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class CF_5_1_Solution_completeOnTimeout_java11 {

	public static void main(String[] args) {
		
		/**
		 * Problem: main thread sleep < another process
		 * so value it's not returned.
		 * 
		 * completeOnTimeout -> java 11
		 */
		
		CompletableFuture.supplyAsync(()->timeoutAfter(1, TimeUnit.SECONDS));
		
		CompletableFuture.supplyAsync(()->getValue());
		
		
//		CompletableFuture.supplyAsync(()->getValue())
//		.thenCombine(CompletableFuture.supplyAsync(() -> timeoutAfter(1, TimeUnit.SECONDS))
//		.thenAccept(System.out::println);
		/**/
		sleepMainThread();
		/**/
		System.out.println("Main process has done");
		
	}
	
	/**
	 * JAVA 8 timeout example
	 * @param <T>
	 * @param timeout
	 * @param unit
	 * @return
	 */
	public static <T> CompletableFuture<T> timeoutAfter(long timeout, TimeUnit unit) {
		 ScheduledExecutorService delayer = Executors.newScheduledThreadPool(3);
		 
	    CompletableFuture<T> result = new CompletableFuture<T>();
	    delayer.schedule(() -> result.completeExceptionally(new TimeoutException()), timeout, unit);
	    return result;
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
