import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive,
 * return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, 
 * return ["2", "4->49", "51->74", "76->99"].
 */
public class A3_11_MissingRangesTest {

	@Test
	public void test1() {
		int[] inputs = new int[] { 1, 2, 5, 80 };
		List<String> result = findMissingRanges(inputs, 0, 99);
		Assert.assertEquals("0", result.get(0));
		Assert.assertEquals("3->4", result.get(1));
		Assert.assertEquals("6->79", result.get(2));
	}

	@Test
	public void test2() {
		int[] inputs = new int[] { 0, 2, 5, 99 };
		List<String> result = findMissingRanges(inputs, 0, 99);
		Assert.assertEquals("1", result.get(0));
		Assert.assertEquals("3->4", result.get(1));
		Assert.assertEquals("6->98", result.get(2));
	}

	@Test
	public void test3() {
		int[] inputs = new int[0];
		List<String> result = findMissingRanges(inputs, 0, 99);
		Assert.assertEquals("0->99", result.get(0));
	}

	public static List<String> findMissingRanges(int[] values, int start, int end) {

		List<String> ranges = new ArrayList<String>();
		int previousNum = start - 1;
		for (int i = 0; i <= values.length; i++) {
			int current;
			if (i == values.length) {
				current = end + 1;
			} else {
				current = values[i];
			}

			if (current - previousNum >= 2) {
				int from = previousNum + 1;
				int to = current - 1;
				String range = from + "->" + to;
				if (from == to) {
					range = String.valueOf(from);
				}
				ranges.add(range);
			}

			previousNum = current;
		}

		return ranges;
	}
}
