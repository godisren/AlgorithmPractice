import org.junit.Assert;
import org.junit.Test;

import bean.TreeNode;

/**
 * Question:
 * Convert Sorted Array to Binary Search Tree 
 * 
 * Given an array where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as 
 * a binary tree in which the depth of the two subtrees of every 
 * node never differ by more than 1.
 *
 */
public class A5_05_SortedArrayToBST {
	
	@Test
	public void test1(){
		TreeNode root = sortedArrayToBST(new int[]{1});
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,1);
		Assert.assertNull(root.left);
		Assert.assertNull(root.right);
	}
	
	@Test
	public void test2(){
		TreeNode root = sortedArrayToBST(new int[]{1,2});
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val, 2);
		Assert.assertNull(root.left);
	}
	
	@Test
	public void test3(){
		TreeNode root = sortedArrayToBST(new int[]{1,2,3});
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,2);
		Assert.assertNotNull(root.left);
		Assert.assertEquals(root.left.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val,3);
	}
	
	@Test
	public void test4(){
		TreeNode root = sortedArrayToBST(new int[]{1,2,3,4});
		System.out.println(TreeNode.print(root));
		
		Assert.assertEquals(root.val,2);
		Assert.assertNotNull(root.left);
		Assert.assertEquals(root.left.val,1);
		Assert.assertNotNull(root.right);
		Assert.assertEquals(root.right.val,3);
		Assert.assertEquals(root.right.right.val,4);
	}

	public static TreeNode sortedArrayToBST(int[] nums){
		return createChildNode(nums, 0, nums.length-1);
	}
	
	public static TreeNode createChildNode(int[] nums, int begin, int end){
		if(begin>end) return null;
		
		int mid = (begin+end)/2;
		TreeNode node = TreeNode.create(nums[mid]);
		node.left = createChildNode(nums, begin, mid-1);
		node.right = createChildNode(nums, mid+1, end);		
		
		return node;
	}
}
