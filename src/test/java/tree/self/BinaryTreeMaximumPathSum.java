package tree.self;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeMaximumPathSum {
	
	@Test
	public void test1(){
		Node root = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		
		root.setLeftAndRight(node2, node3);
		
		System.out.println(Node.print(root));
		Assert.assertEquals(6, new Solution().maximumPathSum(root));
	}
	
	@Test
	public void test2(){
		Node root = new Node(1);
		Node node2 = new Node(-2);
		Node node3 = new Node(3);
		
		root.setLeftAndRight(node2, node3);
				
		System.out.println(Node.print(root));
		Assert.assertEquals(4, new Solution().maximumPathSum(root));
	}
	
	@Test
	public void test3(){
		Node root = new Node(1);
		Node node2 = new Node(3);
		Node node3 = new Node(-2);
		
		root.setLeftAndRight(node2, node3);
				
		System.out.println(Node.print(root));
		Assert.assertEquals(4, new Solution().maximumPathSum(root));
	}
	
	@Test
	public void test6(){
		Node root = new Node(-1);
		Node node2 = new Node(2);
		Node node3 = new Node(-2);
		Node node4 = new Node(-3);
		Node node5 = new Node(-4);
		
		root.setLeftAndRight(node2, node5);
		node2.setLeftAndRight(node3, node4);
		
				
		System.out.println(Node.print(root));
		Assert.assertEquals(2, new Solution().maximumPathSum(root));
	}
	
	static public class Solution{
		/*
		 * using recursion, DFS bottom up to find maximum path sum
		 *
		 * calculate the sum adjacent to its children ( current node value + left and right child sum path), 
		 * update maximum sum if the sum is greater than current maximum sum
		 * 
		 * calculate other sum adjacent to its maximum child ( current node value + max between left and right child sum path)
		 * if it's negative then return 0 (means discard this sum to accumulate later) 
		 * otherwise return the final sum
		 * 
		 * 
		 * time: O(n)  DFS bottom-up
		 * space:O(n)  the worst case is just only one path from root to end 
		 */
		
		int maxSum = Integer.MIN_VALUE;
		public int maximumPathSum(Node root){
			findMaxSum(root);
			return maxSum;
		}
		
		public int findMaxSum(Node node){
			if(node==null)
				return 0;
			
			int leftSum = findMaxSum(node.getLeft());
			int rightSum = findMaxSum(node.getRight());
			// find max sum from node adjacent to its children nodes
			maxSum = Math.max(maxSum, node.getData() + leftSum + rightSum);
			
			// calculating the sum will be returned, current node plus larger one of its children
			// if the final sum is negative , return 0 
			// otherwise return the final sum
			int result = node.getData() + Math.max(leftSum, rightSum);
			return result <0 ? 0 : result;
		}
	}
	
}
