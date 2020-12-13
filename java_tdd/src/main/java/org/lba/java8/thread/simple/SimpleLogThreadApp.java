package org.lba.java8.thread.simple;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;

public class SimpleLogThreadApp{
	
	static final Logger LOGGER = Logger.getLogger(SimpleLogThreadApp.class);
	
	public static void main(String args[]){

		int numberOfTasks = 3;
		/**/
		int coreCount = Runtime.getRuntime().availableProcessors();
		LOGGER.debug("*** Numbers of cores for this machine:  " + coreCount + " ***");
		/**/
		ExecutorService executor= Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		try{
			LOGGER.debug("*** Numbers of threads to start:  " + numberOfTasks + " ***");
			
			for ( int i=0; i < numberOfTasks; i++){
				executor.execute(new SimpleLogThread((i+1)));                
			}
		}catch(Exception err){
			err.printStackTrace();
		}
		executor.shutdown(); // once you are done with ExecutorService
	}   
}
