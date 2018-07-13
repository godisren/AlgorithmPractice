package others.tree;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class LowestCommonAncestor {
	
	private Node root;
	
	@Before
	public void init(){
		Node n10 = new Node(null,null,10);
		Node n14 = new Node(null,null,14);
		Node n12 = new Node(n10,n14,12);
		Node n4 = new Node(null,null,4);
		Node n8 = new Node(n4,n12,8);
		Node n22 = new Node(null,null,22);
		Node n20 = new Node(n8,n22,20);
		
		root = n20;
	}
	
	@Test
	public void test1(){
		// 4, 14 -> 8
		Node answer = findLowestCommonAncestor(root,4,14);
		Assert.assertEquals(8, answer.value);
	}
	
	@Test
	public void test2(){
		Node answer = findLowestCommonAncestor(root,4,22);
		Assert.assertEquals(20, answer.value);
	}
	
	@Test
	public void test3(){
		Node answer = findLowestCommonAncestor(root,10,14);
		Assert.assertEquals(12, answer.value);
	}
	
	Node findLowestCommonAncestor(Node root, int value1, int value2 ){
		Node cur = root;
		while(cur!=null){
			if(cur.value > value1 && cur.value > value2)
				cur = cur.left;
			else if(cur.value < value1 && cur.value < value2)
				cur = cur.right;
			else 
				return cur;
		}
		
		return null;
	}
	
	Node findLowestCommonAncestorWithRecursion(Node root, int value1, int value2 ){
		if(root==null || root.value==value1 || root.value==value2)
			return null;
		
		if(isDescendantByComparison(root, value1) && 
				isDescendantByComparison(root, value2)){
			Node lowerNode = root;
			Node lowerLeft = findLowestCommonAncestor(root.left, value1, value2);
			Node lowerRight = findLowestCommonAncestor(root.right, value1, value2);
			
			lowerNode = minNode(lowerNode, lowerLeft);
			lowerNode = minNode(lowerNode, lowerRight);
			
			return lowerNode;
		}

		return null;
	}
	
	Node minNode(Node node1, Node node2){		
		if(node2!=null && node1.value > node2.value){
			return node2;
		}
		
		return node1;
	}
	
	boolean isDescendantByComparison(Node cur, int value){
		if(cur.value > value)
			return isDescendant(cur.left, value);
		else if(cur.value < value)
			return isDescendant(cur.right, value);
		
		return false;
	}
	
	boolean isDescendant(Node cur, int value){
		if(cur==null)
			return false;
		
		if(cur.value == value)
			return true;
		else if (cur.value > value)
			return isDescendant(cur.left, value);
		else 
			return isDescendant(cur.right, value);
	}
	
	public class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public int getValue() {
			return value;
		}
	}
}
