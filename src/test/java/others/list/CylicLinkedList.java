package others.list;

import org.junit.Test;

import org.junit.Assert;

public class CylicLinkedList {
	
	@Test
	public void testAcyclic(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		Assert.assertFalse(isCyclic(n1));
	}
	
	@Test
	public void testcCyclic(){
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n2;
		
		Assert.assertTrue(isCyclic(n1));
	}
	
	public boolean isCyclic(Node head){
		
		if(head==null)
			return false;
		
		// init slower and faster node
		Node slower = head;
		Node faster = head.next;
		
		// loop infinitively
		while(true){
			
			// if faster or its next node is null terminated, the list is an acyclic 
			if(faster==null || faster.next == null)
				return false;			
			
			// if faster or its next node equals to slower, it's a cyclic list 
			if(faster == slower || faster.next == slower)
				return true;
			
			// slower move 1 node
			slower = slower.next;
			// faster move 2 nodes
			faster = faster.next.next;
		}
	}
	
	class Node{
		Node next;
		int value;
		
		public Node(int value) {
			super();
			this.value = value;
		}
		
	}
}
