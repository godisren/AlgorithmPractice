import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;

/**
 * Qeustion:
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class A4_01_MergeTwoSortedLists {
	
	@Test
	public void test1(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,3});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{2,4});
		
		ListNode resultNode = mergeTwoLists(node1, node2);
		
//		printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1,2,3,4}));
	}
	
	@Test
	public void test2(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,3});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{1,2});
		
		ListNode resultNode = mergeTwoLists(node1, node2);
		
		//printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1,1,2,3}));
	}
	
	@Test
	public void test3(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{3,5});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{1,2,6});
		
		ListNode resultNode = mergeTwoLists(node1, node2);
		
		//printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1,2,3,5,6}));
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
		ListNode dummyHead = new ListNode(-99);
		ListNode curNode = dummyHead; 
		
		while(l1!=null && l2 != null) {
			if(l1.val < l2.val){
				curNode.next = l1;
				l1 = l1.next;
			}else{
				curNode.next = l2;
				l2 = l2.next;
			}
			
			curNode = curNode.next;				
		}
		
		if(l1!=null) curNode.next = l1;		
		if(l2!=null) curNode.next = l2;
		
		return dummyHead.next;
	}
	
	public static ListNode mergeTwoLists_v1(ListNode l1, ListNode l2){
		ListNode firstNode = null, preNode = null;
		ListNode curL1 = l1;
		ListNode curL2 = l2;
		
		preNode = new ListNode(-99);
		
		do {
			if(curL1.val < curL2.val){
				preNode.next = curL1;
				curL1 = curL1.next;
			}else{
				preNode.next = curL2;
				curL2 = curL2.next;
			}
			
			preNode = preNode.next;
			if(firstNode == null) firstNode = preNode;
				
		}while(curL1!=null && curL2 != null);
		
		if(curL1!=null) preNode.next = curL1;		
		if(curL2!=null) preNode.next = curL2;
		
		return firstNode;
	}	
}
