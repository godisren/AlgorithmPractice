package leecode.contest83;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import org.junit.Assert;

public class PositionsOfLargeGroups {
	
	@Test
	public void test1(){
		// Input: "abbxxxxzzy"
		// Output: [[3,6]]
		// Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
		String S = "abbxxxxzzy";
		List<List<Integer>> result = new Solution().largeGroupPositions(S);
		String sb = toString(result);
		System.out.println(sb);
//		Assert.assertEquals("[3,6]", "[3,6]");
	}
	
	@Test
	public void test2(){
		// Input: "abc"
		// Output: []
		// Explanation: We have "a","b" and "c" but no large group.
		String S = "abc";
		List<List<Integer>> result = new Solution().largeGroupPositions(S);
		String sb = toString(result);
		System.out.println(sb);
//		Assert.assertEquals("[3,6]", "[3,6]");
	}
	
	@Test
	public void test3(){
		// Input: "abcdddeeeeaabbbcd"
		// Output: [[3,5],[6,9],[12,14]]
		String S = "abcdddeeeeaabbbcd";
		List<List<Integer>> result = new Solution().largeGroupPositions(S);
		String sb = toString(result);
		System.out.println(sb);
//		Assert.assertEquals("[3,6]", "[3,6]");
	}

	private String toString(List<List<Integer>> result) {
		StringBuffer sb = new StringBuffer();
		for(List<Integer> a:result){
			sb.append("[");
			for(Integer b:a){
				sb.append(b+",");
			}
			if(sb.lastIndexOf(",")==sb.length()-1)
				sb.deleteCharAt(sb.length()-1);
			sb.append("]");
		}
		return sb.toString();
	}
	
	static class Solution {
	    public List<List<Integer>> largeGroupPositions(String S) {
	    	List<List<Integer>> result = new ArrayList();
	    	char[] chars = S.toCharArray();
	    	int i = 0;
	    	int startPos;
	    	char curChar;
	    	while (i<chars.length){
	    		startPos = i;
	    		curChar = chars[i++];
	    		
	    		int dupNum = 1;
	    		while(i<chars.length && curChar == chars[i]){
	    			dupNum++;
	    			i++;
	    		}
	    		
	    		// keep start and end position if a large group
	    		if(dupNum>=3)
	    			result.add(toRangeList(startPos, i-1));
	    	}
	        
	    	return result;
	    }
	    
	    private static List<Integer> toRangeList(int s, int e){
	    	List<Integer> ranges = new ArrayList();
	    	ranges.add(s);
	    	ranges.add(e);
	    	
	    	return ranges;
	    }
	}
}
