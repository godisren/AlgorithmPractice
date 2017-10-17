
import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Given two strings S and T, determine if they are both one edit distance apart.
 * 
 * S="abcd" , T="abc" => true
 */
public class A3_12_OneEditDistanceTest {

	@Test
	public void test1() {
		Assert.assertTrue(isOneEditDistance("abc", "abcd"));
	}

	@Test
	public void test2() {
		Assert.assertFalse(isOneEditDistance("abc", "abcde"));
	}

	@Test
	public void test3() {
		Assert.assertTrue(isOneEditDistance("abc", "bc"));
	}

	@Test
	public void test4() {
		Assert.assertTrue(isOneEditDistance("bc", "abc"));
	}

	@Test
	public void test5() {
		Assert.assertFalse(isOneEditDistance("abc", "efg"));
	}

	@Test
	public void test6() {
		Assert.assertTrue(isOneEditDistance("abcde", "abxde"));
	}

	@Test
	public void test7() {
		Assert.assertTrue(isOneEditDistance("adc", "abdc"));
	}

	@Test
	public void test8() {
		Assert.assertFalse(isOneEditDistance("abc", "abc"));
	}

	public static boolean isOneEditDistance(String s, String t) {
		int m = s.length();
		int n = t.length();

		if (m > n) {
			return isOneEditDistance(t, s);
		}

		if (n - m >= 2)
			return false;

		// s = "abc" "abc" "abbde" "adc"
		// t = "abc" "abcd" "abcde" "abdc"

		int i = 0;
		int diff = n - m;
		while (i < m && s.charAt(i) == t.charAt(i))
			i++;
		if (i == m)
			return diff > 0;
		if (diff == 0)
			i++;
		while (i < m && s.charAt(i) == t.charAt(i + diff))
			i++;
		return i == m;

		// int j=0;
		// for(int i=0;i<s.length();i++){
		// while(j<t.length() && s.charAt(i)!=t.charAt(j)){
		//
		// if(i+1< s.length() && s.charAt(i+1)==t.charAt(j))
		// break;
		//
		// j++;
		//
		// if(Math.abs(i-j) >= 2)
		// return false;
		// }
		// }
		//
		// return true;
	}
}
