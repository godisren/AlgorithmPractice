package tree;
import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Balanced Binary Tree
 * 
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a 
 * binary tree in which the depth of the two subtrees of every node 
 * never differ by more than 1. 
 *
 */
public class A5_04_BalancedBinaryTree {
	
	@Test
	public void test1(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(2);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node4 = TreeNode.create(4);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
				
		System.out.println(TreeNode.print(root));
		Assert.assertTrue(isBalanced(root));
	}
	
	@Test
	public void test2(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(2);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node4 = TreeNode.create(4);
		TreeNode node5 = TreeNode.create(5);
		TreeNode node6 = TreeNode.create(6);
		
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node4.left = node5;
		
		node3.left = node6;
				
		System.out.println(TreeNode.print(root));
		Assert.assertFalse(isBalanced(root));
	}
	
	public static boolean isBalanced(TreeNode root){
//		return isBalancedByMaxDepth(root);
		return isBalancedByCustomizedMaxDepth(root);
	}
	
	public static boolean isBalancedByCustomizedMaxDepth(TreeNode root){
		return customizedMaxDepth(root) != -1;
	}
	
	// time: O(2n) -> O(n) 
	public static int customizedMaxDepth(TreeNode root){
		if(root==null) return 0;
		
		int leftDepth = customizedMaxDepth(root.left);
		if(leftDepth==-1)
			return -1;
		int rightDepth = customizedMaxDepth(root.right);
		if(rightDepth==-1)
			return -1;
		
		return Math.abs(leftDepth - rightDepth) <=1 ? Math.max(leftDepth, rightDepth) +1 : -1;
	}
	
	// time: O(n^2)
	public static boolean isBalancedByMaxDepth(TreeNode root){
		if(root==null)
			return true;
		
		return Math.abs(maxDepth(root.left) - maxDepth(root.right)) <=1 
				&& isBalanced(root.left) 
				&& isBalanced(root.right);
	}
	
	// same as A5_02_MaximumDepthOfBinaryTree
	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		
		return Math.max(maxDepth(root.left) + 1 , maxDepth(root.right) + 1);
	}
}
