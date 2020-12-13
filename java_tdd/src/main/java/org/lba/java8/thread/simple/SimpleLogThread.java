package org.lba.java8.thread.simple;

import org.apache.log4j.Logger;

public class SimpleLogThread implements Runnable{
	
	static final Logger LOGGER = Logger.getLogger(SimpleLogThread.class);
	
	int id;
	
	public SimpleLogThread(int i){
		this.id = i;
	}
	public void run(){
		try{
			LOGGER.debug("******** SimpleLogThread - ID: " + id + " *************");
			LOGGER.debug("\t* Runnable started id : "+id);
			LOGGER.debug("\t*Run: "+ Thread.currentThread().getName()); 
			LOGGER.debug("\t*Runnable ended id:"+id);
			LOGGER.debug("************************");
		}catch(Exception err){
			err.printStackTrace();
		}
	}

}