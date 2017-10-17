
import org.junit.Assert;
import org.junit.Test;

/**
 *  Qeustion:
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *  
 *  For example,
 *  "A man, a plan, a canal: Panama" is a palindrome.
 *  "race a car" is not a palindrome.
 *  
 *  Note:
 *  Have you consider that the string might be empty? This is a good question to ask during an interview.
 *  
 *  For the purpose of this problem, we define empty string as valid palindrome.
 */
public class A3_06_ValidPalindromeTest {

	@Test
	public void test() {
		String test = "A man, a plan, a canal: Panama";
		Assert.assertTrue(isPalindrome(test));
	}

	@Test
	public void test2() {
		String test = "12328";
		Assert.assertFalse(isPalindrome(test));
	}

	@Test
	public void test3() {
		String test = "123321";
		Assert.assertTrue(isPalindrome(test));
	}

	@Test
	public void test4() {
		String test = "12321";
		Assert.assertTrue(isPalindrome(test));
	}

	public static boolean isPalindrome(String s) {
		// char[] chars = s.toLowerCase().toCharArray();

		int start = 0;
		int last = s.length() - 1;

		while (start < last) {

			// if using 'continue' operation, that may check first condition
			// multiple times till second condition pass

			while (start < last && !Character.isLetterOrDigit(s.charAt(start))) {
				start++;
				// continue;
			}

			while (start < last && !Character.isLetterOrDigit(s.charAt(last))) {
				last--;
				// continue;
			}

			if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(last)))
				return false;

			start++;
			last--;
		}

		return true;
	}

	public static boolean isAlphanumeric(char c) {
		return ('a' < c && c < 'z') || ('0' < c && c < '9') || ('A' < c && c < 'Z');
	}
}
