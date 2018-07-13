package others.tree;

import java.util.Stack;

import org.junit.Test;

public class PreorderTraversal {
	
	@Test
	public void test(){
		Node n25 = new Node(null,null, 25);
		Node n75 = new Node(null,null, 75);
		Node n50 = new Node(n25, n75 , 50);
		Node n110 = new Node(null,null, 110);
		Node n125 = new Node(n110,null, 125);
		Node n175 = new Node(null,null, 175);
		Node n150 = new Node(n125,n175, 150);
		Node n100 = new Node(n50,n150, 100);
		
		preorderTraverse(n100);
		System.out.println("");
		preorderTraverseNoRecursion(n100);
	}
	
	public void preorderTraverse(Node root){
		if(root == null)
			return ;		
		
		System.out.print(root.value+",");
		preorderTraverse(root.left);
		preorderTraverse(root.right);		
	}
	
	public void preorderTraverseNoRecursion(Node root){
		// TODO simplify
		Stack<Node> stack = new Stack();
		
		Node cur = root;
		while(cur!=null){
			System.out.print(cur.value+",");
			if(cur.right !=null)
				stack.add(cur.right);
			
			if(cur.left != null)
				cur = cur.left;
			else if(!stack.isEmpty())
				cur = stack.pop();
			else 
				break;
		}
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
