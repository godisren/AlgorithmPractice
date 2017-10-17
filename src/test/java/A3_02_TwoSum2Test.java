
import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * 
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * 
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2 
 */
public class A3_02_TwoSum2Test {

	@Test
	public void test1() {
		int[] answer = twoSum(new int[] { 2, 3, 4, 7 }, 9);

		Assert.assertEquals(0, answer[0]);
		Assert.assertEquals(3, answer[1]);
	}

	@Test
	public void test2() {
		int[] answer = twoSum(new int[] { 2, 3, 4, 7 }, 7);

		Assert.assertEquals(1, answer[0]);
		Assert.assertEquals(2, answer[1]);
	}

	@Test
	public void test3() {
		int[] answer = twoSum(new int[] { 2, 3, 4, 7 }, 1);

		Assert.assertEquals(0, answer.length);
	}

	public int[] twoSum(int[] nums, int target) {
		// return twoSumByPoint(nums, target);
		return twoSumByBinarySearch(nums, target);
	}

	// O(n)
	public int[] twoSumByPoint(int[] nums, int target) {

		int beginIdx = 0;
		int lastIdx = nums.length - 1;

		if (nums[beginIdx] > target)
			return new int[0];

		while (beginIdx < lastIdx) {
			int sum = nums[beginIdx] + nums[lastIdx];

			if (sum == target)
				return new int[] { beginIdx, lastIdx };

			if (sum < target)
				beginIdx++;
			else
				lastIdx--;
		}

		return new int[0];
	}

	// O(n log n)
	public int[] twoSumByBinarySearch(int[] nums, int target) {
		//
		for (int i = 0; i < nums.length; i++) {

			int findIdx = binarySearch(nums, i, target - nums[i]);
			if (findIdx > 0)
				return new int[] { i, findIdx };
		}

		return new int[0];
	}

	// O(log n)
	public static int binarySearch(int[] intArray, int startIdx, int target) {

		int low = startIdx;
		int high = intArray.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;

			if (intArray[mid] == target) {
				return mid;
			} else if (target > intArray[mid]) {
				low = mid + 1;
			} else if (target < intArray[mid]) {
				high = mid - 1;
			}
		}

		return -1;
	}

}
