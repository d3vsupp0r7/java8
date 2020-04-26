package org.lba.hk.util;

import java.math.BigInteger;

/**
 * Utility class used to not use third party libraries, like Apache commons.
 *
 */
public class BasicJavaUtility {

	private BasicJavaUtility() {
		//Implement if necessary
	}

	/**
	 * This method verify if a string is numeric using no third parties library.
	 * @param aGenericString
	 * @return
	 */
	public static boolean isNumericInteger(String aGenericString) {
		if (aGenericString == null) {
			return false;
		}
		try {
			Integer.parseInt(aGenericString);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * This method verify if a string is numeric using no third parties library.
	 * @param aGenericString
	 * @return
	 */
	public static boolean isPositiveNumericInteger(String aGenericString) {
		boolean result = true;

		try {
			int conversionResult = Integer.parseInt(aGenericString);
			if(conversionResult<1) {
				result = false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return result;
	}

	/**
	 * This method verify if a string is numeric using no third parties library.
	 * @param aGenericString
	 * @return
	 */
	public static boolean isPositiveNumericIntegerBigInteger(String aGenericString) {
		boolean result = true;

		try {
			BigInteger conversionResult = new BigInteger(aGenericString);
			if(conversionResult.compareTo(BigInteger.ZERO)<0) {
				result = false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return result;
	}
	
	/**
	 * This method verify if a string is numeric within a int range using no third parties library.
	 * @param aGenericString
	 * @return
	 */
	public static boolean isPositiveNumericIntegerInRange(String aGenericString, int minRange, int maxRange) {
		boolean result = true;

		try {
			int conversionResult = Integer.parseInt(aGenericString);
			if(conversionResult<minRange || conversionResult>maxRange) {
				result = false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return result;
	}

	/**/
	public static boolean isPositiveNumericIntegerInRangeBigInteger(String aGenericString, long minRange, long maxRange) {
		boolean result = true;

		try {
			/**/
			BigInteger minBI = BigInteger.valueOf(minRange);
			BigInteger maxBI = BigInteger.valueOf(maxRange);
			/**/
			BigInteger conversionResult = new BigInteger(aGenericString);
			if(conversionResult.compareTo(minBI)<0 ||conversionResult.compareTo(maxBI)==1) {
				result = false;
			}
		} catch (NumberFormatException nfe) {
			return false;
		}

		return result;
	}
}
