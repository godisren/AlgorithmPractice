
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * Qeustion:
 *  The API: int read4(char *buf) reads 4 characters at a time from a file.
 *  The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.
 *  By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
 *  
 *  Note:
 *  The read function will only be called once for each test case.
 */
public class A3_13_ReadNCharactersTest {

	@Test
	public void test1() {
		char[] input = "abcdef".toCharArray();
		int n = 3;
		char[] buf = new char[n];

		Reader4Simulator reader = new Reader4Simulator(input);
		int result = read(buf, n, reader);

		Assert.assertEquals(n, result);
		Assert.assertEquals("abc", String.valueOf(buf).trim());
	}

	@Test
	public void test2() {
		char[] input = "abcdef".toCharArray();
		int n = 8;
		char[] buf = new char[n];

		Reader4Simulator reader = new Reader4Simulator(input);
		int result = read(buf, n, reader);

		Assert.assertEquals(6, result);
		Assert.assertEquals("abcdef", String.valueOf(buf).trim());
	}

	@Test
	public void test3() {
		char[] input = "".toCharArray();
		int n = 8;
		char[] buf = new char[n];

		Reader4Simulator reader = new Reader4Simulator(input);
		int result = read(buf, n, reader);

		Assert.assertEquals(0, result);
		Assert.assertEquals("", String.valueOf(buf).trim());
	}

	public static int read(char[] buf, int n, Reader4Simulator reader) {
		// int readN = 0;
		int readTotal = 0;
		char[] tempBuf = new char[4];
		while (readTotal < n) {
			int count = reader.read4(tempBuf);

			count = Math.min(count, n - readTotal);

			System.arraycopy(tempBuf, 0, buf, readTotal, count);

			readTotal += count;

			if (count < 4) {
				// eof
				break;
			}
		}

		return readTotal;
	}

	public class Reader4Simulator {
		private char[] testBuf;
		private int read4Point = 0;

		public Reader4Simulator(char[] testBuf) {
			super();
			this.testBuf = testBuf;
		}

		public int read4(char[] buf) {
			int range = 4;
			if (read4Point > buf.length) {
				buf = new char[range];
				return 0;
			}

			if (read4Point + range >= testBuf.length) {
				range = testBuf.length - read4Point;
			}

			Arrays.fill(buf, 0, buf.length, '\0');
			System.arraycopy(testBuf, read4Point, buf, 0, range);

			read4Point += range;

			return range;
		}

	}
}
