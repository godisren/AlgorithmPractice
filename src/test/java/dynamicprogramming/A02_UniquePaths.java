package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unique Paths
 * 
 * Question:
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot is trying 
 * to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * 
 * How many possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 */
public class A02_UniquePaths {
	
	@Test
	public void test1(){
		Assert.assertEquals(2 ,uniquePaths(2,2));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals(3 ,uniquePaths(3,2));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals(28 ,uniquePaths(3,7));
	}

	public int uniquePaths(int m, int n) {
        int[][] grid = new int[m+1][n+1];
        
        grid[m][n-1] = 1;
        
        for(int col = n-1; col>=0;col--){
        	for(int row = m-1; row>=0; row--){
        		grid[row][col] = grid[row+1][col] + grid[row][col+1];
        	}
        }
        
        return grid[0][0];
    }
}
