import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * Implement pow(x, n). 
 */
public class A2_02_PowTest {

	@Test
	public void test1() {
		Assert.assertEquals(1.0, pow(2, 0), 0);
	}

	@Test
	public void test2() {
		Assert.assertEquals(16.0, pow(2, 4), 0);
	}

	public static double pow(double x, int n) {
		if (n == 0)
			return 1;

		// int overflow
		if (n == Integer.MIN_VALUE) {
			x *= x;
			n = n / 2;
		}

		if (n < 0) {
			n *= -1;
			x = 1 / x;
		}

		if (n % 2 == 0) {
			// pow(2,4) = pow(4,2)
			// pow(2,6) = 2^3 * 2^3 = pow(4,3)
			// pow(3,4) = 3^2 * 3^2 = 9 * 9 = pow(9,2)
			return pow(x * x, n / 2);
		} else {
			// pow(4,3) = 4*4*4 = 4 * 4^2 = 4 * pow(4,2)
			return x * pow(x * x, n / 2);
		}
	}
}

