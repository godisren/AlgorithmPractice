package leecode;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray {

	@Test
	public void test1(){
		int[] nums = new int[]{1,2};
		rotate(nums,1);
		Assert.assertArrayEquals(new int[]{2,1}, nums);
	}
	
	@Test
	public void test2(){
		int[] nums = new int[]{1,2,3};
		rotate(nums,2);
		Assert.assertArrayEquals(new int[]{2,3,1}, nums);
	}
	
	@Test
	public void test3(){
		int[] nums = new int[]{1,2,3,4,5,6};
		rotate(nums,2);
		Assert.assertArrayEquals(new int[]{5,6,1,2,3,4}, nums);
	}
	
	public static void rotate(int[] nums, int k) {
        // k=1 , nums = 1,2,3,4,5
		// step1: 2,1 | 3,4,5
		// step2: 2,1 | 5,4,3
		// setp3: 5,1,2,3,4 
		
		// k=1 , nums = 1,2,3,4,5,6
		// step1: 2,1 | 3,4,5
		// step2: 2,1 | 6,5,4,3
		// setp3: 6,1,2,3,4,5
		
		int n = nums.length;
		if(n==0 || n==1 || (k%n)==0)
			return;
		
		k = k%n;
		
		reverse(nums, 0 , n-1);
		reverse(nums, 0, k-1);
		reverse(nums, k , n-1);
		
//		int swapTimes = (n-1)/2;
//		int left = k-1, right = (k+1)%n;
//		while(swapTimes>0){
//			int temp = nums[left];
//			nums[left] = nums[right];
//			nums[right] = temp;
//			
//			left = (--left + n)%n;
//			right = ++right %n;
//			
//			swapTimes--;
//		}
    }
	
//	@Test
//	public void test_reverse(){
//		int[] nums = new int[]{1,2,3};
//		reverse(nums, 0,2);
//		Assert.assertArrayEquals(new int[]{3,2,1}, nums);
//		
//	}
//	
//	@Test
//	public void test_reverse2(){
//		int[] nums = new int[]{1,2,3};
//		reverse(nums, 0,1);
//		Assert.assertArrayEquals(new int[]{2,1,3}, nums);
//		
//	}
//	
//	@Test
//	public void test_reverse3(){
//		int[] nums = new int[]{1,2,3,4};
//		reverse(nums, 0,3);
//		Assert.assertArrayEquals(new int[]{4,3,2,1}, nums);
//		
//	}

	private static void reverse(int[] nums, int start, int end) {
		
		while(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			
			start++;
			end--;
		}
	}
	
	
}
