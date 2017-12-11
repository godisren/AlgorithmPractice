import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Maximum Depth of Binary Tree 
 * 
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the 
 * longest path from the root node down to the farthest leaf node.
 *
 */
public class A5_02_MaximumDepthOfBinaryTree {
	
	@Test
	public void test1(){
		TreeNode root = TreeNode.create(10);
		TreeNode node5 = TreeNode.create(5);
		TreeNode node3 = TreeNode.create(3);
		TreeNode node15 = TreeNode.create(15);
		
		root.left = node5;
		root.right = node15;
		node5.left = node3;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(3,maxDepth(root));
	}
	
	@Test
	public void test2(){
		TreeNode root = TreeNode.create(10);
		TreeNode node15 = TreeNode.create(15);
		TreeNode node12 = TreeNode.create(12);
		TreeNode node11 = TreeNode.create(11);
		TreeNode node17 = TreeNode.create(17);
		
		root.right = node15;
		node15.left = node12;
		node15.right = node17;
		
		node12.left = node11;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(4,maxDepth(root));
	}
	
	public static int maxDepth(TreeNode root){
		if(root == null)
			return 0;
		
		return Math.max(maxDepth(root.left) + 1 , maxDepth(root.right) + 1);
	}
	
	
}
