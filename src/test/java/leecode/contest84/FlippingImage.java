package leecode.contest84;

import org.junit.Test;

public class FlippingImage {
	
	@Test
	public void test1(){
//		Input: [[1,1,0],[1,0,1],[0,0,0]]
//		Output: [[1,0,0],[0,1,0],[1,1,1]]
//		Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
//		Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
		
		int[][] A = new int[][]{
			{1,1,0},{1,0,1},{0,0,0}
		};
		
		printArray(A);
		
		int[][] result = new Solution().flipAndInvertImage(A);
		System.out.println("result:");
		printArray(result);
	}

	private void printArray(int[][] arrays) {
		for(int[] cols: arrays){
			for(int col:cols)
				System.out.print(col+",");
			System.out.println("");
		}
	}
	
	class Solution {
	    public int[][] flipAndInvertImage(int[][] A) {
	        for(int[] col: A){
	        	int tmp;
	        	int start = 0;
	        	int end = col.length-1;
	        	
	        	while(start<=end){
	        		tmp = not(col[start]);
		        	col[start] = not(col[end]);
		        	col[end] = tmp;
		        	start++;
		        	end--;
	        	}
	        }
	        
	        return A;
	    }
	    
	    private int not(int v){
	    	if(v==0)
	    		return 1;
	    	else 
	    		return 0;
	    	
	    }
	}
}
