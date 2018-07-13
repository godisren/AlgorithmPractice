package tree.self;

import org.junit.Assert;
import org.junit.Test;

public class ValidateBinarySearchTree {
	
	/**
	 * Given a binary tree, determine if it is a valid Binary Search Tree (BST).
	 * 
	 * solution:
	 * 1.using simple recursion
	 * 2.in-order traversal
	 */
	
	@Test
	public void test1(){
		/**
		 * 		1
		 * 	  /	  \
		 * 	 3		2
		 * exepected:false
		 */
		
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2);
		n1.setLeftAndRight(n3, n1);
		Assert.assertFalse(isBST(n1));
	}
	
	@Test
	public void test2(){
		/**
		 * 		2
		 * 	  /	  \
		 * 	 1		3
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2);
		n2.setLeftAndRight(n1, n3);
		Assert.assertTrue(isBST(n2));
	}
	
	@Test
	public void test3(){
		/**
		 * 		2
		 * 	  /	  
		 * 	 1		
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		n2.setLeft(n1);
		Assert.assertTrue(isBST(n2));
	}
	
	@Test
	public void test4(){
		/**
		 * 		2
		 * 	  /	  \
		 * 	 1		3
		 * 		   / \
		 * 		  4   5
		 * exepected:false
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n2.setLeftAndRight(n1, n3);
		n3.setLeftAndRight(n4, n5);
		Assert.assertFalse(isBST(n2));
	}
	
	@Test
	public void test5(){
		/**
		 * 		2
		 * 	  /	  \
		 * 	 1		4
		 * 		   / \
		 * 		  3   5
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n2.setLeftAndRight(n1, n4);
		n4.setLeftAndRight(n3, n5);
		Assert.assertTrue(isBST(n2));
	}
	
	boolean isBST(Node root){
//		return new Solution().isBSTwithRecursion(root);
//		return new Solution().isBSTwithInorder(root);
		return new Solution().isBSTwithLowAndHigh(root);
	}
	
	static class Solution{
		private Node pre;
		boolean isBSTwithInorder(Node root){
			// traverse tree by inorder
			// set a variable 'pre' to keep previous node has just vsisited
			// the 'pre' should be less than current node's value
			
			if(root == null)
				return true;
			
			if(isBSTwithInorder(root.left)){
				if(pre!=null && pre.getData()> root.getData()) return false;
				
				pre = root;
				
				return isBSTwithInorder(root.right);
			}
			
			return false;
		}
		
		boolean isBSTwithLowAndHigh(Node root){
			return isBSTwithLowAndHigh(root,null,null);
		}
		
		private boolean isBSTwithLowAndHigh(Node cur,Integer low, Integer high){
			if(cur==null)
				return true;
			
			return (low==null || low<cur.getData()) && (high==null || high>cur.getData())
					&& isBSTwithLowAndHigh(cur.getLeft(), low, cur.getData())
					&& isBSTwithLowAndHigh(cur.getRight(),cur.getData(), high);
		}
		
		boolean isBSTwithRecursion(Node root){
			// left child node's value must be less than or equals its parent node's value
			// right child node's value must be greater than or equals its parent node's value
			// assume all nodes aren't duplicated
			
			// using recursion
			/*
			 * if root is null then return true
			 * 
			 * otherwise return below rules
			 * 		root.left.data < root.data && 
			 * 		root.right.data > root.data &&
			 * 		isValidateBinarySearchTree(root.left) &&
			 * 		isValidateBinarySearchTree(root.right) &&
			 */
			
			if(root==null)
				return true;
			
			return (root.getLeft()!=null ? root.getLeft().getData() < root.getData() : true) &&
					(root.getRight()!=null ? root.getRight().getData() > root.getData() : true) &&
					isBSTwithRecursion(root.getLeft()) &&
					isBSTwithRecursion(root.getRight());
		}
	}
	
	static class Node{
		private int data;
		private Node left;
		private Node right;
		
		public Node(int data) {
			super();
			this.data = data;
		}
		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
		public void setLeftAndRight(Node left,Node right) {
			this.left = left;
			this.right = right;
		}
	}
}
