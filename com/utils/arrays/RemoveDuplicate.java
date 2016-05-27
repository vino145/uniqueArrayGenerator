package com.utils.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Remove duplicates from a Integer array and prints source and unique array
 * with time taken to complete the process
 * 
 * @author vinod singh
 *
 */
public class RemoveDuplicate {
	// Class variables to be used across all methods
	private static long lStartTime;
	private static final Logger LOGGER = Logger.getLogger(RemoveDuplicate.class.getName());

	/**
	 * This method will remove duplicates the traditional way by iterating
	 * through array and updating new array.Does not use Java collections and is
	 * comparatively slower than other methods 
	 * Advantage - Simple and Effective POJO to identify duplicates in a array. 
	 * Disadvantage - Multiple iterations accessing the same array, does not maintain any order
	 * 
	 * @param duplicatesArray
	 * @return uniqueArray
	 */
	public int[] removeDuplicates(int[] duplicatesArray) {
		LOGGER.info("\nUnique Elements traditional way\n");
		LOGGER.info("Source Array: " + Arrays.toString(duplicatesArray));
		int arraySize = duplicatesArray.length;
		// Loop through array
		for (int forwardIndex = 0; forwardIndex < arraySize; forwardIndex++) {
			for (int reverseindex = forwardIndex + 1; reverseindex < arraySize; reverseindex++) {
				if (duplicatesArray[forwardIndex] == duplicatesArray[reverseindex]) {
					duplicatesArray[reverseindex] = duplicatesArray[arraySize - 1];
					arraySize--;
					reverseindex--;
				}

			}
		}
		// Initialize array size after duplicates are removed
		int[] uniqueList = new int[arraySize];
		System.arraycopy(duplicatesArray, 0, uniqueList, 0, arraySize);
		LOGGER.info("Unique Array: " + Arrays.toString(uniqueList));
		testPerformance();
		return uniqueList;
	}

	/**
	 * This method will remove duplicates using JAVA collections and using
	 * LinkedHashSet will ensure that insertion order is maintained. Done using
	 * JAVA collections LinkedHashSet maintains insertion order. 
	 * Advantage - LinkedHashSet maintains the insertion order. Foreach loop prevents
	 * creation of new variables. 
	 * Disadvantage - type casting of object to int. 
	 * @param duplicatesArray
	 * @return uniqueArray
	 */
	public int[] removeDuplicatesUsingCollections(int[] duplicatesArray) {
		LOGGER.info("\nJAVA collections unique list and maintain insertion order\n");
		LOGGER.info("Source Array: " + Arrays.toString(duplicatesArray));
		Set<Integer> uniqueSet = Collections.synchronizedSet(new LinkedHashSet<Integer>());
		int index = 0;
		int[] uniqueList = new int[0];
		try {
			for (int value : duplicatesArray) {
				// LinkedHashSet maintains the insertion order
				uniqueSet.add(value);
			}

			// Initialize array size after duplicates are removed
			uniqueList = new int[uniqueSet.size()];
			// Must be in the synchronized block
			synchronized (uniqueSet) {
				Iterator iterator = uniqueSet.iterator();
				while (iterator.hasNext())
					uniqueList[index++] = (int) iterator.next();
			}
			LOGGER.info("Unique Array: " + Arrays.toString(uniqueList));
			testPerformance();
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Exception occured while processing Array " + exception);
		}

		return uniqueList;
	}

	/**
	 * This method will remove duplicates and sort the array in ascending order
	 * using Java collections. Uses Treeset to sort unique integer array.
	 * Advantage - Java collection treeset used. Sorts array in ascending order.
	 * Disadvantage - Time consuming as elements are sorted using java
	 * collection inbuilt feature.
	 * @param duplicatesArray
	 * @return unique sorted array
	 */
	public int[] removeNSortDuplicatesUsingCollections(int[] duplicatesArray) {
		LOGGER.info("\nUnique and sorted list JAVA Collections\n");
		LOGGER.info("Source Array: " + Arrays.toString(duplicatesArray));
		Set<Integer> uniqueSet = Collections.synchronizedSet(new TreeSet<Integer>());
		int index = 0;
		int[] uniqueList = new int[0];
		try {
			for (int value : duplicatesArray) {
				// Treeset sorts the input in ascending order
				uniqueSet.add(value);
			}

			// Initialize array size after duplicates are removed
			uniqueList = new int[uniqueSet.size()];
			// Reinitialize index to zero
			index = 0;
			// Must be in the synchronized block
			synchronized (uniqueSet) {
				Iterator iterator = uniqueSet.iterator();
				while (iterator.hasNext())
					uniqueList[index++] = (int) iterator.next();
			}
			LOGGER.info("Unique Array: " + Arrays.toString(uniqueList));
			testPerformance();
		} catch (Exception exception) {
			LOGGER.log(Level.SEVERE, "Exception occured while processing Array " + exception);
		}
		return uniqueList;
	}

	// This method will print the time taken by method to execute
	private static void testPerformance() {
		long lEndTime = System.currentTimeMillis();
		long timeTaken = (lEndTime - lStartTime);
		LOGGER.info("Time taken to complete: " + timeTaken + " milliseconds");
	}
}
