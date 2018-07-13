package tree.self;

import org.junit.Assert;
import org.junit.Test;

public class BalancedBinaryTree {
	
	@Test	
	public void test(){
		/**
		 * 		1
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Assert.assertTrue(isBalancedBinaryTree(n1));
	}
	
	@Test	
	public void test2(){
		/**
		 * 		1
		 *     /
		 *    2
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		n1.setLeft(n2);
		Assert.assertTrue(isBalancedBinaryTree(n1));
	}
	
	@Test	
	public void test3(){
		/**
		 * 		1
		 *     / \
		 *    2   3
		 * exepected:true
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.setLeftAndRight(n2,n3);
		Assert.assertTrue(isBalancedBinaryTree(n1));
	}
	
	@Test	
	public void test4(){
		/**
		 * 		1
		 *     / 
		 *    2
		 *   /
		 *  3
		 * exepected:false
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.setLeft(n2);
		n2.setLeft(n3);
		Assert.assertFalse(isBalancedBinaryTree(n1));
	}
	
	@Test	
	public void test5(){
		/**
		 * 		1
		 *     / 
		 *    2
		 *     \
		 *      3
		 * exepected:false
		 */
		
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.setLeft(n2);
		n2.setRight(n3);
		Assert.assertFalse(isBalancedBinaryTree(n1));
	}

	public boolean isBalancedBinaryTree(Node root){
		// to check if the tree is balanced binary tree
		
		return customizedMaxDepth(root) != -1;
	}
	
	public int customizedMaxDepth(Node root){
		// using recursion to calculate the depth of the node from bottom line
		// if the difference height of left and right subtree < 1
		//     return max height between left or right subtree + 1
		// otherwise
		//	   return -1 , means current isn't a balanced binary tree 
		// 
		
		if(root == null)
			return 0;
		
		int leftDepth = customizedMaxDepth(root.getLeft());
		if(leftDepth == -1) return -1;
		
		int rightDepth = customizedMaxDepth(root.getRight());
		if(rightDepth == -1) return -1;
		
		return Math.abs(leftDepth - rightDepth) <= 1 ? Math.max(leftDepth , rightDepth)+1 : -1;  
	}
	
}
