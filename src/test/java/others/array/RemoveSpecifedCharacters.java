package others.array;

import org.junit.Test;

import org.junit.Assert;

public class RemoveSpecifedCharacters {
	
	@Test
	public void test1(){
		Assert.assertEquals( "Bttl f th Vwls: Hw vs. Grzny",
				removeChars("Battle of the Vowels: Hawaii vs. Grozny", "aeiou"));
	}
	
	/**
	 * assume the length of 'str' N, the length of 'remove' M
	 * the flags needs to be set True in which the character appears in 'remove'
	 * for following step to determine to delete
	 * so, first we iterate 'remove' characters to set them, it's M times
	 * 
	 * then iterating 'str' all characters to determine which character should be delete
	 * it will takes N times
	 * so the time complex is O(N+M)
	 * 
	 * note:
	 * if the string contains Unicode string, it is good to use HasMap instead of Array
	 * to keep removed character
	 *  
	 */
	public String removeChars(String str, String remove){
		char[] chars = str.toCharArray();
		// primitive boolean initialized to false
		// size of 128  assumes ASCII 
		boolean[] flags = new boolean[128];
				
		for(char c: remove.toCharArray()){
			flags[c] = true;
		}
		
		int start = 0;
		for(int i = 0;i< chars.length;i++){
			if( !flags[chars[i]]){
				chars[start++] =  chars[i];
			}
		}
		
		return new String(chars, 0, start);
	}
}
