package tree.self;

import org.junit.Assert;
import org.junit.Test;

import tree.self.ValidateBinarySearchTree.Node;

public class MaximumDepthBinary {
	
	@Test
	public void test1(){
		/**
		 * 		1
		 * 	  /	  \
		 * 	 3		2
		 * exepected:1
		 */
		
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2);
		n1.setLeftAndRight(n3, n2);
		Assert.assertEquals(2, findMax(n1));
	}
	
	@Test
	public void test2(){
		/**
		 * 		1
		 * 	  /	  \
		 * 	 3		2
		 *    \
		 *     4
		 * exepected:1
		 */
		
		Node n1 = new Node(1);
		Node n3 = new Node(3);
		Node n2 = new Node(2);
		Node n4 = new Node(2);
		n1.setLeftAndRight(n3, n2);
		n3.setRight(n4);
		Assert.assertEquals(3, findMax(n1));
	}
	
	public int findMax(Node root){
		// using DFS to find the maximum depth of tree
		// compare which one is maximum between left child node and right child node
		// then +1 , mean current node's layer
		
		if(root==null)
			return 0;
		
		return 1 + Math.max(findMax(root.getLeft()),
				findMax(root.getRight()));
	}
	
}
