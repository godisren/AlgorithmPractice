
import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, 
 * or -1 if needle is not part of haystack. 
 */
public class A3_04_StrStrTest {

	@Test
	public void test1() {
		int startIdx = strStr("this a book.", "a book");

		Assert.assertEquals(5, startIdx);
	}

	@Test
	public void test2() {
		int startIdx = strStr("this a book.", "a book.s");

		Assert.assertEquals(-1, startIdx);
	}

	@Test
	public void test3() {
		int startIdx = strStr("this a book.", "this");

		Assert.assertEquals(0, startIdx);
	}

	@Test
	public void test4() {
		int startIdx = strStr("this a book.", "thisA");

		Assert.assertEquals(-1, startIdx);
	}

	@Test
	public void test5() {
		int startIdx = strStr("", "");

		Assert.assertEquals(0, startIdx);
	}

	// like java String.indexOf(), O(nm)
	public int strStr(String haystack, String needls) {

		for (int i = 0; i <= haystack.length(); i++) {
			for (int j = 0; j <= needls.length(); j++) {
				int hIdx = i + j;

				if (j == needls.length())
					return i;

				if (hIdx == haystack.length())
					return -1;

				if (haystack.charAt(hIdx) != needls.charAt(j))
					break;
			}

			// stone original:
			// int j = 0;
			// while(true){
			// if(j==needlsLastIdx)
			// return i;
			//
			// if( i+j >=haystack.length()-1 )
			// break;
			//
			// if(haystack.charAt(i+j) == needls.charAt(j)){
			// j++;
			// continue;
			// }
			//
			// break;
			// }
		}

		throw new IllegalArgumentException("no solution.");
	}
}
