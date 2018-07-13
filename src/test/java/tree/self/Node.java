package tree.self;

public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		super();
		this.data = data;
	}
	public Node(int data, Node left, Node right) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
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
	
	public void setLeftAndRight(Node left,Node right) {
		this.left = left;
		this.right = right;
	}
	
	public static String print(Node root) {		
		if(root==null)
			return "null";
		
		return root.getData() + 
				((root.left!=null || root.right!=null) ? "[" + print(root.left) + "," + print(root.right) + "]" : "");
	}
	
}
