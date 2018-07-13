package others.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * Problem You are given a set of integers in an unordered binary tree. 
 * Use an array sorting routine to transform the tree into a heap that uses a balanced binary
 * tree as its underlying data structure.
 */
public class HeapifyBinaryTree {
	@Test
	public void test(){
		// test data
		//      6
		//	   / \
		//    3   10
		//   /\   /\
		//  12 2  5 9
		Node root = new Node(6);
		Node n3 = new Node(3);
		Node n10 = new Node(10);
		root.setLeftAndRight(n3,n10);
		
		Node n12 = new Node(12);
		Node n2 = new Node(2);
		n3.setLeftAndRight(n12, n2);
		
		Node n5 = new Node(5);
		Node n9 = new Node(9);
		n10.setLeftAndRight(n5, n9);
		
		printTree(root);
		root = heapifyBinaryTree(root);
		printTree(root);
	}
	
	public Node heapifyBinaryTree(Node root ){
		int size = traverse(root,0,null);
		Node[] nodes = new Node[size];
		traverse(root,0,nodes);
		printArray(nodes);
		
		Arrays.sort(nodes, new Comparator<Node>(){
			@Override
			public int compare(Node obj1, Node obj2) {
				return obj1.getValue() - obj2.getValue();
			}
		});
		
		printArray(nodes);
		
		// [1,2,3]
		//       1(i)
		//		/	\
		//2(i*2+1)  3(i*2+2)
		for(int i = 0;i<size;i++){
			Node cur = nodes[i];
			int leftIdx = i*2+1;
			int rightIdx = leftIdx+1;
			cur.setLeft(leftIdx<size ? nodes[leftIdx]:null);
			cur.setRight(rightIdx<size ? nodes[rightIdx]:null);
		}
		
		return nodes[0];
	}

	private void printArray(Node[] nodes) {
		for(Node n:nodes)
			System.out.print(n.getValue()+",");
		System.out.println("");
	}
	
	public int traverse(Node root,int count, Node[] nodes){
		if(root == null)
			return count;
		
		if(nodes!=null)
			nodes[count] = root;
		count++;
		count = traverse(root.left,count,nodes);
		count = traverse(root.right,count,nodes);
		return  count;
	}
	
	private int findDepth(Node root) {
		if(root==null)
			return 0;
		
		return 1 + Math.max(findDepth(root.left) , findDepth(root.right));
	}

	
	private void printTree(Node root) {
		int depth = findDepth(root);
		String fixedSpaces = "  ";
		
		printNodeWithBSF(root, depth);
	}
	
	private void printNodeWithBSF(Node root, int depth){
		Node emptyNode = new Node(-99);
		
		Node theMostRightNode = root;
		Queue<Node> q = new LinkedList();
		q.add(root);
		
		int level = 0;
		while(!q.isEmpty()){
			Node cur = q.poll();
			int spaces = 2 * depth;
			String leftPadding = String.format("%"+spaces+"s", "");
			//System.out.println("%"+spaces+"s");
			System.out.print(leftPadding);
			System.out.print(String.format("%02d", cur.getValue()));
			System.out.print(leftPadding);
			
//			if(cur.left!=null)
				q.add(cur.left!=null ? cur.left:emptyNode);
			
//			if(cur.right!=null)
				q.add(cur.right!=null ? cur.right:emptyNode);
			
			if(cur == theMostRightNode){
				if(--depth==0)
					break;
				
				theMostRightNode = cur.right!=null ? cur.right : cur.left;
				System.out.println("");
				for(int i =0 ;i<=level;i++)
					System.out.print(leftPadding+"/\\");
				System.out.println("");
				level++;
			}
		}
		System.out.println("");
	}
	
	public class Node {
		private Node left;
		private Node right;
		private int value;
		
		public Node(int value) {
			super();
			this.value = value;
		}

		public Node(Node left, Node right, int value) {
			this.left = left;
			this.right = right;
			this.value = value;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}
		
		public Node getRight() {
			return right;
		}
		
		public void setRight(Node right) {
			this.right = right;
		}
		
		public void setLeftAndRight(Node left, Node right){
			this.left = left;
			this.right = right;
		}
		
		public int getValue() {
			return value;
		}
	}
}
