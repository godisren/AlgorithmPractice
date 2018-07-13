package tree.self;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class MinimumDepthBinaryTree {
	
	@Test
	public void test(){
		
	}
	
	public int findMin(Node root){
		// use BFS
		// traverse by BFS and set a variable 'depth' for layers visited
		
		if(root==null)
			return 0;
		
		int depth = 1;
		Node rightNode = root;
		Queue<Node> q = new LinkedList();
		q.add(root);
		while(!q.isEmpty()){
			Node cur = q.poll();
			
			if(cur.getLeft()==null || cur.getRight()==null)
				return depth;
			
			if(cur.getLeft()!=null) q.add(cur.getLeft());
			if(cur.getRight()!=null) q.add(cur.getRight());
			
			if(cur==rightNode){
				depth++;
				rightNode = cur.getLeft() !=null ? cur.getLeft() : cur.getRight();
			}
		}
		
		return depth;
	}
	
}
