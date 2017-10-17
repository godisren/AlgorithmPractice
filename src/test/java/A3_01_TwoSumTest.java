
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class A3_01_TwoSumTest {

	/**
	 * this question consumes that the answer is just only one
	 */

	@Test
	public void test1() {
		int[] answer = twoSum(new int[] { 2, 7, 1, 3 }, 9);

		Assert.assertEquals(0, answer[0]);
		Assert.assertEquals(1, answer[1]);
	}

	@Test
	public void test2() {
		int[] answer = twoSum(new int[] { 2, 7, 1, 3 }, 5);

		Assert.assertEquals(0, answer[0]);
		Assert.assertEquals(3, answer[1]);
	}

	@Test
	public void test4() {
		int[] answer = twoSum(new int[] { 2, 7, 1, 3 }, 11);

		Assert.assertEquals(0, answer.length);
	}

	@Test
	public void test5() {
		int[] answer = twoSum(new int[] { 2, 7, 1, 3 }, 6);

		Assert.assertEquals(0, answer.length);
	}

	// time -> O(n), space -> O(n)
	public int[] twoSum2(int[] nums, int target) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(target - nums[i]))
				return new int[] { map.get(target - nums[i]), i };

			map.put(nums[i], i);
		}

		return new int[0];
	}

	// time -> O(n^2), space -> O(1)
	public int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++)
			for (int j = 1; j < nums.length; j++)
				if ((nums[i] + nums[j]) == target)
					return new int[] { i, j };

		return new int[0];
	}
}
