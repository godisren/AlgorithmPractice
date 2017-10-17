
import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Given a string, find the length of the longest substring T 
 * that contains at most 2 distinct characters.
 *
 * For example, Given s = "eceba",
 * T is "ece" which its length is 3.
 */
public class A3_08_LongestSubstring2Test {

	@Test
	public void test1() {
		// ece
		Assert.assertEquals(3, lengthOfLongestSubstring("eceba"));
	}

	@Test
	public void test2() {
		// bcbbbbcccb
		Assert.assertEquals(10, lengthOfLongestSubstring("abcbbbbcccbdddadacb"));
	}

	@Test
	public void test3() {
		// bcbbbbcccb
		Assert.assertEquals(7, lengthOfLongestSubstring("aaaaaaa"));
	}

	/**
	 * assume input string is only assci words
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		return lengthOfLongestSubstringByYotta(s);
//		 return lengthOfLongestSubstringByStone(s);
	}

	// for assci only
	public static int lengthOfLongestSubstringByYotta(String s) {
		int[] charCounter = new int[256];

		int start = 0, maxLength = 0, distinctNum = 0;
		for (int i = 0; i < s.length(); i++) {
			if (charCounter[s.charAt(i)] == 0) {
				distinctNum++;
			}

			charCounter[s.charAt(i)]++;

			while (distinctNum > 2) {
				charCounter[s.charAt(start)]--;

				if (charCounter[s.charAt(start)] == 0)
					distinctNum--;

				start++;
			}

			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}

	// example:
	// 1.eceba -> ece
	// 2.abcbbbbcccbdddadacb -> bcbbbbcccb
	public static int lengthOfLongestSubstringByStone(String s) {

		Set<Character> keys = new HashSet<Character>();

		int answer = 0;
		int start = 0;
		int diffIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (keys.size() == 2 && !keys.contains(c)) {
				start = diffIdx + 1;
				keys.remove(s.charAt(diffIdx));
			}

			if (i > 0 && s.charAt(i) != s.charAt(i - 1)) {
				diffIdx = i - 1;
			}

			if (keys.size() < 2) {
				keys.add(c);
			}

			answer = Math.max(answer, i - start + 1);
		}

		return answer;
	}
}
