import org.junit.Test;

import org.junit.Assert;

/**
 * Question:
 * Find Minimum in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 *
 */
public class A6_02_MinimumInSortedRotatedArray {
	
	@Test
	public void test1(){
		Assert.assertEquals(0, findMin(new int[]{0,1,2,4,5,6,7}));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(0, findMin(new int[]{4,5,6,7,0,1,2}));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals(1, findMin(new int[]{1,2}));
	}
	
	@Test
	public void test4(){
		Assert.assertEquals(1, findMin(new int[]{3,1,2}));
	}
	
	@Test
	public void test5(){
		Assert.assertEquals(1, findMin(new int[]{5,1,2,3,4}));
	}
	
	// time complex : O(log n)
	public static int findMin(int[] nums){
		int L = 0, R = nums.length-1;
		
		while (L<R){			
			int M = (L+R) / 2;			
			if(nums[M] > nums[R]) L = M+1;
			else R = M;
		}
		
		return nums[L];
	}	
}
