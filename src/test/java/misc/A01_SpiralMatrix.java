package misc;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order. 
 * 
 * For example,
 * Given the following matrix: 
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * You should return [1,2,3,6,9,8,7,4,5]. 
 * 
 */
public class A01_SpiralMatrix {
	
	@Test
	public void test1(){
		int[][] matrix = new int[][]{
			{ 1, 2, 3 },
			{ 4, 5, 6 },
			{ 7, 8, 9 }
		};
		
		List<Integer> result = spiralOrder(matrix);
		
		Assert.assertEquals("123698745", toString(result));
	}
	
	@Test
	public void test2(){
		int[][] matrix = new int[][]{
			{ 6,9,7 }
		};
		
		List<Integer> result = spiralOrder(matrix);
		
		Assert.assertEquals("697", toString(result));
	}
	
	@Test
	public void test3(){
		int[][] matrix = new int[][]{
			{ 1 },
			{ 2 },
			{ 3 }
		};
		
		List<Integer> result = spiralOrder(matrix);
		
		Assert.assertEquals("123", toString(result));
	}
	
	
	private String toString(List<Integer> datas){
		StringBuffer sb = new StringBuffer();
		for(Integer d:datas){
			sb.append(String.valueOf(d));
		}
		
		return sb.toString();
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		
		List<Integer> result = new ArrayList<Integer>();
		
		if(matrix.length==0 || matrix[0].length ==0)
	            return result;
		
		// m(row), n(column)
		int m = matrix.length;
		int n = matrix[0].length;
		
		int x = -1;	// tricky point
		int y = 0;
		
		while(true){
			
			for(int i = 0;i<n;i++){
				result.add(matrix[y][++x]);
			}
			if( --m == 0) break;
			
			for(int i = 0;i<m;i++){
				result.add(matrix[++y][x]);
			}
			if( --n == 0) break;
			
			for(int i = 0;i<n;i++){
				result.add(matrix[y][--x]);
			}
			if( --m == 0) break;
			
			for(int i = 0;i<m;i++){
				result.add(matrix[--y][x]);
			}
			if( --n == 0) break;
		}

		return result;
	}
}
