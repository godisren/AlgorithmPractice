package others.array;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class FindFirstNonrepeatedChar {

	@Test
	public void test1() {
		Assert.assertEquals("o", findFirstNonrepeatedCharByEnhancing("total"));
		Assert.assertEquals("r", findFirstNonrepeatedCharByEnhancing("teeter"));
	}

	public String findFirstNonrepeatedChar(String str) {
		if (str == null || str.length() == 0)
			return null;

		// define a linked map to store characters from string in order.
		Map<Character, Integer> map = new LinkedHashMap();

		// iterate characters
		for (char c : str.toCharArray()) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}

		// find the first char match the condition that its value is 1
		for (Map.Entry<Character, Integer> entry : map.entrySet())
			if (entry.getValue() == 1)
				return String.valueOf(entry.getKey());

		// space complex : O(n)
		// time complex : O(2n) -> O(n)

		return null;
	}
	
	public String findFirstNonrepeatedCharByEnhancing(String str) {
		if (str == null || str.length() == 0)
			return null;

		// enhance:
		// 1.instead of using increment by Integer value, using distinct object to see if appear once
		// 2.using String.codePointAt() to avoid unicode outside BMP
		
		Object seeOnce = new Object();
		Object seeMore = new Object();
		
		// define a linked map to store characters from string in order.
		Map<Integer, Object> map = new LinkedHashMap();

		// iterate characters
		int i = 0;
		for(;i<str.length();){
			int cp = str.codePointAt(i);
			i+= Character.charCount(cp);
			if(map.containsKey(cp)){
				map.put(cp, seeMore);
			}else{
				map.put(cp, seeOnce);
			}
		}		

		// find the first char match the condition that its value is 1
		for (Map.Entry<Integer, Object> entry : map.entrySet())
			if (entry.getValue() == seeOnce)
				return new String(Character.toChars(entry.getKey())); 

		// space complex : O(n)
		// time complex : O(2n) -> O(n)

		return null;
	}

	@Test
	public void testUnicodeInSMP(){
		// SMP
		// "𐐂" = "\uD801\uDC02"
		String s = new String("𐐂");
		System.out.println(s +",char len:"+s.length());
		for(char c:s.toCharArray()){
			System.out.println(c);
		}
		final int cp = s.codePointAt(0);
		System.out.println("cp:"+cp+",count:"+Character.charCount(cp));
		System.out.println("str:"+new String(Character.toChars(cp)));		
	}
}
