package org.lba.java8.completablefeature;

import java.util.concurrent.CompletableFuture;

public class CF_4_6_Solution_use_exceptionally_chain {

	public static void main(String[] args) {
		/**
		 * Use of CompletableFuture with exceptions.
		 * join: waits for asynchronous task to complete and returns result
		 * If an exception launch an exception you can use the value returned by
		 * method used to handle exception.
		 * If we use another exception, noting was showed.
		 * To show exception onn chain processing, we use join.
		 * If we need to manage an exception after a method we need to use 
		 * exceptionally method.
		 * If no exception was throws, method exceptionally was ignored
		 */
		CompletableFuture.supplyAsync(()->getValue()) // return 5
		.exceptionally(throwableException -> handleError(throwableException))//no exception
		.thenApply(integer -> getAnotherValue())//launch exception - find an exceptionally call in chain
		.thenApply(integer -> integer + 8)//not executed
		.thenApply(integer -> integer + 2)// not executed
		.exceptionally(throwableException -> 91)//EXECUTED: exception return 91 as value
		.thenApply(integer -> integer + 10)// EXECUTED: flow managed an exception and continue chain => 91 + 10 = 101
		.thenAccept(System.out::println) //print 101
		.join();
	}
	
	public static int getValue() {
		return 5;
	}
	
	public static int getAnotherValue() {
		getException();
		return 5;
	}
	
	public static int handleError(Throwable t) {
		System.out.println("ERROR MANAGEMENT METHOD: RETURN 100");
		return 100;
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
