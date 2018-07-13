package others.array;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class Integer2String {

	@Test
	public void test1() {
		Assert.assertEquals("123", covertIng(123));
		Assert.assertEquals("-123", covertIng(-123));
		Assert.assertEquals("0", covertIng(0));
	}

	
	
	public String covertIng(int num) {
		// 10 is enough to store number
		char[] digits = new char[10];
		
		boolean sign = num >= 0 ? true : false;
		int idx = 0;
		
		while(idx <digits.length){
			digits[idx] = toChar(num % 10);
			num = num /10;
			if(num== 0)
				break;
			
			idx++;
		}
		
		StringBuffer sb = new StringBuffer();
		if(!sign)
			sb.append('-');
		
		while(idx>=0){
			sb.append(digits[idx--]);
		}
		
		return sb.toString();
		
	}



	private char toChar(int n) {
		
		return (char) (Math.abs(n) + '0');
	}
}
