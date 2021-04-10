package org.lba.java8.completablefeature;

public class CF_2_Problem {

	public static void main(String[] args) {
		
		/**
		 * Objective 1: print thread where code is executed
		 * OUTPUT: Current Thread: Thread[main,5,main]
		 */
		longNetworkProcess(5);
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
