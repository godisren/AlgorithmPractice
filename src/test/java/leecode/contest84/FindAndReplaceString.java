package leecode.contest84;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class FindAndReplaceString {
	
	@Test
	public void testCompareEquals() {
		Assert.assertTrue(Solution.compareEquals("a".toCharArray(), 0, "a".toCharArray()));
		Assert.assertFalse(Solution.compareEquals("a".toCharArray(), 0, "ab".toCharArray()));
		Assert.assertTrue(Solution.compareEquals("ab".toCharArray(), 0, "ab".toCharArray()));
		Assert.assertTrue(Solution.compareEquals("abc".toCharArray(), 0, "ab".toCharArray()));
		Assert.assertTrue(Solution.compareEquals("abc".toCharArray(), 1, "bc".toCharArray()));
		Assert.assertTrue(Solution.compareEquals("abcd".toCharArray(), 1, "bc".toCharArray()));
	}

	@Test
	public void test1() {
		// Input: S = "abcd", indexes = [0,2], sources = ["a","cd"], targets = ["eee","ffff"]
		// Output: "eeebffff"
		// Explanation: "a" starts at index 0 in S, so it's replaced by "eee".
		// "cd" starts at index 2 in S, so it's replaced by "ffff".
		
		String result = new Solution().findReplaceString("abcd", 
									new int[]{0,2}, 
									new String[]{"a","cd"} , 
									new String[]{"eee","ffff"});
		
		Assert.assertEquals("eeebffff", result);
	}
	
	@Test
	public void test2() {
		// Input: S = "abcd", indexes = [0,2], sources = ["ab","ec"], targets = ["eee","ffff"]
		// Output: "eeecd"
		// Explanation: "ab" starts at index 0 in S, so it's replaced by "eee". 
		// "ec" doesn't starts at index 2 in the original S, so we do nothing.
		
		String result = new Solution().findReplaceString("abcd", 
									new int[]{0,2}, 
									new String[]{"ab","ec"} , 
									new String[]{"eee","ffff"});
		
		Assert.assertEquals("eeecd", result);
	}
	
	@Test
	public void test3() {
		// Input: S = "vmokgggqzp", indexes = [3,5,1], sources = ["kg","ggq","mo"], targets = ["s","so","bfr"]
		// Output: "vbfrssozp"
		
		String result = new Solution().findReplaceString("abcd", 
									new int[]{0,2}, 
									new String[]{"ab","ec"} , 
									new String[]{"eee","ffff"});
		
		Assert.assertEquals("eeecd", result);
	}	
	
	static class Solution {
		
		public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
			Map<Integer,Integer> indexMap = new HashMap();
			for(int i=0; i<indexes.length;i++)
				indexMap.put(indexes[i], i);
			
			StringBuilder result = new StringBuilder();
			char[] chars = S.toCharArray();
			int i = 0;
			while (i < chars.length) {
				if (indexMap.containsKey(i)) {
					String source =  sources[indexMap.get(i)];
					if (source != null && compareEquals(chars, i, source.toCharArray())) {
						// replace & shift position
						result.append(targets[indexMap.get(i)]);
						i += source.length();
						continue;
					}
				} 
					
				result.append(chars[i]);
				i++;
			}

			return result.toString();
		}

		static public boolean compareEquals(char[] chars, int idxStart, char[] sArr) {
			if (chars.length < idxStart + sArr.length)
				return false;

			int start = 0;

			while (chars[idxStart++] == sArr[start++]) {
				if (start >= sArr.length)
					return true;
			}
			;

			return false;
		}
	}
}
