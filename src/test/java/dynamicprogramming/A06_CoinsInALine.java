package dynamicprogramming;

import org.junit.Test;
import org.junit.Assert;

/**
 * 
 * Coins in a Line
 * 
 * Question:
 * There are n coins in a line. Two players take turns to take one or two coins 
 * from right side until there are no more coins left. The player who take the last coin wins.
 * Could you please decide the first play will win or lose?
 * 
 * Example
 * n = 1, return true.
 * n = 2, return true.
 * n = 3, return false.
 * n = 4, return true.
 * n = 5, return true.
 *
 */
public class A06_CoinsInALine {

	@Test
	public void test1(){
		Assert.assertEquals(true, firstWillWin(1));
		Assert.assertEquals(true, firstWillWin(2));
		Assert.assertEquals(false, firstWillWin(3));
		Assert.assertEquals(true, firstWillWin(4));
		Assert.assertEquals(true, firstWillWin(5));
		
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(false, firstWillWin(6));
	}
	
	public static boolean firstWillWin(int n){
//		return firstWillWin2(n);
		return firstWillWinDp(n);
//		return firstWillWinMath(n);
	}
	
	
	public static boolean firstWillWinMath(int n) {
		return (n%3) != 0;
	}
	
	public static boolean firstWillWinDp(int n) {
		boolean[] dp = new boolean[n+1];
		if(n>=0) dp[0] = false;
		if(n>=1) dp[1] = true;
		if(n>=2) dp[2] = true;
		
		for(int i = 3;i<=n;i++){
			dp[i] = !dp[i-1] || !dp[i-2];
		}
		
		return dp[n];
	}
	
	public static boolean firstWillWin2(int n) {
		boolean first = true;
		boolean second = true;
		boolean third = false;
		
		if(n==0) return false;
		if(n==1) return first;
		if(n==2) return second;
		if(n==3) return third;
		
		for(int i=4;i<=n;i++){
			first = second;
			second = third;
			third = !first || !second;
			
			System.out.println(String.format("%d:%b %b %b", i, first, second, third));
		}
		
		return third;
	}
}
