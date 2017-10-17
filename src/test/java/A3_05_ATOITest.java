
import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Implement atoi to convert a string to an integer.
 * 
 * Hint: Carefully consider all possible input cases. If you want 
 * a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: It is intended for this problem to be specified vaguely 
 * (ie, no given input specs). You are responsible to gather all the input requirements up front.
 */
public class A3_05_ATOITest {

	@Test
	public void test1() {
		Assert.assertEquals(1234, atoi("1234"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(-1234, atoi("-1234"));
	}

	@Test
	public void test3() {
		Assert.assertEquals(1234, atoi(" 1234 "));
	}

	@Test
	public void test4() {
		Assert.assertEquals(1234, atoi("1234abc"));
	}

	@Test
	public void test5() {
		// overflow
		// Integer.MAX_VALUE : 2147483647
		// Integer.MIN_VALUE : -2147483648

		Assert.assertEquals(2147483646, atoi("2147483646"));
		Assert.assertEquals(Integer.MAX_VALUE, atoi("2147483647"));
		Assert.assertEquals(Integer.MAX_VALUE, atoi("2147483648"));
	}

	@Test
	public void test6() {
		// overflow
		// Integer.MAX_VALUE : 2147483647
		// Integer.MIN_VALUE : -2147483648

		int i = 2147483647 + 1;

		Assert.assertEquals(-2147483647, atoi("-2147483647"));
		Assert.assertEquals(Integer.MIN_VALUE, atoi("-2147483648"));
		Assert.assertEquals(Integer.MIN_VALUE, atoi("-2147483649"));
	}

	@Test
	public void test7() {
		Assert.assertEquals(0, atoi("TEST"));
	}

	/***** leecode example in below *****/
	@Test
	public void test8() {
		Assert.assertEquals(0, atoi("+-12"));
	}

	@Test
	public void test9() {
		Assert.assertEquals(-12, atoi("  -0012a42"));
	}

	@Test
	public void test10() {
		Assert.assertEquals(0, atoi("   +0 123"));
	}

	@Test
	public void test11() {
		Assert.assertEquals(0, atoi("   - 321"));
	}

	@Test
	public void test12() {
		Assert.assertEquals(0, atoi(" b11228552307"));
	}

	/***** leecode example end *****/

	/**
	 * string is not digital => return 0; string have both digital and letters
	 * => letters only display after digital overflow => return
	 * Interger.MAX_VALUE/ Interger.MIN_VALUE there are white space in head and
	 * tail of string negative digital
	 */
	public static int atoi(String str) {
		int answer = 0;
		int sign = 0;

		int i = 0;
		int n = str.length();

		while (i < n && str.charAt(i) == ' ') {
			i++;
		}

		if (i < n && str.charAt(i) == '+') {
			sign = 1;
			i++;
		} else if (i < n && str.charAt(i) == '-') {
			sign = -1;
			i++;
		}

		while (i < n && Character.isDigit(str.charAt(i))) {
			int d = Character.getNumericValue(str.charAt(i));

			// overflow:
			// Integer.MAX_VALUE : 2147483647
			// Integer.MIN_VALUE : -2147483648

			if (answer > Integer.MAX_VALUE / 10 || (answer == Integer.MAX_VALUE / 10 && d >= 8))
				return sign >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

			answer = (answer * 10) + d;

			i++;
		}

		if (sign < 0)
			answer *= sign;

		return answer;
	}
}
