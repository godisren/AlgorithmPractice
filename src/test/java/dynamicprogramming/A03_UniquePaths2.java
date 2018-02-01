package dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unique Paths II
 * 
 * Question:
 * 
 * Follow up for "Unique Paths":
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths 
 * would there be?
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * For example,
 * 
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * 
 * Note: m and n will be at most 100.
 */
public class A03_UniquePaths2 {
	
	@Test
	public void test1(){
		int[][] grid = new int[][]{
			{0,0,0},
			{0,1,0},
			{0,0,0}
		};
		
		Assert.assertEquals(2 ,uniquePathsWithObstacles(grid));
	}
	
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		if(m == 0)
			return 0;
		int n = obstacleGrid[0].length;
		
        int[][] grid = new int[m+1][n+1];
        
        grid[m][n-1] = 1;
        
        for(int col = n-1; col>=0;col--){
        	for(int row = m-1; row>=0; row--){
        		if(obstacleGrid[row][col]==1){
        			grid[row][col] = 0;
        		}else{
        			grid[row][col] = grid[row+1][col] + grid[row][col+1];
        		}
        	}
        }
        
        return grid[0][0];
    }
}
