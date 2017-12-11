package bean;

public class TreeNode {

	public int val;
	public TreeNode left;
	public TreeNode right;

	public TreeNode(int x) {
		val = x;
	}

	public static String print(TreeNode root) {		
		if(root==null)
			return "null";
		
		return root.val + 
				((root.left!=null || root.right!=null) ? "[" + print(root.left) + "," + print(root.right) + "]" : "");
	}
	
	public static TreeNode create(int val){
		return new TreeNode(val);
	}
}
