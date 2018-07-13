package leecode;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;

/**
 * Question:
 * Depth of an N-Ary tree
 * 
 * Given an N-Ary tree, find depth of the tree. An N-Ary 
 * tree is a tree in which nodes can have at most N children.
 * 
 * 
 *
 */
public class DepthNAryTree {
	
	@Test
	public void test1(){
		Node root = new Node(1,new ArrayList());
		
		Node n1 = new Node(2,new ArrayList());
		Node n2 = new Node(3,new ArrayList());
		Node n3 = new Node(4,new ArrayList());
		
		root.child.add(n1);
		root.child.add(n2);
		root.child.add(n3);
		
		Assert.assertEquals(2, depthOfTree(root));
	}
	
	@Test
	public void test2(){
		Node root = new Node(1,new ArrayList());
		
		Node n1 = new Node(2,new ArrayList());
		Node n2 = new Node(3,new ArrayList());
		Node n3 = new Node(4,new ArrayList());
		
		Node n4 = new Node(4,new ArrayList());
		
		root.child.add(n1);
		root.child.add(n2);
		root.child.add(n3);
		
		n3.child.add(n4);
		
		Assert.assertEquals(3, depthOfTree(root));
	}
	
	class Node{
		int val;
		List<Node> child;
		
		public Node(int val, List<Node> child) {
			super();
			this.val = val;
			this.child = child;
		}
	}
	
	static int depthOfTree(Node root){
		if(root==null) return 0;
		
		int depth = 1;
		
		if(root.child != null)
			for(Node childNode: root.child){
				depth = Math.max(depth, depthOfTree(childNode) + 1);
			}
		
		return depth;
	}
}
