
import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *  
 * Note:
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows. 
 */
public class A2_03_ReverseIntegerTest {

	@Test
	public void test1() {
		Assert.assertEquals(1, reverse(1));
	}

	@Test
	public void test2() {
		Assert.assertEquals(321, reverse(123));
	}

	@Test
	public void test3() {
		Assert.assertEquals(-321, reverse(-123));
	}

	@Test
	public void test4() {
		// test overflow
		Assert.assertEquals(0, reverse(Integer.MAX_VALUE));
	}

	public static int reverse(int x) {
		int answer = 0;

		while (x != 0) {
			if (answer > 214748364 || answer < -214748364 || (answer == 214748364 && x % 10 > 7)
					|| (answer == -214748364 && x % 10 < 8))
				return 0;

			answer = answer * 10 + x % 10;
			x /= 10;
		}

		return answer;
	}

	public static int reverseByString(int x) {
		boolean neg = false;
		if (x < 0) {
			neg = true;
			x *= -1;
		}

		StringBuffer sb = new StringBuffer(String.valueOf(x));
		int answer;
		try {
			answer = Integer.valueOf(sb.reverse().toString());
		} catch (NumberFormatException e) {
			// int overflow handel
			return 0;
		}

		if (neg)
			answer *= -1;

		return answer;
	}
}
