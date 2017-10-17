
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Given a string, find the length of the longest substring without repeating characters.
 * 
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class A3_07_LongestSubstringTest {

	@Test
	public void test1() {
		// abc
		Assert.assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
	}

	@Test
	public void test2() {
		// b
		Assert.assertEquals(1, lengthOfLongestSubstring("bbbbb"));
	}

	@Test
	public void test3() {
		// wke
		Assert.assertEquals(3, lengthOfLongestSubstring("pwwkew"));
	}

	@Test
	public void test4() {
		// wke
		Assert.assertEquals(2, lengthOfLongestSubstring("aab"));
	}

	@Test
	public void test5() {
		// wke
		Assert.assertEquals(2, lengthOfLongestSubstring("abba"));
	}

	/**
	 * assume input string is only assci words
	 * 
	 * @param s
	 * @return
	 */
	public static int lengthOfLongestSubstring(String s) {
		// return lengthOfLongestSubstringByYotta(s);
		return lengthOfLongestSubstringByStone2(s);
	}

	// for assci only
	public static int lengthOfLongestSubstringByYotta(String s) {
		int[] map = new int[256];
		Arrays.fill(map, -1);

		int start = 0, maxLength = 0;
		for (int i = 0; i < s.length(); i++) {

			if (map[s.charAt(i)] >= start) {
				start = map[s.charAt(i)] + 1;
			}

			map[s.charAt(i)] = i;
			maxLength = Math.max(maxLength, i - start + 1);
		}

		return maxLength;
	}

	// for unicode
	public static int lengthOfLongestSubstringByStone2(String s) {

		Map<Integer, Integer> keys = new HashMap<Integer, Integer>();

		int answer = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			int c = s.charAt(i);
			if (keys.containsKey(c) && keys.get(c) >= start) {
				start = keys.get(c) + 1;
			}

			keys.put(c, i);
			answer = Math.max(answer, i - start + 1);
		}

		return answer;
	}

	public static int lengthOfLongestSubstringByStone(String s) {

		Queue<Character> keys = new LinkedList<Character>();

		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (keys.contains(c)) {
				while (keys.contains(c)) {
					keys.poll();
				}
			}

			keys.add(c);
			answer = Math.max(answer, keys.size());
		}

		return answer;
	}
}
