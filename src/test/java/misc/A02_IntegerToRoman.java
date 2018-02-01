package misc;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;


/**
 * 
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */
public class A02_IntegerToRoman {
	
	@Test
	public void test1(){
		Assert.assertEquals("MMMCMXCIX", intToRoman(3999));
	}

	/**
	 * I	1
	 * V	5
	 * X	10
	 * L	50
	 * C	100
	 * D	500
	 * M	1000
	 * 
	 * 小大(減)
	 * IV = 5-1=4
	 * IX = 10-1=9
	 * 
	 * 大小(加)
	 * VI = 5+1=6
	 * XI = 10+1=11
	 * 
	 * 同一符號最多只能出現三次
	 * 連續出同符號表是其倍數
	 * CCC = 100*3 = 300
	 * XIII = 10 + 1*3 = 13
	 * 
	 * 3999
	 * MMMCMXCIX = MMM + CM + XC + IX
	 */
	
	static String M[] = {"", "M", "MM", "MMM"};
	static String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	static String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	static String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
	// 1 to 3999
	public static String intToRoman(int num) {
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	//1 to 3999
	public static String intToRoman3(int num) {
		StringBuffer result = new StringBuffer();
		
        // divide and mod 1000
		int m = num / 1000;
		paddingLetter(result,"M",m);
		num %= 1000;
		
		Map<Integer,String> map = new LinkedHashMap();
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		
		int[] partitions = new int[]{1000, 900, 500, 400, 100};
		
		for(int x = 1;x<=100; x*=10){
			int p1 = partitions[0]/x;
			int p2 = partitions[1]/x;
			int p3 = partitions[2]/x;
			int p4 = partitions[3]/x;
			int p5 = partitions[4]/x;
			
			if(num >= p2){
//				result.append("CM");
				result.append(map.get(p5) + map.get(p1));
			}else if(num >=p3){
//				result.append("D");
				result.append(map.get(p3));
				int c = (num - p3) / p5;
				paddingLetter(result,map.get(p5),c);
			}else if(num >=p4){
//				result.append("CD");
				result.append(map.get(p5) + map.get(p3));
			}else if(num >=p5){
				int c = num / p5;
				paddingLetter(result,map.get(p5),c);
			}
			
			num %= 100/x;
		}
		
		return result.toString();
    }
	
	//1 to 3999
	public static String intToRoman2(int num) {
		StringBuffer result = new StringBuffer();
		
        // divide and mod 1000
		int m = num / 1000;
		paddingLetter(result,"M",m);
		num %= 1000;
		
		// divide and mod 500
		// ex. 900 = 1000 - 100
		// ex. 800 = 500 + 300
		// ex. 700 = 500 + 200
		// ex. 600 = 500 + 100
		
		if(num >= 900){
			result.append("CM");
		}else if(num >=500){
			result.append("D");
			int c = (num - 500) / 100;
			paddingLetter(result,"C",c);
		}else if(num >=400){
			result.append("CD");
		}else{
			int c = num / 100;
			paddingLetter(result,"C",c);
		}
		
		num %= 100;
		
		// divide and mod 100
		// 90, 80~50, 40 , 30~10
		if(num >= 90){
			result.append("XC");
		}else if(num >=50){
			result.append("L");
			int c = (num - 50) / 10;
			paddingLetter(result,"X",c);
		}else if(num >=40){
			result.append("XL");
		}else{
			int c = num / 10;
			paddingLetter(result,"X",c);
		}
		
		num %= 10;
		// divide and mod 10
		// 9, 8~5, 4 , 3~1
		if(num >= 9){
			result.append("IX");
		}else if(num >=5){
			result.append("V");
			int c = num - 5;
			paddingLetter(result,"I",c);
		}else if(num >=4){
			result.append("IV");
		}else{
			int c = num ;
			paddingLetter(result,"I",c);
		}
		
		return result.toString();
    }
	
	private static void paddingLetter(StringBuffer sb, String letter, int num){
		for(int i = 0;i<num;i++)
			sb.append(letter);
	}
}
