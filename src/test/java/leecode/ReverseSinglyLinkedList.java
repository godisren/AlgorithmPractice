package leecode;

import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;

public class ReverseSinglyLinkedList {
	
	@Test
	public void test1(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,2,3});
		
		ListNode resultNode = reverseList(node1);
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{3,2,1}));
	}
	
	@Test
	public void test2(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,2});
		
		ListNode resultNode = reverseList(node1);
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{2,1}));
	}
	
	@Test
	public void test3(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1});
		
		ListNode resultNode = reverseList(node1);
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1}));
	}
	
	public static ListNode reverseList(ListNode head){
		ListNode finalHead  = new ListNode(0);
		reverseTwoNode(null, head, finalHead);
		return finalHead.next;
	}
	
	public static ListNode reverseTwoNode(ListNode preNode,ListNode nextNode,  ListNode finalHead){		
		if(nextNode == null){
			finalHead.next = preNode;
		}else{
			reverseTwoNode(nextNode, nextNode.next , finalHead).next = preNode;
		}	
		
		return preNode;
	}
	
	
	public static ListNode reverseList_v2(ListNode head) {
		ListNode preNode = null;
		
		while(head!=null){
			ListNode nextNode = head.next;
			head.next = preNode;
			preNode = head;
			head = nextNode;
		}
		
        return preNode;
    }
	
	public static ListNode reverseList_v1(ListNode head) {
		ListNode leftNode = null;
		ListNode rightNode = head;
		while(head!=null && head.next!=null){
			ListNode n2 = head.next;
			
			rightNode = n2.next;
			n2.next = head;
			head.next = leftNode;
			
			leftNode = n2;
			head = rightNode;
		}
		
		if(rightNode!=null){
			rightNode.next = leftNode;
			leftNode = rightNode;
		}
		
        return leftNode;
    }
}
