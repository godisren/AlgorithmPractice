package leecode;

import org.junit.Assert;
import org.junit.Test;

public class MinimumDeleteSum2 {

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
		
		Assert.assertEquals(403, minimumDeleteSum("delete", "leet"));
		// let (minimum answer)
		// lee	
	}
	
	@Test
	public void test3(){
		// Input: s1 = "delete", s2 = "leet"
		// Output: 403
		
		Assert.assertEquals(1638, minimumDeleteSum("sjfqkfxqoditw" , "fxymelgo"));
		// let (minimum answer)
		// lee	
	}
	
	public static int minimumDeleteSum(String s1, String s2) {
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		int r1= isEquals(c1,c2);
		int r2= isEquals(c2,c1);
		
		
		
		return Math.min(r1,r2);
    }
	
	public static int isEquals(char[] c1, char[] c2){
		
		int min = Integer.MAX_VALUE;
		for(int start=0;start<c1.length;start++){
			int partSum = 0;
			
			for(int k = 0;k<start;k++){
				partSum += (int)c1[k];
			}
			
			boolean isFind = false;
//			StringBuffer sb = new StringBuffer();
			int i = start, j=0;
			while(i<c1.length && j<c2.length){
//				System.out.println(String.format("c1=%c, c2=%c", c1[i], c2[j]));
				if(c1[i] == c2[j]){
					i++; j++;
//					sb.append(c1[i]);
					isFind = true;
				}else{
					partSum += (int)c2[j];
					j++;
				}
			}
			
			while(j < c2.length) partSum += (int)c2[j++];
			while(i < c1.length) partSum += (int)c1[i++];
			
			if(isFind){
//				partSum += (int)c1[start];
				
				min = Math.min(min, partSum);
			}
			
//			System.out.println(min);
			
			
		}
		
		return min;
	}
	
	
}
