
import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 *  Given an input string, reverse the string word by word.
 *  
 *  For example,
 *  Given s = "the sky is blue",
 *  return "blue is sky the".
 */
public class A3_09_ReverseWordsTest {

	@Test
	public void test1() {
		Assert.assertEquals("bird a is this", reverseWords("this is a bird"));
	}

	@Test
	public void test2() {
		Assert.assertEquals("bird a is this", reverseWords("this is a  bird"));
	}

	public static String reverseWords(String s) {
		// return reverseWordsByString2Array(s);
		return reverseWordsByPoint(s);
	}

	public static String reverseWordsByPoint(String s) {
		int j = s.length();

		StringBuilder answer = new StringBuilder();
		for (int i = s.length() - 1; i >= 0; i--) {
			if (s.charAt(i) == ' ') {
				j = i;
			} else if (i == 0 || Character.isWhitespace(s.charAt(i - 1))) {
				answer.append(s.substring(i, j)).append(" ");
			}
		}

		return answer.toString().trim();
	}

	public static String reverseWordsByString2Array(String s) {
		String[] words = s.split("\\s+");
		String answer = "";
		for (int i = words.length - 1; i >= 0; i--) {
			answer += words[i] + " ";
		}

		return answer.trim();
	}
}
