import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;

/**
 * Question:
 *  Given a linked list, swap every two adjacent nodes and return its head.
 *  For example,
 *  Given 1->2->3->4, you should return the list as 2->1->4->3.
 *  Your algorithm should use only constant space. You may not modify the values 
 *  in the list, only nodes itself can be changed. 
 */
public class A4_03_SwapNodesInPairs {
	
	@Test
	public void test1(){
		
		ListNode node = ListNode.createNodeWithIntegerArray(new int[]{1,2,3,4});
		
		ListNode resultNode = swapPairs(node);
		
		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{2,1,4,3}));
	}
	
	@Test
	public void test2(){
		
		ListNode node = ListNode.createNodeWithIntegerArray(new int[]{1,2,3});
		
		ListNode resultNode = swapPairs(node);
		
		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{2,1,3}));
	}
	
	@Test
	public void test3(){
		
		ListNode node = ListNode.createNodeWithIntegerArray(new int[]{1});
		
		ListNode resultNode = swapPairs(node);
		
		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1}));
	}

	public static ListNode swapPairs(ListNode head){
		
		ListNode dummyHead = new ListNode(0);
		ListNode lastCursor = dummyHead;
		
		lastCursor.next = head;
		
		ListNode n1 = head;
		while(n1!=null && n1.next!=null){
			
			ListNode n2 = n1.next;
			ListNode n3 = n1.next.next;
			
			lastCursor.next = n2;
			n2.next = n1;
			n1.next = n3;
			lastCursor = n1;
			
			n1 = lastCursor.next;
		}
		
		return dummyHead.next;
	}

	public static ListNode swapPairs_v1(ListNode head){
		
		ListNode dummyHead = new ListNode(0);
		ListNode lastCursor = dummyHead;
		
		lastCursor.next = head;
		
		int i = 0;
		ListNode secondAlternateNode = null;
		while(head!=null){
			
			if(i%2==0){
				secondAlternateNode = head;
			}else{
				lastCursor.next = head;
				ListNode temp = head.next;
				head.next = secondAlternateNode;
				secondAlternateNode.next = temp;
				
				lastCursor = secondAlternateNode;
				head = secondAlternateNode;
			}
			
			head = head.next;
			
			i++;
		}
		
		return dummyHead.next;
	}
}
