package others.tree;

import org.junit.Test;

import org.junit.Assert;

public class HeightOfTree {
	
	@Test
	public void test(){
		Node nodeF = new Node(null, null, 1);
		Node nodeG = new Node(null, null, 1);
		Node nodeD = new Node(nodeF, nodeG, 1);
		
		Node nodeH = new Node(null, null, 1);
		Node nodeE = new Node(null, nodeH, 1);
		
		Node nodeC = new Node(nodeD, nodeE, 1);
		
		Node nodeB = new Node(null, null, 1);
		
		Node nodeA = new Node(nodeB, nodeC, 1);
		
		Assert.assertEquals(4, heightOfTree(nodeA));		
		Assert.assertEquals(2, heightOfTree(nodeD));
	}
	
	/*
	 * int maxHeight(node currentNode){
		    if currentNode is null
		        just return 0
		    
		    otherwise, return 1 (meas node itself) + 
		    the max height between its children's return, like Math.max(maxHeight( left child node), maxHeight( right child node))
		}
	 */
	public int heightOfTree(Node currentNode){
		if(currentNode == null)
			return 0;
		
		return 1 + Math.max(heightOfTree(currentNode.left), heightOfTree(currentNode.right));
	}
	
	public class Node {
		private Node left;
		private Node right;
		private int value;

		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public Node getRight() {
			return right;
		}

		public int getValue() {
			return value;
		}
	}
}
