package misc;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class A03_RomanToInteger {

	@Test
	public void test1(){
		Assert.assertEquals(3999, romanToInt("MMMCMXCIX"));
	}
	
	public static int romanToInt(String s) {
		Map<Character,Integer> map = new HashMap();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		int result = 0, pre= 0;
		for(char c : s.toCharArray()){
			int current = map.get(c);
			result += current > pre ? (current - pre*2) : current;
			pre = current;
		}
		
		return result;
    }
}
