package dynamicprogramming;

import org.junit.Test;
import org.junit.Assert;

/**
 * Maximum Product Subarray
 * 
 * Question:
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6. 
 *
 */
public class A05_MaximumProductSubarray {
	
	@Test
	public void test1(){
		Assert.assertEquals(6, maxProduct(new int[]{2,3,-2,4}));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(48, maxProduct(new int[]{2,3,-2,-4}));
	}
	
	public static int maxProduct(int[] nums) {
        int max = nums[0], min = nums[0], answer = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max, tempMin = min;
            max = Math.max(Math.max(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            min = Math.min(Math.min(nums[i], tempMax * nums[i]), tempMin * nums[i]);
            answer = Math.max(max, answer);
        }
        return answer;
	}
}
