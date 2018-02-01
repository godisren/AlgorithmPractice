package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class A02_EvalRPN {

	@Test
	public void test1(){
		//["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
		String[] tokens = new String[]{"2", "1", "+", "3", "*"}; 
		Assert.assertEquals(9, evalRPN(tokens));
	}
	
	public void test2(){
		//["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
		String[] tokens = new String[]{"4", "13", "5", "/", "+"}; 
		Assert.assertEquals(6, evalRPN(tokens));
	}
	
	
	public static int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack();
        
        for(String t:tokens){
        	switch(t){
        	case "+":
        		stk.push(stk.pop() + stk.pop());
        		break;
        	case "-":
        		stk.push((stk.pop() - stk.pop())*-1);
        		break;
        	case "*":
        		stk.push(stk.pop() * stk.pop());
        		break;
        	case "/":
        		int n2 = stk.pop();
        		int n1 = stk.pop();
        		stk.push(n1 / n2);
        		break;
        	default:
        		stk.push(Integer.valueOf(t));
        	}
        }
        
        return stk.pop();
    }
}
