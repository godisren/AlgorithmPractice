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
 * You may assume duplicate exists in the array.
 *
 */
public class A6_03_MinimumInSortedRotatedArray2 {
	
	@Test
	public void test1(){
		Assert.assertEquals(0, findMin(new int[]{0,1,1,2,4,5,6,7}));
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
		Assert.assertEquals(1, findMin(new int[]{3,1,1,2}));
	}
	
	@Test
	public void test5(){
		Assert.assertEquals(1, findMin(new int[]{5,1,2,2,3,4}));
	}
	
	@Test
	public void test6(){
		Assert.assertEquals(1, findMin(new int[]{1,1,1}));
	}
	
	@Test
	public void test7(){
		Assert.assertEquals(0, findMin(new int[]{1,1,0,1}));
	}
	
	@Test
	public void test8(){
		Assert.assertEquals(0, findMin(new int[]{1,0,1,1}));
	}
	
	@Test
	public void test9(){
		Assert.assertEquals(0, findMin(new int[]{1,1,1,0,1}));
	}
	
	@Test
	public void test10(){
		Assert.assertEquals(0, findMin(new int[]{1,1,1,0,0}));
	}
	
	@Test
	public void test11(){
		Assert.assertEquals(0, findMin(new int[]{1,1,0,0,0}));
	}
	
	// the worst time complex : O(n)
	public static int findMin(int[] nums){
		int L = 0, R = nums.length-1;
		
		while (L<R){			
			int M = (L+R) / 2;
			
			if(nums[M] == nums[R]) R = R-1;			
			else if(nums[M] > nums[R]) L = M+1;
			else R = M;
		}
		
		return nums[L];
	}	
}
