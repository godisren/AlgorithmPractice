package others.array;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class String2Integer {

	@Test
	public void test1() {
		Assert.assertEquals(123, covertIng("123"));
		Assert.assertEquals(123, covertIng("+123"));
		Assert.assertEquals(123, covertIng("0123"));
		Assert.assertEquals(0, covertIng("0"));

		Assert.assertEquals(0, covertIng("-0"));
		Assert.assertEquals(-123, covertIng("-123"));
		Assert.assertEquals(2147483647, covertIng("2147483647"));
		Assert.assertEquals(-2147483648, covertIng("-2147483648"));

		System.out.println(Integer.MIN_VALUE);
	}

	
	@Test
	public void test2() {
		try {
			covertIng("-2147483649");
		} catch (Exception e) {
			Assert.assertEquals("the number is overflow.(min)", e.getMessage());
		}
	}
	
	@Test
	public void test3() {
		try {
			covertIng("-2147483650");
		} catch (Exception e) {
			Assert.assertEquals("the number is overflow.(min)", e.getMessage());
		}
	}
	
	@Test
	public void test4() {
		try {
			covertIng("2147483649");
		} catch (Exception e) {
			Assert.assertEquals("the number is overflow.(max)", e.getMessage());
		}
	}
	
	@Test
	public void test5() {
		try {
			covertIng("2147483650");
		} catch (Exception e) {
			Assert.assertEquals("the number is overflow.(max)", e.getMessage());
		}
	}
	
	public int covertIng(String str) {
		/**
		 * str : 123, -123, 012, may exceed max or min integter java integer
		 * maximum : 2147483647 minimum : -2147483648
		 */

		// convert to chars
		char[] chars = str.toCharArray();

		int sign = 1;

		int i = 0;
		int result = 0;
		if (chars[i] == '-') {
			sign = -1;
			i++;
		}

		if (chars[i] == '+')
			i++;

		char c;
		for (; i < chars.length; i++) {
			c = chars[i];
			if (!Character.isDigit(c))
				throw new RuntimeException("The number format is invalid.");

			int d = Character.getNumericValue(c);
			if (result < -214748364 || (result == -214748364 && d > 8)) {
				throw new RuntimeException("the number is overflow.(min)");
			} else if (result > 214748364 || (result == 214748364 && d > 7)) {
				throw new RuntimeException("the number is overflow.(max)");
			}

			// main calculation
			result = result * 10 + (d * sign);
		}

		return result;
	}
}
