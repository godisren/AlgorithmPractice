package others.list;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Before;
import org.junit.Test;

public class ListFlattening {
	
	Node head;
	Node tail;
	
	@Before
	public void init(){
		/*
		 * 1 -> 2 -> -> 3 -> 4
		 * 11->12	 -> 31 -> 32
		 *   ->121 -> 122  -> 321->322
		 *   
		 * head : 1
		 * tail : 4
		 */
		
		// first level
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		
		connectInBidirection(node1,node2);
		connectInBidirection(node2,node3);
		connectInBidirection(node3,node4);
		connectInBidirection(node4,null);
		
		// second level
		Node node11 = new Node(11);
		Node node12 = new Node(12);
		Node node31 = new Node(31);
		Node node32 = new Node(32);
		
		connectInBidirection(node11,node12);
		connectInBidirection(node31,node32);
		
		node1.child = node11;
		node3.child = node31;
				
		// third level
		Node node121 = new Node(121);
		Node node122 = new Node(122);
		Node node321 = new Node(321);
		Node node322 = new Node(322);
		
		connectInBidirection(node121 , node122);
		connectInBidirection(node321 , node322);
		
		node12.child = node121;
		node32.child = node321;
		
		head = node1;
		tail = node4;
	}
	
	static private void connectInBidirection(Node n1, Node n2){
		n1.next = n2;
		if(n2!=null)
			n2.prev = n1;
	}
	
	@Test
	public void test1(){
		printNodeWithChild(head);
		tail = flatten(head, tail);
		System.out.println("=====flatten=====");
		printNode(head);
		System.out.println("tail:"+tail.value);
		
		tail = unflatten(head, tail);
		System.out.println("=====unflatten=====");
		printNodeWithChild(head);
		System.out.println("tail:"+tail.value);
		
	}
	
	private void printNodeWithChild(Node node){
		Queue<Node> parent = new LinkedList();
		Queue<Node> child = new LinkedList();
		parent.add(node);

		Node cur = null;
		do{
			while((cur = parent.poll())!=null){
				do{
					if(cur.child != null)
						child.add(cur.child);
					
					System.out.print(cur.value);
					if(cur.prev!=null)
					System.out.print("("+cur.prev.value+")");
					System.out.print(" -> ");
					
					cur = cur.next;
				}while(cur!=null);
			}
			System.out.println("");
			parent.addAll(child);
			child.clear();
		}while(!parent.isEmpty());
		
	}
	
	private void printNode(Node node){
		
		while(node!=null){
			System.out.print(node.value);
			if(node.prev!=null)
				System.out.print("(pre:"+node.prev.value+") ");
			System.out.print("->");
			node = node.next;
		}
		
		System.out.println("");
	}
	
	public Node flatten(Node head, Node tail){
		
		Node cur = head;
		while(cur!=null){
			// append child to tail
			if(cur.child!=null){
				tail.next = cur.child;
				cur.child.prev = tail;
				// reassign tail
				do{
					tail = tail.next;
				}while(tail.next!=null);
			}
			
			cur = cur.next;
		};
		
		return tail;
	}
	
	public Node unflatten(Node head, Node v){
		/*
		start from tail in backward direction until previous element is null
		if current element has child , 
		1. the child’s previous element pointer to tail
		2. disconnect the reference line between the child and the child’s previous element
		*/
		
		Node cur = tail;
		while(cur!=null){
			if(cur.child!=null){
				tail = cur.child.prev;
				cur.child.prev.next = null;
				cur.child.prev = null;
			}
			
			cur = cur.prev;
		}
		
		return tail;
	}

	class Node{
		Node next;
		Node prev;
		Node child;
		int value;
		
		public Node(int value) {
			super();
			this.value = value;
		}
		
	}
}
