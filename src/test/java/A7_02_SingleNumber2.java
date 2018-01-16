import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an array of integers, every element appears 
 * three times except for one, which appears exactly once. 
 * Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory? 
 *
 */
public class A7_02_SingleNumber2 {
	
	@Test
	public void test1(){
		int[] nums = new int[]{1,1,2,1};
		Assert.assertEquals(2, singleNumber(nums));
	}
	
	@Test
	public void test2(){
		int[] nums = new int[]{1};
		Assert.assertEquals(1, singleNumber(nums));
	}
	
	@Test
	public void test3(){
		int[] nums = new int[]{1,1,2,1,3,3,3};
		Assert.assertEquals(2, singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		// xor -> x ^ x = 0,   x ^ 0 = x
		// & ~ -> x & ~x = 0
		
		// ex. 1,1,1,3
		// step1: [1]  
		//		ones = 1, twos = 0
		// step2: [1]
		//		ones = 0, twos = 1
		// step3: [1]
		//		ones = 0, twos = 0
		// step4: [3]
		//		ones = 3, twos = 0
		
		int ones = 0, twos= 0;
		for(int n:nums){
			ones = ones^n & ~twos;
			twos = twos^n & ~ones;
		}
		
		return ones;
	}
}
