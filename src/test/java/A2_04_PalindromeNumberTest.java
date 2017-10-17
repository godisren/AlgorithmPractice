
import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * 
 */
public class A2_04_PalindromeNumberTest {

	@Test
	public void test1() {
		Assert.assertEquals(true, isPalindromeNumber(12321));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, isPalindromeNumber(12312));
	}

	@Test
	public void test3() {
		Assert.assertEquals(true, isPalindromeNumber(11));
	}

	@Test
	public void test4() {
		Assert.assertEquals(true, isPalindromeNumber(113311));
	}

	@Test
	public void test5() {
		Assert.assertEquals(true, isPalindromeNumber(1));
	}

	public static boolean isPalindromeNumber(int x) {
		if (x < 0)
			return false;

		// divisor
		int divisor = 1;
		while (x / divisor >= 10) {
			divisor *= 10;
		}

		while (x > 10) { // i think it is better( executing time is reduced by
							// one)
			// while(x != 0){ // teacher taught
			// while(divisor > 0){
			if (x / divisor != x % 10)
				return false;

			x = (x % divisor) / 10;
			divisor /= 100;
		}

		return true;
	}
}
