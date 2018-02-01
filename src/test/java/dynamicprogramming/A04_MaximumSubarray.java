package dynamicprogramming;

import org.junit.Test;
import org.junit.Assert;

/**
 * Maximum Subarray
 * 
 * Question:
 *  Find the contiguous subarray within an array 
 *  (containing at least one number) which has the largest sum.
 *  
 *  For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 *  the contiguous subarray [4,-1,2,1] has the largest sum = 6. 
 * 
 *
 */
public class A04_MaximumSubarray {
	
	@Test
	public void test1(){
		Assert.assertEquals(6, maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
	}
	
	public static int maxSubArray(int[] nums) {
		int answer = nums[0] , maxEndingHere = nums[0];
		for(int i = 1;i<nums.length;i++){
			maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
			answer = Math.max(answer, maxEndingHere);
		}
		
		return answer;
    }

	public static int maxSubArray2(int[] nums) {
		int max = Integer.MIN_VALUE , cur = 0;
		for(int n:nums){
			cur = Math.max(n, cur+n);
			max = Math.max(max, cur);
		}
		
		return max;
    }
}
