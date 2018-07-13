package tree;
import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Binary Tree Maximum Path Sum 
 * 
 * Given a binary tree, find the maximum path sum.
 * 
 * For this problem, a path is defined as any sequence of nodes from some starting node 
 * to any node in the tree along the parent-child connections. The path must contain at 
 * least one node and does not need to go through the root.
 *
 */
public class A5_06_BinaryTreeMaximumPathSum {
	
	@Test
	public void test1(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(2);
		TreeNode node3 = TreeNode.create(3);
		
		root.left = node2;
		root.right = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(6, maxPathSum(root));
	}
	
	@Test
	public void test2(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(-2);
		TreeNode node3 = TreeNode.create(3);
		
		root.left = node2;
		root.right = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(4, maxPathSum(root));
	}
	
	@Test
	public void test3(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(3);
		TreeNode node3 = TreeNode.create(-2);
		
		root.left = node2;
		root.right = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(4, maxPathSum(root));
	}
	
	@Test
	public void test4(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(-2);
		TreeNode node3 = TreeNode.create(-3);
		
		root.left = node2;
		root.right = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(1, maxPathSum(root));
	}
	
	@Test
	public void test5(){
		TreeNode root = TreeNode.create(-2);
		TreeNode node2 = TreeNode.create(1);
		TreeNode node3 = TreeNode.create(-3);
		
		root.left = node2;
		root.right = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(1, maxPathSum(root));
	}
	
	@Test
	public void test6(){
		TreeNode root = TreeNode.create(-1);
		TreeNode node2 = TreeNode.create(2);
		TreeNode node3 = TreeNode.create(-2);
		TreeNode node4 = TreeNode.create(-3);
		TreeNode node5 = TreeNode.create(-4);
		
		root.left = node2;
		root.right = node5;
		node2.left = node3;
		node2.right = node4;
		
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(2, maxPathSum(root));
	}
	
	@Test
	public void test7(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(2);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node4 = TreeNode.create(4);
		TreeNode node5 = TreeNode.create(-4);
		
		root.left = node2;
		root.right = node5;
		node2.left = node3;
		node2.right = node4;
		
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(9, maxPathSum(root));
	}
	
	
	
	public static int maxPathSum(TreeNode root){
		return new Solution().maxPathSum(root);
	}
	
	public static class Solution{
		int maxSum = Integer.MIN_VALUE;
		public int maxPathSum(TreeNode root){
			depthSum(root);
			return maxSum;
		}
		
		private int depthSum(TreeNode node){
			if(node == null) return 0;
			int leftVal = depthSum(node.left);
			int rightVal = depthSum(node.right);
			
			System.out.println("cur:"+node.val);
			maxSum = Math.max(maxSum, node.val + leftVal + rightVal);
			
			int result = node.val + Math.max(leftVal , rightVal);
			return result > 0 ? result : 0;
		}
	}
	
	//bad
	public static class SolutionByEveryNodeDeepSum {
		private int result = Integer.MIN_VALUE;
		
		public int maxPathSum(TreeNode root){
			if(root==null)
				return result;
			
			goRoot(root);			
			maxPathSum(root.left);
			maxPathSum(root.right);
			
			return result;
		}
		
		private void goRoot(TreeNode node){
			if(node==null)
				return ;
			//result = Math.max(result , depthSum(node));
			
			int leftPathSum = depthSum(node.left);
			int rightPathSum = depthSum(node.right);
			
			int nodePathSum = node.val;
			if(leftPathSum>0) nodePathSum+= leftPathSum;			
			if(rightPathSum>0) nodePathSum+= rightPathSum;
			
			result = Math.max(result , nodePathSum);			
		}
				
		private int depthSum(TreeNode node){
			if(node == null) return Integer.MIN_VALUE;
			
			int totalVal = node.val;
			int leftVal = depthSum(node.left);
			int rightVal = depthSum(node.right);
			
			if(leftVal>0 && rightVal>0) totalVal+= Math.max(leftVal, rightVal);
			else if(leftVal>0) totalVal+= leftVal;
			else if(rightVal>0) totalVal+= rightVal;
				
			return totalVal;
		}
	}
	
}
