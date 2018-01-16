import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an array of integers, every element appears 
 * twice except for one. Find that single one.
 * 
 * Note:
 * Your algorithm should have a linear runtime complexity. 
 * Could you implement it without using extra memory? 
 *
 */
public class A7_01_SingleNumber {
	
	@Test
	public void test1(){
		int[] nums = new int[]{1,2,1};
		Assert.assertEquals(2, singleNumber(nums));
	}
	
	@Test
	public void test2(){
		int[] nums = new int[]{1};
		Assert.assertEquals(1, singleNumber(nums));
	}
	
	public static int singleNumber(int[] nums) {
		// exmaple [1,2,1]
        // 01 xor 10 = 11 xor 01 = 10(answer)
		
		int s = 0;
		for(int n:nums)
			s ^= n;
		
		return s;
		
    }
}
