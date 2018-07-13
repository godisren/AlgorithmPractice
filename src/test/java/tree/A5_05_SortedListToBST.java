package tree;
import org.junit.Assert;
import org.junit.Test;

import bean.ListNode;
import bean.TreeNode;

/**
 * Question:
 * Convert Sorted List to Binary Search Tree
 * 
 * Given a singly linked list where elements are sorted in 
 * ascending order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined 
 * as a binary tree in which the depth of the two subtrees of 
 * every node never differ by more than 1.
 *
 */
public class A5_05_SortedListToBST {
	
	@Test
	public void test1(){
		TreeNode root = sortedListToBST(ListNode.createNodeWithIntegerArray(new int[]{1}));
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,1);
		Assert.assertNull(root.left);
		Assert.assertNull(root.right);
	}
	
	@Test
	public void test2(){
		TreeNode root = sortedListToBST(ListNode.createNodeWithIntegerArray(new int[]{1,2}));
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val, 2);
		Assert.assertNull(root.left);
	}
	
	@Test
	public void test3(){
		TreeNode root = sortedListToBST(ListNode.createNodeWithIntegerArray(new int[]{1,2,3}));
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,2);
		Assert.assertNotNull(root.left);
		Assert.assertEquals(root.left.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val,3);
	}
	
	@Test
	public void test4(){
		TreeNode root = sortedListToBST(ListNode.createNodeWithIntegerArray(new int[]{1,2,3,4}));
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,2);
		Assert.assertNotNull(root.left);
		Assert.assertEquals(root.left.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val,3);
		Assert.assertEquals(root.right.right.val,4);
	}
	
	static TreeNode sortedListToBST(ListNode head){
		return new Solution().sortedListToBST(head);
	}

	public static class Solution{
		private ListNode cur;
		
		// time: O(2n) -> O(n)
		public TreeNode sortedListToBST(ListNode head) {
			int len =0;
			ListNode n = head;
			while(n!=null){
				n = n.next;
				len++;
			}
			
			cur = head;
			return sortedListToBST(0, len-1);
	    }
		
		private TreeNode sortedListToBST(int start, int end){
			if(start > end) return null;
			
			int mid = (start+end) / 2;
			TreeNode leftNode = sortedListToBST(start, mid-1);
			TreeNode node = new TreeNode(cur.val);
			node.left = leftNode;
			cur = cur.next;
			TreeNode rightNode = sortedListToBST(mid+1,end);
			node.right = rightNode;
			
			return node;
		}
	}
	
}
