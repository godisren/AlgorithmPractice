package stack;

import java.util.Stack;

import org.junit.Assert;
import org.junit.Test;

public class A03_ValidParentheses {

	@Test
	public void test1(){
		Assert.assertTrue(isValid("()"));
	}

	@Test
	public void test2(){
		Assert.assertTrue(isValid("()[]{}"));
	}
	
	@Test
	public void test3(){
		Assert.assertTrue(isValid("[()]"));
	}
	
	@Test
	public void test4(){
		Assert.assertFalse(isValid("([)]"));
	}
		
	public static boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
        	switch(c){
        	case '(':
        		stk.push(')');
        		break;
        	case '{':
        		stk.push('}');
        		break;
        	case '[':
        		stk.push(']');
        		break;
        	default:
        		if(stk.isEmpty() || stk.pop() != c)
        			return false;
        	}
        }
        
        return true;
    }
	
	public static boolean isValid2(String s) {
        Stack<Character> stk = new Stack<>();
        for(char c:s.toCharArray()){
        	switch(c){
        	case ')':
        		if(stk.isEmpty() || '(' != stk.pop())
        			return false;
        		break;
        	case '}':
        		if(stk.isEmpty() || '{' != stk.pop())
        			return false;
        		break;
        	case ']':
        		if(stk.isEmpty() || '[' != stk.pop())
        			return false;
        		break;
        	default:
        		stk.push(c);
        	}
        }
        
        return stk.isEmpty();
    }
}
