package leecode.contest82;

import org.junit.Test;

import org.junit.Assert;

/**
 * 824. Goat Latin
 *
 */
public class GoatLatin {
	
	@Test
	public void test1(){
		Assert.assertEquals("applemaa",new Solution().toGoatLatin("apple"));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals("oatgmaa",new Solution().toGoatLatin("goat"));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals("Imaa peaksmaaa oatGmaaaa atinLmaaaaa",new Solution().toGoatLatin("I speak Goat Latin"));
	}
	
	@Test
	public void test4(){
		Assert.assertEquals("heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
				,new Solution().toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}
	
	static class Solution {
		
		/**
		 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
		 * 1 <= S.length <= 100.
		 */
	    public String toGoatLatin(String S) {
	    	String[] tokens =  S.split(" ");

	    	// consider out of index exception
	    	StringBuffer result = new StringBuffer();
	    	StringBuffer aPostfix = new StringBuffer();
	    	for(int i = 0;i<tokens.length;i++){
	    		StringBuffer newWord = new StringBuffer();
	    		char[] token = tokens[i].toCharArray();
	    		
	    		if(isVowel(token[0])){
	    			// If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
	    			// For example, the word 'apple' becomes 'applema'.
	    			for(int j=0;j<token.length;j++)
	    				newWord.append(token[j]);
	    		}else{
	    			// If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, 
	    			// then add "ma".
		    		// For example, the word "goat" becomes "oatgma".
	    			for(int j=1;j<token.length;j++)
	    				newWord.append(token[j]);
	    			
	    			newWord.append(token[0]);
	    		}
	    				
	    		newWord.append("ma");
	    		
	    		// Add one letter 'a' to the end of each word per its word index in the sentence
	    		aPostfix.append("a");
	    		
	    		result.append(newWord).append(aPostfix).append(" ");
	    	}

	        return result.toString().trim();
	    }
	    
	    static private boolean isVowel(char c){
	    	return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' 
    				|| c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U' );
	    }
	} 
}
