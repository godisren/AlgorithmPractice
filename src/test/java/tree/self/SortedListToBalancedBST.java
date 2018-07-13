package tree.self;

import org.junit.Test;

public class SortedListToBalancedBST {
	@Test
	public void test(){
		int[] arr = new int[]{1,2,3,4,5,6};
		ListNode dumpyHead = new ListNode(0);
		ListNode cur = dumpyHead;
		for(int v:arr){
			cur.next = new ListNode(v);
			cur = cur.next;
		}
		
		System.out.println(Node.print(new Solution().convert(dumpyHead.next)));
	}
	
	static class Solution{
		ListNode cur;
		
		public Node convert(ListNode head){
			// solution:
			// 1. convert list to array, using position to convert
			//    time: O(n), space: O(n)
			// 2. create node calculating media in each node, time complex is bad( O(n log n)
			//    time: O(n log n), space: O(log n)
			// 3. using recursion, from button-up method
			//    time: O(n), space: O(log n)
			
			int length = 0;
			ListNode n = head;
			while(n!=null){
				n = n.next;
				length++;
			}
			
			cur = head;
			
			return createNode(0, length-1);
		}
		
		public Node createNode(int start, int end){
			if(start>end)
				return null;
			
			// calculate media, later, create child node based on it
			// for example.
			// left range [start, mid-1] or right range [mid+1, end]
			// if sub-recursion check the range invalid(start > end)
			// , means exceed range, then return null as end
			int mid = (start+end)/2;
					
			// first, create most left bottom node  
			Node leftNode = createNode(start, mid-1);
			Node node = new Node(cur.getData());
			node.setLeft(leftNode);
			cur = cur.next;
			Node rightNode = createNode(mid+1, end);
			node.setRight(rightNode);
			
			return node;
		}
	}
	
	
	static class ListNode{
		private int data;
		private ListNode next;
		
		public ListNode(int data) {
			super();
			this.data = data;
		}
		public int getData() {
			return data;
		}
		public ListNode getNext() {
			return next;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
}
