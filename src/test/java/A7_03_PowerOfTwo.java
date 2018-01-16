import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an integer, write a function to determine if it is a power of tw
 *
 */
public class A7_03_PowerOfTwo {

	@Test
	public void test1(){
		Assert.assertTrue(isPowerOfTwo(2));
	}
	
	@Test
	public void test2(){
		Assert.assertTrue(isPowerOfTwo(8));
	}
	
	@Test
	public void test3(){
		Assert.assertFalse(isPowerOfTwo(7));
	}
	
	@Test
	public void test4(){
		Assert.assertFalse(isPowerOfTwo(0));
	}
	
	@Test
	public void test5(){
		Assert.assertTrue(isPowerOfTwo(1));
	}
	
	@Test
	public void test6(){
		Assert.assertFalse(isPowerOfTwo(Integer.MIN_VALUE));
	}
	
	public static boolean isPowerOfTwo(int n) {
		if(n==0 || n==Integer.MIN_VALUE) return false;
		
        if((n & (n-1)) == 0) return true;
        
        return false;
    }
}
