import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an array of numbers nums, in which exactly two elements 
 * appear only once and all the other elements appear exactly twice. 
 * Find the two elements that appear only once. 
 * 
 * Note:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5]. 
 * 
 * Note:
 * 1.The order of the result is not important. So in the above example, [5, 3] is also correct.
 * 2.Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 *
 */
public class A7_02_SingleNumber3 {
	
	@Test
	public void test1(){
		int[] nums = new int[]{1,2,1,3,2,5};
		Assert.assertArrayEquals(new int[]{3,5}, singleNumber(nums));
	}
	
	public static int[] singleNumber(int[] nums) {
		
		// 5-> 101
		// 3-> 011
		//  -> 110 -> 6
		
		Set<Integer> result = new HashSet<Integer>();
		for(int n:nums){
			if(result.contains(n)){
				result.remove(n);
			}else{
				result.add(n);
			}
		}
		
		int[] arr = new int[result.size()];
		int i = 0;
		for(int r: result){
			arr[i++] = r;
		}
		
		return arr;
	}
}
