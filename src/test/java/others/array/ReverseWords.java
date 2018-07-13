package others.array;

import org.junit.Test;
import org.junit.Assert;

public class ReverseWords {
	
	@Test
	public void tset1(){
		Assert.assertEquals("try. no is there not, do or Do"
				, reverseWithoutBuffer2("Do or do not, there is no try."));
	}
	
	public String reverse(String str){
		String[] strs = str.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int i = strs.length-1; i>=0; i--){
			sb.append(strs[i]);
			if(i>0)
				sb.append(" ");
		}
		return new String(sb.toString());
	}
	
	public String reverseWithoutBuffer2(String str){
		char[] chars = str.toCharArray();
		reverseArray(chars, 0, chars.length-1);
		
		//System.out.println(new String(chars));
		
		int start = 0;
		int i = 0;
		while(i<=chars.length){
			if(i==chars.length || Character.isSpaceChar(chars[i])){
				reverseArray(chars, start, i-1);
				start = i+1;
			}
			
			i++;
		}
		
		return new String(chars);
	}
	
	private void reverseArray(char[] chars, int start, int end){
		while(start<end){
			char t = chars[start];
			chars[start]  = chars[end];
			chars[end]  = t;
			
			start++;
			end--;
		}		
	}
}
