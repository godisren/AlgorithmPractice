import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class A2_01_PlusOneTest {

	@Test
	public void test1() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 1, 2, 3 });
		Assert.assertEquals(1, result[0]);
		Assert.assertEquals(2, result[1]);
		Assert.assertEquals(4, result[2]);
	}

	@Test
	public void test2() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 1, 2, 9 });
		Assert.assertEquals(1, result[0]);
		Assert.assertEquals(3, result[1]);
		Assert.assertEquals(0, result[2]);
	}

	@Test
	public void test3() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 1, 9, 9 });
		Assert.assertEquals(2, result[0]);
		Assert.assertEquals(0, result[1]);
		Assert.assertEquals(0, result[2]);
	}

	@Test
	public void test4() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 9, 9, 9 });
		Assert.assertEquals(1, result[0]);
		Assert.assertEquals(0, result[1]);
		Assert.assertEquals(0, result[2]);
		Assert.assertEquals(0, result[3]);
	}

	@Test
	public void test5() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 1 });
		Assert.assertEquals(2, result[0]);
	}

	@Test
	public void test6() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { 9 });
		Assert.assertEquals(1, result[0]);
		Assert.assertEquals(0, result[1]);
	}

	@Test
	public void test7() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { -8 });
		Assert.assertEquals(-7, result[0]);
	}

	@Test
	public void test8() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { -1, 0, 0 });
		Assert.assertEquals(-9, result[0]);
		Assert.assertEquals(9, result[1]);
	}

	@Test
	public void test9() {
		int[] result = new A2_01_PlusOneTest().plusOne(new int[] { -1, 1, 0 });
		Assert.assertEquals(-1, result[0]);
		Assert.assertEquals(0, result[1]);
		Assert.assertEquals(9, result[2]);
	}

	public int[] plusOne(int[] digits) {
		boolean isPositive = digits[0] > 0;

		if (isPositive) {
			for (int i = digits.length - 1; i >= 0; i--) {
				if (digits[i] < 9) {
					digits[i]++;
					return digits;
				}

				digits[i] = 0;
			}

			int[] answer = new int[digits.length + 1];
			answer[0] = 1;
			return answer;
		} else {
			for (int i = digits.length - 1; i >= 0; i--) {
				if (digits[i] < -1) {
					digits[i]++;
					return digits;
				} else if (digits[i] > 0) {
					digits[i]--;
					return digits;
				} else if (digits[i] == 0) {
					digits[i] = 9;
				}
			}

			int[] answer = new int[digits.length - 1];
			for (int i = 0; i < answer.length; i++) {
				answer[i] = digits[i + 1];
			}

			answer[0] *= -1;

			return answer;
		}

	}

}
