import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;

/**
 * Question:
 * You are given two non-empty linked lists representing two non-negative integers. The digits 
 * are stored in reverse order and each of their nodes contain a single digit. Add the two numbers 
 * and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class A4_02_AddTwoNumbers {
	
	@Test
	public void test1(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{2,4,3});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{5,6,4});
		
		ListNode resultNode = addTwoNumbers(node1, node2);
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{7,0,8}));
	}
	
	@Test
	public void test2(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{2,4});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{5,6});
		
		ListNode resultNode = addTwoNumbers(node1, node2);
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{7,0,1}));
	}
	
	@Test
	public void test3(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{9,9});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{1});
		
		ListNode resultNode = addTwoNumbers(node1, node2);
		
		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{0,0,1}));
	}
	
	@Test
	public void test4(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{9,9,9});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{1});
		
		ListNode resultNode = addTwoNumbers(node1, node2);
		
		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{0,0,0,1}));
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
		
		ListNode result = new ListNode(0);
		ListNode current = result;
		
		int carry = 0;
		while(l1 != null || l2 !=null){
			int sum = 0;
			
			if(l1 != null){
				sum += l1.val;
				l1 = l1.next;				
			}
			
			if(l2 != null){
				sum += l2.val;
				l2 = l2.next;
			}
			
			sum += carry;
			carry = sum/10;
			current.next = new ListNode(sum % 10);			
			current = current.next;
		}
		
		if(carry>0)
			current.next = new ListNode(carry);
		
		return result.next;
	}
}
