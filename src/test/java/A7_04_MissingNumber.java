import org.junit.Assert;
import org.junit.Test;

/**
 * Given an array containing n distinct numbers taken 
 * from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 *  Example 1
 *  Input: [3,0,1]
 *  Output: 2
 *  
 *  Example 2
 *  Input: [9,6,4,2,3,5,7,0,1]
 *  Output: 8
 *  
 *  Note:
 *  Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *  
 *  注意:數字一定是由0開始(表示可以使用array index的特性來處理)
 */
public class A7_04_MissingNumber {

	@Test
	public void test1(){
		Assert.assertEquals(2, missingNumber(new int[]{3,0,1}));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(8, missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
	}
	
	public static int missingNumber(int[] nums) {
		int result = 0, i = 0;
        for(i = 0;i<nums.length;i++){
        	result ^= i ^ nums[i];
        }
        
        result ^= i;
        
        return result;
    }
}
