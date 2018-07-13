package leecode.contest85;

import org.junit.Assert;
import org.junit.Test;

public class RectangleOverlap {
	
	@Test
	public void test1(){
//		Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
//		Output: true
		
		Assert.assertTrue(new Solution().isRectangleOverlap(new int[]{0,0,2,2},new int[]{1,1,3,3}));
	}
	
	@Test
	public void test2(){
//		Input: rec1 = [2,17,6,20], rec2 = [3,8,6,20]
//		Output: true
		
		Assert.assertTrue(new Solution().isRectangleOverlap(new int[]{2,17,6,20},new int[]{3,8,6,20}));
	}
	
	@Test
	public void test3(){
//		Input: rec1 = [4,4,14,7], rec2 = [4,3,8,8]
//		Output: true
		
				
		Assert.assertTrue(new Solution().isRectangleOverlap(new int[]{4,4,14,7},new int[]{4,3,8,8}));
	}
			

	class Solution {
	    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
	        // TODO find low & high point
	    	int rec1x1 = rec1[0];
	    	int rec1y1 = rec1[1];
	    	int rec1x2 = rec1[2];
	    	int rec1y2 = rec1[3];
	    	
	    	int rec2x1 = rec2[0];
	    	int rec2y1 = rec2[1];
	    	int rec2x2 = rec2[2];
	    	int rec2y2 = rec2[3];
	    	
	    	//switch if lower
	    	if(rec1x1 > rec2x1 && rec1y1 > rec2y1){
	    		 rec1x1 = rec2[0];
		    	 rec1y1 = rec2[1];
		    	 rec1x2 = rec2[2];
		    	 rec1y2 = rec2[3];
		    	
		    	 rec2x1 = rec1[0];
		    	 rec2y1 = rec1[1];
		    	 rec2x2 = rec1[2];
		    	 rec2y2 = rec1[3];
	    	}
	    	
	    	return isPoint2StartOverlap(rec1x1,rec1y1,rec1x2,rec1y2,rec2x1,rec2y1) ||
	    			isPoint2EndOverlap(rec1x1,rec1y1,rec1x2,rec1y2,rec2x2,rec2y2) ||
	    			isOtherOverlap(rec1x1,rec1y1,rec1x2,rec1y2,rec2x1,rec2y1,rec2x2,rec2y2);
	    }
	    
	    private boolean isPoint2StartOverlap(int rec1x1,int rec1y1,int rec1x2,int rec1y2, int pointX, int pointY){
	    	if(rec1x1==pointX &&rec1y2==pointY )
	    		return true;
	    	
	    	if(rec1x1==pointX && pointY > rec1y1 && pointY <rec1y2)
	    		return true;
	    	
	    	if(rec1y1==pointY && pointX > rec1x1 && pointX <rec1x2)
	    		return true;
	    	
	    	if(pointY > rec1y1 && pointY <rec1y2 && pointX > rec1x1 && pointX <rec1x2)
	    		return true;
	    	
	    	return false;
	    }
	    
	    private boolean isPoint2EndOverlap(int rec1x1,int rec1y1,int rec1x2,int rec1y2, int pointX, int pointY){
	    	if(rec1x2==pointX &&rec1y2==pointY )
	    		return true;
	    	
	    	if(rec1x2==pointX && pointY > rec1y1 && pointY <= rec1y2)
	    		return true;
	    	
	    	if(rec1y1==pointY && pointX > rec1x1 && pointX <=rec1x2)
	    		return true;
	    	
	    	if(pointY > rec1y1 && pointY <rec1y2 && pointX > rec1x1 && pointX <rec1x2)
	    		return true;
	    	
	    	return false;
	    }
	    
	    private boolean isOtherOverlap(int rec1x1,int rec1y1,int rec1x2,int rec1y2, int pointX, int pointY, int pointX2, int pointY2){
	    	if(pointX >= rec1x1 && pointX <rec1x2 && 
	    			pointY2> rec1y1)
	    		return true;
	    	
	    	if(pointY >= rec1y1 && pointY <rec1y2 && 
	    			pointX2> rec1x1)
	    		return true;
	    	
	    	return false;
	    }
	    
	}
}
