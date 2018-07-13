package others.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeLookup {
	
	Node root;
	
	@Before
	public void init(){
		Node n1 = new Node(null, null, 1);
		Node n4 = new Node(null, null, 4);
		Node n3 = new Node(n1, n4, 1);
		
		Node n7 = new Node(null, null, 7);
		Node n12 = new Node(null, null, 12);
		Node n10 = new Node(n7, n12, 10);
		
		Node n5 = new Node(n3, n10, 5);
		
		root = n5;
	}
	
	@Test
	public void test1(){
		Node findNode = fnidNode(root, 5);
		Assert.assertEquals(5, findNode.getValue());
	}
	
	@Test
	public void test2(){
		Node findNode = fnidNode(root, 1);
		Assert.assertEquals(1, findNode.getValue());
	}
	
	@Test
	public void test3(){
		Node findNode = fnidNode(root, 99);
		Assert.assertNull(findNode);
	}
	
	public Node fnidNode(Node root, int value){
		//return fnidNodeWithCommonWay(root, value);
		return findNodeWithRecursion(root, value);
	}
	
	/**
	 * start at the root node
	 * loop while current node is non-null
	 * if the current node's value is equal to the search value
	 * 		then return current node
	 * if the current node's value is greater than the search value
	 * 		change the current node to its left child node
	 * if the current node's value is less than the search value
	 * 		change the current node to its right child node
	 */
	public Node fnidNodeWithCommonWay(Node root, int value){
		
		Node currentNode = root;
		while(currentNode != null){
			if(currentNode.getValue() == value)
				return currentNode;
			else if(currentNode.getValue() > value)
				currentNode = currentNode.left;
			else 
				currentNode = currentNode.right;
		}
		
		return null;
	}
	
	public Node findNodeWithRecursion(Node root, int value){
		
		// every node is a root node of its subtree, when traversing node recursively till null, that's the end.
		
		if(root==null)
			return null;
		
		if(root.getValue() == value)
			return root;
		else if(root.getValue() > value)
			return findNodeWithRecursion(root.left,value);
		else 
			return findNodeWithRecursion(root.right,value);		
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
