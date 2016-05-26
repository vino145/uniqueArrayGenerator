package com.utils.arrays;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
/**
 * Remove duplicates from a Integer array and prints source and unique array with time taken to complete the process
 * @author vinod singh
 *
 */
public class RemoveDuplicate {
	//Class variables to be used across all methods
	private static long lStartTime;

	/**
	 * This method will remove duplicates the traditional way by iterating through array and updating new array.Does not use Java collections and is comparatively slower than other methods
	 * @param duplicatesArray
	 * @return uniqueArray
	 */
	public  int[] removeDuplicates(int[] duplicatesArray) {
		System.out.println("\nUnique Elements traditional way\n");
		System.out.println("Source Array: "+Arrays.toString(duplicatesArray));		
		int arraySize = duplicatesArray.length;
		//Loop through array
		for (int forwardIndex = 0; forwardIndex < arraySize; forwardIndex++) {
			for (int reverseindex = forwardIndex + 1; reverseindex < arraySize; reverseindex++) {
				if (duplicatesArray[forwardIndex] == duplicatesArray[reverseindex]) {
					duplicatesArray[reverseindex] = duplicatesArray[arraySize - 1];
					arraySize--;
					reverseindex--;
				}
			}
		}
		//Initialize array size after duplicates are removed
		int[] uniqueList = new int[arraySize];
		System.arraycopy(duplicatesArray, 0, uniqueList, 0, arraySize);
		System.out.println("Unique Array: "+Arrays.toString(uniqueList));
		testPerformance();
		return uniqueList;
	}
	
	/**
	 * This method will remove duplicates using JAVA collections and using LinkedHashSet will ensure that insertion order is maintained. Done using JAVA collections LinkedHashSet maintains insertion order.
	 * @param duplicatesArray
	 * @return uniqueArray
	 */
	public  int[] removeDuplicatesUsingCollections(int[] duplicatesArray) {
		System.out.println("\nJAVA collections unique list and maintain insertion order\n");
		System.out.println("Source Array: "+Arrays.toString(duplicatesArray));
		Set<Integer> uniqueSet = new LinkedHashSet<Integer>();
		int index = 0;
		for (int value:duplicatesArray) {
			// LinkedHashSet maintains the insertion order
			uniqueSet.add(value);
		}
		//Convert set to array using toArray()
		Object[] arrayWithoutDuplicates = uniqueSet.toArray();
		//Initialize array size after duplicates are removed
		int[] uniqueList = new int[arrayWithoutDuplicates.length];
		//Loop through array and convert object to int
		for (index = 0; index < arrayWithoutDuplicates.length; index++) {
			uniqueList[index] = (Integer) arrayWithoutDuplicates[index];
		}
		System.out.println("Unique Array: "+Arrays.toString(uniqueList));
		testPerformance();
		return uniqueList;
	}
	
	/**
	 * This method will remove duplicates and sort the array in ascending order using Java collections. Uses Treeset to sort unique integer array. 
	 * @param duplicatesArray
	 * @return unique sorted array
	 */
	public int[] removeNSortDuplicatesUsingCollections(int[] duplicatesArray) {
		System.out.println("\nUnique and sorted list JAVA Collections\n");
		System.out.println("Source Array: "+Arrays.toString(duplicatesArray));
		Set<Integer> uniqueSet = new TreeSet<Integer>();
		int index = 0;
		for (int value:duplicatesArray) {
			// Treeset sorts the input in ascending order
			uniqueSet.add(value);
		}
		//Convert set to array using toArray()
		Object[] arrayWithoutDuplicates = uniqueSet.toArray();
		//Initialize array size after duplicates are removed
		int[] uniqueList = new int[arrayWithoutDuplicates.length];
		//Loop through array and convert object to int
		for (index = 0; index < arrayWithoutDuplicates.length; index++) {
			uniqueList[index] = (Integer) arrayWithoutDuplicates[index];
		}
		System.out.println("Unique Array: "+Arrays.toString(uniqueList));
		testPerformance();
		return uniqueList;
	}
	
	//This method will print the time taken by method to execute
	private static void testPerformance() {
		long lEndTime = System.currentTimeMillis();
		long timeTaken = (lEndTime - lStartTime);
		System.out.println("Time taken to complete: " + timeTaken + " milliseconds");
	}
}
