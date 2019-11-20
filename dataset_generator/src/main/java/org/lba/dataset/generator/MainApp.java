package org.lba.dataset.generator;

public class MainApp {

	public static void main(String[] args) {
		
		int weeks = 52;
		int days = 7;
		int store = 7;
		int product = 3; 
		
		for (int weeksIterator = 1; weeksIterator <= weeks; weeksIterator++) {
			
			for ( int daysIterator = 1; daysIterator <= days; daysIterator++) {
			
				for (int storeIterator = 1; storeIterator <=  store; storeIterator++) {
					
					for(int productIterator = 0; productIterator < product; productIterator++) {
						
						System.out.println(weeks+","+daysIterator+","+storeIterator+","+productIterator+","+"1");
						
					}//product
					
				}//store
				
			}// days
			
		}//weeks
	}
}
