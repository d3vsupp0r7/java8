package org.lba.hk.util;

/**
 * 
 *
 */
public class ArrayValidationUtil { 
	
	private ArrayValidationUtil() {
		//Implement if necessary
	}
	
	/**
	 * This method verify if a string array contains only numeric using no third parties library.
	 * @param arItems
	 * @return
	 */
	public static boolean validateNumericArray(String[] arItems) {

		boolean result = true;

		for(int i =0; i < arItems.length; i++) {
			String currentItem = arItems[i];
			result = BasicJavaUtility.isNumericInteger(currentItem);
			if(!result) {
				System.out.println("Item: " + currentItem + " on array position: " + i + " is not a integer value");
				break;
			}
		}

		return result;
	}
	
	/**
	 * This method verify if a string array contains only positive numbers > 1 using no third parties library.
	 * @param arItems
	 * @return
	 */
	public static boolean validatePositiveNumericArray(String[] arItems) {

		boolean result = true;

		for(int i =0; i < arItems.length; i++) {
			String currentItem = arItems[i];
			result = BasicJavaUtility.isPositiveNumericInteger(currentItem);
			if(!result) {
				System.out.println("Item: " + currentItem + " on array position: " + i + " is not a positive value");
				break;
			}
		}

		return result;
	}
	
	/**
	 * This method verify if a string array contains only numeric using no third parties library.
	 * @param arItems
	 * @return
	 */
	public static boolean validatePositiveNumericArrayWithElementValueInRange(String[] arItems, int minRange, int maxRange) {

		boolean result = true;

		for(int i =0; i < arItems.length; i++) {
			String currentItem = arItems[i];
			result = BasicJavaUtility.isPositiveNumericInteger(currentItem);
			/**/
			if(!result) {
				System.out.println("Item: " + currentItem + " on array position: " + i + " is not a positive value");
			}
			/**/
			result = BasicJavaUtility.isPositiveNumericIntegerInRange(currentItem, minRange, maxRange);
			if(!result) {
				System.out.println("Item: " + currentItem + " on array position: " + i + " is not in range: min("+minRange+") - max("+maxRange+")");
			}
		}

		return result;
	}
	
	
	
	/**
	 * This method verify if a string array contains only numeric using no third parties library.
	 * @param arItems
	 * @return
	 */
	public static boolean validatePositiveNumericArrayWithElementValueInRangeBigInteger(String[] arItems, long minRange, long maxRange) {

		boolean result = true;

		for(int i =0; i < arItems.length; i++) {
			String currentItem = arItems[i];
			result = BasicJavaUtility.isPositiveNumericIntegerBigInteger(currentItem);
			/**/
			if(!result) {
				System.out.println("[BI] Item: " + currentItem + " on array position: " + i + " is not a positive value");
			}
			/**/
			result = BasicJavaUtility.isPositiveNumericIntegerInRangeBigInteger(currentItem, minRange, maxRange);
			if(!result) {
				System.out.println("[BI] Item: " + currentItem + " on array position: " + i + " is not in range: min("+minRange+") - max("+maxRange+")");
			}
		}

		return result;
	}

	/**
	 * Verify if arrays have same element size
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static boolean validateSameArrayDimensions(String[] array1,String[] array2) {

		boolean result = true;

		if(array1.length != array2.length) {
			result = false;
		}
			
		return result;
	}
}
