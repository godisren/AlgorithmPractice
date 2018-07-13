package leecode.contest82;

import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

/**
 * 825. Friends Of Appropriate Ages
 *
 */
public class FriendsOfAppropriateAges {
	
	@Test
	public void test1(){
		/**
		 * Input: [16,16]
		 * Output: 2
		 * Explanation: 2 people friend request each other.
		 */
		int[] ages = {16, 16};
		Assert.assertEquals(2, new Solution().numFriendRequests(ages));
	}
	
	@Test
	public void test2(){
		/**
		 * Input: [16,17,18]
		 * Output: 2
		 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
		 */
		int[] ages = {16,17,18};
		Assert.assertEquals(2, new Solution().numFriendRequests(ages));
	}
	
	@Test
	public void test3(){
		/**
		 * Input: [20,30,100,110,120]
		 * Output: 3
		 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
		 */
		int[] ages = {20,30,100,110,120};
		Assert.assertEquals(3, new Solution().numFriendRequests(ages));
	}
	
	@Test
	public void test4(){
		/**
		 * Input: [101,56,69,48,30]
		 * 	   sort->[30,48,56,69,101]
		 * Output: 4
		 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
		 */
		int[] ages = {101,56,69,48,30};
		Assert.assertEquals(4, new Solution().numFriendRequests(ages));
	}
	
	@Test
	public void test5(){
		/**
		 * Input: [73,106,39,6,26,15,30,100,71,35,46,112,6,60,110]
		 * 	   sort->[30,48,56,69,101]
		 * Output: 29
		 * Explanation: 
		 */
		int[] ages = {73,106,39,6,26,15,30,100,71,35,46,112,6,60,110};
		Assert.assertEquals(29, new Solution().numFriendRequests(ages));
	}
	
	
	static class Solution {
		
		// invalid friend request rule:
        // age[B] <= 0.5 * age[A] + 7
        // age[B] > age[A]
        // age[B] > 100 && age[A] < 100  -> a>100 && b<100
		public int numFriendRequests(int[] ages) {
			int match = 0;
			Arrays.sort(ages);
			
			for(int i=ages.length-1;i>0;i--){
				int a = ages[i];
				int acceptAge = (int) ( Math.ceil(0.5 * a + 7));
				
				for(int j=i-1 ;j>=0 ;j--){
					int b = ages[j];
					
					System.out.println(String.format("a=%d, b=%d (accept:%d):%b"
							, a, b, acceptAge,
							 (a<100 && b>100) || b <= acceptAge));
					if(a==b)
						match++;
					else if((a<100 && b>100) || b <= acceptAge)
						break;
					
					match++;
				}
				
			}
			
			return match;
		}
		
		
	    public int numFriendRequests2(int[] ages) {
	    	int match = 0;
	    	for(int i = 0;i<ages.length-1;i++){
	    		int a = ages[i];
	    		for(int j= i+1;j<ages.length;j++){
	    			int b = ages[j];
	    			if(!invalieFriendRequest(a, b))
	    				match++;
	    			if(!invalieFriendRequest(b, a))
	    				match++;
	    		}
	    	}
	    	
	    	return match;
	    }
	    
	    private boolean invalieFriendRequest(int a, int b){
	    	// invalid friend request rule:
	        // age[B] <= 0.5 * age[A] + 7
	        // age[B] > age[A]
	        // age[B] > 100 && age[A] < 100
	    	return (b <= (0.5 * a + 7)) || 
	    			(b > a) ||
	    			(b > 100 && a < 100);
	    }
	}
}
