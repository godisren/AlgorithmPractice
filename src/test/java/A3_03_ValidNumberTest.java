
import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * 
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 */
public class A3_03_ValidNumberTest {

	@Test
	public void test1() {
		Assert.assertEquals(true, isNumber("0"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(true, isNumber("0.1"));
	}

	@Test
	public void test3() {
		Assert.assertEquals(false, isNumber("abc"));
	}

	@Test
	public void test4() {
		Assert.assertEquals(false, isNumber("1 a"));
	}

	@Test
	public void test5() {
		Assert.assertEquals(true, isNumber("2e10"));
	}

	@Test
	public void test6() {
		Assert.assertEquals(false, isNumber("0xFF"));
	}

	@Test
	public void test7() {
		Assert.assertEquals(false, isNumber("1 2"));
	}

	@Test
	public void test8() {
		Assert.assertEquals(true, isNumber("+1"));
		Assert.assertEquals(true, isNumber("-1"));
	}

	/***** leecode example in below *****/
	@Test
	public void test9() {
		Assert.assertEquals(false, isNumber("e"));
	}

	@Test
	public void test10() {
		Assert.assertEquals(false, isNumber(" "));
	}

	@Test
	public void test11() {
		Assert.assertEquals(true, isNumber("1 "));
	}

	@Test
	public void test12() {
		Assert.assertEquals(true, isNumber(".1"));
	}

	@Test
	public void test13() {
		Assert.assertEquals(false, isNumber("0e"));
	}

	@Test
	public void test14() {
		Assert.assertEquals(true, isNumber("3."));
	}

	@Test
	public void test15() {
		Assert.assertEquals(false, isNumber("."));
	}

	@Test
	public void test16() {
		Assert.assertEquals(false, isNumber("6e6.5"));
	}

	@Test
	public void test17() {
		Assert.assertEquals(true, isNumber(" 005047e+6"));
	}

	@Test
	public void test18() {
		Assert.assertEquals(false, isNumber("4e+"));
	}

	// @Test
	// public void test19(){
	// Assert.assertEquals(true, isNumber("32.e-80123"));
	// }

	/***** leecode example end *****/

	public static boolean isNumber(String s) {
		/*
		 * �Y���ťզr�� => �ݳB�z �p���I => �ݳB�z ��ǰO�� => �ݳB�z string
		 * ���Ʀr�]����L�r�� => return false ���t�� => �ݳB�z �D�Q�i��Ʀr(ex: 0xFF)
		 * => return false ��Ʀr�������ť� => return false
		 */

		int i = 0, n = s.length();

		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}
		if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
			i++;
		}
		if (i < n && (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.')) {
			return false;
		}

		boolean isNumeric = false;

		// handle digit
		while (i < n && Character.isDigit(s.charAt(i))) {
			i++;
			isNumeric = true;
		}

		// handle dot
		if (i < n && s.charAt(i) == '.') {
			i++;
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
				isNumeric = true;
			}
		}

		if (!isNumeric)
			return false;

		// handle power
		// valid: 2e10, 2e+1234, 2e-1234 , 2e10
		// invalid: 6e6.5
		if (i < n && s.charAt(i) == 'e') {
			i++;
			if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
				i++;
			}
			if (i == n || (i < n && !Character.isDigit(s.charAt(i)))) {
				return false;
			}
			while (i < n && Character.isDigit(s.charAt(i))) {
				i++;
			}
		}

		while (i < n && Character.isWhitespace(s.charAt(i))) {
			i++;
		}

		return i == n;
	}
}
