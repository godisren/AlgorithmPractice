import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {

	@Test
	public void test1() {
		int result = binarySearch(new int[] { 2 }, 2);
		Assert.assertEquals(0, result);
	}

	@Test
	public void test2() {
		int result = binarySearch(new int[] { 1, 2 }, 2);
		Assert.assertEquals(1, result);
	}

	@Test
	public void test3() {
		int result = binarySearch(new int[] { 1, 2 }, 1);
		Assert.assertEquals(0, result);
	}

	@Test
	public void test4() {
		int result = binarySearch(new int[] { 1, 2, 3, 4 }, 1);
		Assert.assertEquals(0, result);
	}

	@Test
	public void test5() {
		int result = binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 2);
		Assert.assertEquals(1, result);
	}

	@Test
	public void test6() {
		int result = binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 6);
		Assert.assertEquals(5, result);
	}

	@Test
	public void test7() {
		int result = binarySearch(new int[] { 1, 2, 3, 4, 5, 6 }, 7);
		Assert.assertEquals(-1, result);
	}

	public static int binarySearch(int[] intArray, int target) {

		if (intArray.length == 1 && intArray[0] == target) {
			return 0;
		}

		int low = 0;
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
