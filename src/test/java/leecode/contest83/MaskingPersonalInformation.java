package leecode.contest83;

import org.junit.Test;
import org.junit.Assert;

public class MaskingPersonalInformation {
	
	@Test
	public void test1(){
//		Input: "LeetCode@LeetCode.com"
//		Output: "l*****e@leetcode.com"
//		Explanation: All names are converted to lowercase, and the letters between the
//		             first and last letter of the first name is replaced by 5 asterisks.
//		             Therefore, "leetcode" -> "l*****e".
		String S = "LeetCode@LeetCode.com";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("l*****e@leetcode.com", result);
	}
	
	@Test
	public void test2(){
//		Input: "AB@qq.com"
//		Output: "a*****b@qq.com"
//		Explanation: There must be 5 asterisks between the first and last letter 
//		             of the first name "ab". Therefore, "ab" -> "a*****b".
		String S = "AB@qq.com";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("a*****b@qq.com", result);
	}
	
	@Test
	public void test3(){
//		Input: "1(234)567-890"
//		Output: "***-***-7890"
//		Explanation: 10 digits in the phone number, which means all digits make up the local number.
		String S = "1(234)567-890";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("***-***-7890", result);
	}
	
	@Test
	public void test4(){
//		Input: "86-(10)12345678"
//		Output: "+**-***-***-5678"
//		Explanation: 12 digits, 2 digits for country code and 10 digits for local number.
		String S = "86-(10)12345678";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("+**-***-***-5678", result);
	}
	
	@Test
	public void test5(){
//		Input: "+(501321)-50-23431"
//		Output: "+***-***-***-3431"
		String S = "+(501321)-50-23431";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("+***-***-***-3431", result);
	}
	
	@Test
	public void test6(){
//		Input: "+86(88)1513-7-74"
//		Output: "+*-***-***-3774"
		String S = "+86(88)1513-7-74";
		String result = new Solution().maskPII(S);
		
		Assert.assertEquals("+*-***-***-3774", result);
	}
	
	class Solution {
	    public String maskPII(String S) {
	        if(S.indexOf("@")>0)
	        	return maskEmail(S);
	        else
	        	return maskPhone(S);
	    }
	    
	    String maskPhone(String S){
	    	char[] chars = S.toCharArray();
	    	StringBuilder sb = new StringBuilder();
	    	for(char c:chars)
	    		if(Character.isDigit(c))
	    			sb.append(c);
	    	
	    	StringBuilder result = new StringBuilder();
	    	if(sb.length()==10)
	    		// local number(10 digits) mask format: ***-***-1111
	    		result.append("***-***-");
	    	else{
	    		// more than 10 digits
	    		// ex.with country(12 digits) code mask format: +**-***-***-1111
	    		result.append("+");
	    		int countryCount = sb.length() - 10;
	    		for(int i=0;i<countryCount;i++)
	    			result.append("*");
	    		result.append("-***-***-");
	    	}
	    	
	    	result.append(sb.substring(sb.length()-4, sb.length()));
	    	return result.toString();
	    		
	    }
	    
	    String maskEmail(String S){
	    	// define :
	    	// s.length ≥ 2
	    	// All email addresses are guaranteed to be valid and in the format of "name1@name2.name3".
	    	
	    	// all names must be converted to lowercase and 
	    	// all letters between the first and last letter of the first name must be replaced by 5 asterisks '*'
	    	String[] emailTokens = S.split("@");
	    	String firstName = emailTokens[0];
	    	StringBuffer sb = new StringBuffer();
	    	sb.append(firstName.charAt(0));
	    	sb.append("*****");
	    	sb.append(firstName.charAt(firstName.length()-1));
	    	sb.append("@").append(emailTokens[1]);
	    	
	    	return sb.toString().toLowerCase();
	    	
	    }
	}
}
