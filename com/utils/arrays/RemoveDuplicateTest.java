package com.utils.arrays;

import org.junit.Test;
import org.junit.Assert;

public class RemoveDuplicateTest {
	public int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };
	@Test
	public void removeDuplicateTest() {
		int[] expectedResult = {1, 2, 34, 10, 25, 11, 45, 3, 26, 85, 4, 17, 86, 20, 43, 18, 8, 10000, 9, 16, 19, 13, 6, 12, 15, 5, 14, 7};
		
		RemoveDuplicate removeDuplicate = new RemoveDuplicate();
		
		Assert.assertArrayEquals(expectedResult,removeDuplicate.removeDuplicates(randomIntegers));
		
	}
	
	@Test
	public void removeDuplicatesUsingCollectionsTest() {
		int[] expectedResult = {1, 2, 34, 25, 45, 3, 26, 85, 4, 86, 43, 10000, 11, 16, 19, 18, 9, 20, 17, 8, 15, 6, 5, 10, 14, 12, 13, 7};
		
		RemoveDuplicate removeDuplicate = new RemoveDuplicate();
		
		Assert.assertArrayEquals(expectedResult,removeDuplicate.removeDuplicatesUsingCollections(randomIntegers));
		
	}
	
	@Test
	public void removeNSortDuplicatesUsingCollectionsTest() {
		
		int[] expectedResult = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 25, 26, 34, 43, 45, 85, 86, 10000};
		
		RemoveDuplicate removeDuplicate = new RemoveDuplicate();
		
		Assert.assertArrayEquals(expectedResult,removeDuplicate.removeNSortDuplicatesUsingCollections(randomIntegers));
		
	}

}
