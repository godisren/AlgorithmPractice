import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Validate Binary Search Tree 
 * 
 *  Given a binary tree, determine if it is a valid binary search tree (BST).
 *  
 *  Assume a BST is defined as follows:
 *  
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 *  
 *  Example 1:
 *  Binary tree [2,1,3], return true.
 *  
 *  Example 2:
 *  Binary tree [1,2,3], return false.  
 *
 */
public class A5_01_ValidateBinaryTree {
	
	@Test
	public void test1(){
		TreeNode root = TreeNode.create(10);
		TreeNode node5 = TreeNode.create(5);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node7 = TreeNode.create(7);
		TreeNode node15 = TreeNode.create(15);
		TreeNode node13 = TreeNode.create(13);
		TreeNode node20 = TreeNode.create(20);
		
		root.left = node5;
		root.right = node15;
		
		node5.left = node3;
		node5.right = node7;
		
		node15.left = node13;
		node15.right = node20;
		
		System.out.println(TreeNode.print(root));
		Assert.assertTrue(isValidBST(root));
	}
	
	@Test
	public void test2(){
		TreeNode root = TreeNode.create(10);
		TreeNode node5 = TreeNode.create(5);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node7 = TreeNode.create(7);
		TreeNode node15 = TreeNode.create(15);
		TreeNode node13 = TreeNode.create(13);
		TreeNode node20 = TreeNode.create(20);
		
		root.left = node5;
		root.right = node15;
		
		node5.left = node3;
		node5.right = node7;
		
		node15.left = node20;
		node15.right = node13;
		
		System.out.println(TreeNode.print(root));
		Assert.assertFalse(isValidBST(root));
	}
	
	@Test
	public void test3(){
		TreeNode root = TreeNode.create(1);
		TreeNode node1 = TreeNode.create(1);
		
		root.left = node1;
		
		System.out.println(TreeNode.print(root));
		Assert.assertFalse(isValidBST(root));
	}
	
	@Test
	public void test4(){
		TreeNode root = TreeNode.create(10);
		TreeNode node5 = TreeNode.create(5);
		TreeNode node15 = TreeNode.create(15);
		
		TreeNode node6 = TreeNode.create(6);
		TreeNode node20 = TreeNode.create(20);
		
		root.left = node5;
		root.right = node15;
		
		node15.left = node6;
		node15.right = node20;
		
		System.out.println(TreeNode.print(root));
		Assert.assertFalse(isValidBST(root));
	}
	
	@Test
	public void test5(){
		TreeNode root = TreeNode.create(Integer.MIN_VALUE);
		TreeNode nodeMax = TreeNode.create(Integer.MAX_VALUE);
		
		root.right = nodeMax;
		System.out.println(TreeNode.print(root));
		Assert.assertTrue(isValidBST(root));
	}
	
	@Test
	public void test6(){
		TreeNode root = TreeNode.create(Integer.MAX_VALUE);
		TreeNode nodeMax = TreeNode.create(Integer.MAX_VALUE);
		
		root.right = nodeMax;
		System.out.println(TreeNode.print(root));
		Assert.assertFalse(isValidBST(root));
	}
	
	public static boolean isValidBST(TreeNode root){
//		return isValidBSTByCheckingAllSubtree(root);
//		return isValidBSTByLowHigh(root);		
		return new SolutionByInorderTraversal().isValidBST(root);
	}
	
	// inorder traversal
	public static class SolutionByInorderTraversal{
		private TreeNode pre;
		public boolean isValidBST(TreeNode root){
			pre = null;
			return isIncreasing(root);
		}
		
		private boolean isIncreasing(TreeNode node){
			if(node==null) return true;
			
			if(isIncreasing(node.left)){
				if(pre!=null && node.val <= pre.val) return false;				
				
				pre = node;
				
				return isIncreasing(node.right);
			}
			
			return false;
		}
	}
	
	// by setting range(low and high) value to validate
	public static boolean isValidBSTByLowHigh(TreeNode root){
		return validate(root, null, null);
	}
	
	public static boolean validate(TreeNode node, Integer low, Integer high){		
		if(node==null)
			return true;
		
		return (low==null || node.val> low) && (high==null || node.val < high)
				&& validate(node.left, low, node.val) 
				&& validate(node.right, node.val , high);
	}
	
	// by checking all subtree
	public static boolean isValidBSTByCheckingAllSubtree(TreeNode root){		
		if(root == null)
			return true;
		
		return isValidLeftTreeLessThanRoot(root.left,root.val) 
				&& isValidRigthTreeGreatThanRoot(root.right,root.val)
				&& isValidBST(root.left) 
				&& isValidBST(root.right);
	}
	
	public static boolean isValidLeftTreeLessThanRoot(TreeNode childTree, int rootVal){
		if(childTree == null)
			return true;
		
		return childTree.val < rootVal 
				&& isValidLeftTreeLessThanRoot(childTree.left,rootVal) 
				&& isValidLeftTreeLessThanRoot(childTree.right, rootVal);
	}
	
	public static boolean isValidRigthTreeGreatThanRoot(TreeNode childTree, int rootVal){
		if(childTree == null)
			return true;
		
		return childTree.val > rootVal
				&& isValidRigthTreeGreatThanRoot(childTree.left,rootVal) 
				&& isValidRigthTreeGreatThanRoot(childTree.right,rootVal);
	}
}
