import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Minimum Depth of Binary Tree
 * 
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the 
 * shortest path from the root node down to the nearest leaf node.
 *
 */
public class A5_03_MinimumDepthOfBinaryTree {
	
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
		Assert.assertEquals(2,minDepth(root));
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
		Assert.assertEquals(3,minDepth(root));
	}
	
	@Test
	public void test3(){
		TreeNode root = TreeNode.create(1);
		TreeNode node2 = TreeNode.create(2);
		
		root.right = node2;
				
		System.out.println(TreeNode.print(root));
		Assert.assertEquals(2,minDepth(root));
	}
	
	public static int minDepth(TreeNode root){
		// return minDepthDFS(root);
		return minDepthBFS(root);
	}
	
	public static int minDepthBFS(TreeNode root){
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		
		q.add(root);
		
		int depth = 1;
		TreeNode node;
		TreeNode mostRightNode = root;
		while((node = q.poll())!=null){
			
			if(node.left==null && node.right==null)
				break;
						
			if(node.left!=null) q.add(node.left);
			if(node.right!=null) q.add(node.right);
			if(mostRightNode==node){
				depth++;
				mostRightNode = node.right!=null ? node.right : node.left;
			}
		}
		
		return depth;
	}
	
	public static int minDepthDFS(TreeNode root){
		if(root == null)
			return 0;
		
		if(root.left == null) return minDepth(root.right) + 1;
		if(root.right == null) return minDepth(root.left) + 1;
		
		return Math.min(minDepth(root.left) + 1 , minDepth(root.right) + 1);
	}
	
	
}
