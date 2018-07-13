package leecode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class MinimumDeleteSum {

	@Test
	public void test1(){
		// Input: s1 = "sea", s2 = "eat"
		// Output: 231
		
		Assert.assertEquals(231, minimumDeleteSum("sea", "eat"));
	}
	
	@Test
	public void test2(){
		// Input: s1 = "delete", s2 = "leet"
		// Output: 403
		
		Assert.assertEquals(231, minimumDeleteSum("delete", "leet"));
		// let (minimum answer)
		// lee
	}
	
	public static int minimumDeleteSum(String s1, String s2) {
		
		List<Integer> s1R = removeCandidateIndexes(s1, s2);		
		List<Integer> s2R = removeCandidateIndexes(s2, s1);
		
		System.out.println(s1R);
		System.out.println(s2R);
		
//		if(s1R.isEmpty() && s2R.isEmpty())
//			return 0;
		
		
		
		String newS1 = getStringByRemove(s1,s1R);
		String newS2 = getStringByRemove(s2,s2R);
		
		System.out.println(newS1);
		System.out.println(newS2);
		
		int s1RLength=0;
		int s2RLength=0;
		
		// || (!s1R.isEmpty() && !s2R.isEmpty())
//		while(!newS1.equals(newS2)){
//			// delete character by Length comparison
//			if(newS1.length() == newS2.length()){
//				newS1 = getStringByRemove(s1, s1R, ++s1RLength);
//				newS2 = getStringByRemove(s2, s2R, ++s2RLength);
//			}else if(newS1.length() > newS2.length()){
//				newS1 = getStringByRemove(s1, s1R, ++s1RLength);
//			}else if(newS1.length() < newS2.length()){
//				newS2 = getStringByRemove(s2, s2R, ++s2RLength);
//			}
//			
//			System.err.println(newS1 +","+newS2);
//		}
		
		
		
		int sum = 0;
		for(int i = 0;i<s1R.size();i++){
			sum += (int)s1.charAt(s1R.get(i));
		}
		for(int i = 0;i<s2R.size();i++){
			sum += (int)s2.charAt(s2R.get(i));
		}
		
        return sum;
    }
	
	public static String getStringByRemove(String s, List<Integer> removeIndexes){
		StringBuffer sb = new StringBuffer(s);
		for(int i=removeIndexes.size()-1;i>=0;i--){
			sb.deleteCharAt(removeIndexes.get(i));
		}
		
		return sb.toString();
	}
	
	public static List<Integer> removeCandidateIndexes(String s1, String s2){
		List<Integer> r = new ArrayList<Integer>();
//		int startJ=0;
		for(int i = 0;i < s1.length();i++){
			for(int j = 0; j< s2.length();j++){
				if(s1.charAt(i) ==  s2.charAt(j)){
//					startJ++;
					break;
				}
				
				// last one
				if(j == s2.length()-1){
					r.add(i);
				}
			}
		}
		
		return r;
	}
}
