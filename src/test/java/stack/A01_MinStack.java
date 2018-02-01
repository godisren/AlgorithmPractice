package stack;

import java.util.LinkedList;
import java.util.Stack;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * Min Stack
 * 
 * Qestion:
 * Design a stack that supports push, pop, top, and retrieving 
 * the minimum element in constant time.
 *      push(x) -- Push element x onto stack.
 *      pop() -- Removes the element on top of the stack.
 *      top() -- Get the top element.
 *      getMin() -- Retrieve the minimum element in the stack.
 *  
 *  Example:
 *  MinStack minStack = new MinStack();
 *  minStack.push(-2);
 *  minStack.push(0);
 *  minStack.push(-3);
 *  minStack.getMin();   --> Returns -3.
 *  minStack.pop();
 *  minStack.top();      --> Returns 0.
 *  minStack.getMin();   --> Returns -2.
 *
 */
public class A01_MinStack {

	@Test
	public void test1(){
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		
		int temp = minStack.getMin();
		Assert.assertEquals(-3, temp);
		
		minStack.pop();
		temp = minStack.top();
		Assert.assertEquals(0, temp);
		
		temp = minStack.getMin();
		Assert.assertEquals(-2, temp);
	}
	
	@Test
	public void test2(){
		MinStack minStack = new MinStack();
		minStack.push(0);
		minStack.push(1);
		minStack.push(0);
		
		int temp = minStack.getMin();
		Assert.assertEquals(0, temp);
		
		minStack.pop();
		temp = minStack.getMin();
		Assert.assertEquals(0, temp);		
	}
	
	class MinStack {
	
		Stack<Integer> stk;
		Stack<Integer> minStk;
		
	    /** initialize your data structure here. */
	    public MinStack() {
	    	stk = new Stack<>();
			minStk = new Stack<>();
	    }
	    
	    public void push(int x) {
	    	stk.push(x);
	    	
	    	if(minStk.isEmpty() || x <= minStk.peek()){
	    		minStk.push(x);
	    	}
	    }
	    
	    public void pop() {
	    	int n = stk.pop();
	    	if(n == minStk.peek())
	    		minStk.pop();
	    	
	    }
	    
	    public int top() {
	        return stk.peek();
	    }
	    
	    public Integer getMin() {
	    	return minStk.peek();
	    }
	}
	
	class MinStack1 {
		
		LinkedList<Integer> list;
		TreeSet<Integer> set;

	    /** initialize your data structure here. */
	    public MinStack1() {
	    	list = new LinkedList();
	    	set = new TreeSet();
	    }
	    
	    public void push(int x) {
	    	list.push(x);
	    	set.add(x);
	    }
	    
	    public void pop() {
	    	int n = list.pop();
	    	if(!list.contains(n))
	    		set.remove(n);
	    }
	    
	    public int top() {
	        return list.peek();
	    }
	    
	    public Integer getMin() {
	    	if(set.isEmpty())
	    		return null;
	    	
	    	return set.first();
	    }
	}

}
