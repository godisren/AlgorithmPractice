package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Climbing Stairs
 * 
 * Question:
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways 
 * can you climb to the top?
 * 
 * Note: Given n will be a positive integer. 
 *
 * Example 1:
 * Input: 2
 * Output:  2
 * Explanation:  There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * 
 * Example 2:
 * Input: 3
 * Output:  3
 * Explanation:  There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 * 
 */
public class A01_ClimbingStairs {
	
	@Test
	public void test1(){
		Assert.assertEquals(2 ,climbStairs(2));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(3 ,climbStairs(3));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals(5 ,climbStairs(4));
	}
	
	public int climbStairs(int n){
		return new Solution().climbStairs(n);
	}
	
	class Solution{
		public int climbStairs(int n) {
			// n:  f(n-1) + f(n-2)
			if(n<3)
				return n;
			
			// start from 3
			int first = 2;
			int second = 1;
			int answer = 0;
			
			for(int i=3;i<=n;i++){
				answer = first + second;
				second = first;
				first = answer;
			}
			
			return answer;
		}
	}
	
	class SolutionRecursiveWithCache {
		Map<Integer, Integer> cache = new HashMap<>();
		
		public int climbStairs(int n) {
			
			if(n<3)
				return n;
			else{
				Integer n1 = cache.get(n-1);
				if(n1==null){
					n1 = climbStairs(n - 1);
					cache.put(n-1, n1);
				}
				
				Integer n2 = cache.get(n-2);
				if(n2==null){
					n2 = climbStairs(n - 2);
					cache.put(n-2, n2);
				}
				
				return n1 + n2;
			}	
	    }
	}
	
	// recursive
	class SolutionRecursive {
		public int climbStairs2(int n) {
			if(n==0)
				return 0;
			else if(n==1)
				return 1;
			else if(n==2)
				return 2;
			else{
				return climbStairs(n - 1)
					+ climbStairs(n - 2);
			}	
	    }
	}
}
