package leecode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;


public class SimilarRGB {

	@Test
	public void test(){
		Assert.assertEquals("#11ee66",new Solution().similarRGB("#09f166"));
	}
	
	@Test
	public void test2(){
		Assert.assertEquals("#5544dd",new Solution().similarRGB("#4e3fe1"));
	}
	
	@Test
	public void test3(){
		Assert.assertEquals("#22ff66",new Solution().similarRGB("#22f966"));
	}
	
	@Test
	public void test4(){
		Assert.assertEquals("#229900",new Solution().similarRGB("#1c9e03"));
	}
	
	
	static public class  Solution {
		public static List<Integer> cc = new ArrayList();
		static{
			cc.add(00);//"00");
			cc.add(17);//"11");
			cc.add(34);//"22");
			cc.add(51);//"33");
			cc.add(68);//"44");
			cc.add(85);//"55");
			cc.add(102);//"66");
			cc.add(119);//"77");
			cc.add(136);//"88");
			cc.add(153);//"99");
			cc.add(170);//"aa");
			cc.add(187);//"bb");
			cc.add(204);//"cc");
			cc.add(221);//"dd");
			cc.add(238);//"ee");
			cc.add(255);
		}
		
	    public String similarRGB(String color) {
	    	
	    	int r = hexToInt(color.substring(1,3));
//	    	int sr = -(r - findNearest(r))^2;
	    	
	    	int g = hexToInt(color.substring(3,5));
//	    	int sg = -(g - findNearest(g))^2;
	    	
	    	int b = hexToInt(color.substring(5,7));
//	    	int sb = -(b - findNearest(b))^2;
	    	
	        return "#"+intToHexString(findNearest(r))
	        +intToHexString(findNearest(g))
	        +intToHexString(findNearest(b));
	    }
	    
	    private int hexToInt(String hex){
	    	return Integer.parseUnsignedInt(hex, 16);  
	    }
	    
	    private String intToHexString(int dig){
	    	if(dig==0)
	    		return "00";
	    	
	    	return Integer.toHexString(dig);
	    }
	    
	    @Test
	    public void testtt(){
	    	System.out.println(findNearest(249));
	    }
	    
	    private int findNearest(int input){
	    	int min = Integer.MAX_VALUE;
	    	int n = 0;
	    	for(int c:cc){
	    		int tmp = Math.abs(c - input);
	    		System.out.println(c + ":" + tmp);
	    		if(tmp < min){
	    			min = tmp;
	    			n = c;
	    		}
	    		
//	    		if(c >= input)
//	    			return c;
	    	}
	    	
	    	// not found, then return max.
	    	return n;
	    }
	}
}
