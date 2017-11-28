import java.util.Comparator;
import java.util.PriorityQueue;

import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;

/**
 * Question:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity. 
 */
public class A4_04_MergeKSortedLists {
	
	@Test
	public void test1(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,3});
		ListNode node2 = ListNode.createNodeWithIntegerArray(new int[]{2,4});
		
		ListNode resultNode = mergeKLists(new ListNode[]{node1, node2});
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1,2,3,4}));
	}
	
	@Test
	public void test2(){
		
		ListNode node1 = ListNode.createNodeWithIntegerArray(new int[]{1,3});
		
		ListNode resultNode = mergeKLists(new ListNode[]{node1});
		
//		ListNode.printListNode(resultNode);
		Assert.assertTrue(ListNode.eqaulsIntegerArrayValue(resultNode, new int[]{1,3}));
	}
	
	public static ListNode mergeKLists(ListNode[] lists){
//		return mergeKLists_PiorityQueue(lists);
		return mergeKLists_DivideAndConquer(lists);
	}
	
	// great answer
	public static ListNode mergeKLists_DivideAndConquer(ListNode[] lists){
		if(lists == null || lists.length==0)
			return null;
		
		int end = lists.length-1;
		while(end>0){
			int begin = 0;
			while(begin<end){
				lists[begin] = A4_01_MergeTwoSortedLists.mergeTwoLists(lists[begin++],lists[end--]);
			}
		}
		
		return lists[0];
	}
	
	// retrieved node that has next node will add its next node to queue,
	// the queue always hold no more than 3 seats to sort
	public static ListNode mergeKLists_PiorityQueue(ListNode[] lists){

		if(lists==null || lists.length ==0)
			return null;
		
		Comparator<ListNode> c = new Comparator<ListNode>() {  
            public int compare(ListNode a, ListNode b) {  
                return a.val - b.val ;  
            }  
        };
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, c);
		
		for(ListNode node : lists){
			if(node!=null)
				queue.add(node);			
		}
		
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(!queue.isEmpty()){
			cur.next = queue.poll();
			cur = cur.next;
			
			if(cur.next!=null) queue.add(cur.next);
		}
		
		return dummyHead.next;
	
	}
	
	// bad, queue must collect all node to sort and retreive. 
	public static ListNode mergeKLists_v1(ListNode[] lists){
		if(lists==null || lists.length ==0)
			return null;
		
		Comparator<ListNode> c = new Comparator<ListNode>() {  
            public int compare(ListNode a, ListNode b) {  
                return a.val - b.val ;  
            }  
        };
		
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(c);
		
		for(ListNode node : lists){
			ListNode cur = node;
			while(cur!=null){
				queue.add(cur);				
				cur = cur.next;
			}			
		}
		
		ListNode dummyHead = new ListNode(0);
		ListNode cur = dummyHead;
		while(!queue.isEmpty()){
			cur.next = queue.poll();
			cur = cur.next;
		}
		
		return dummyHead.next;
	}

	
}
