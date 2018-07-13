package tree.self;

import org.junit.Test;

public class SortedArrayToBalancedBST {

	@Test
	public void test1(){
		int[] arr = new int[]{1,2,3,4,5,6,7};
		
		System.out.println(Node.print(convert(arr)));
	}
	
	public Node convert(int[] array){
		// using recursion, find media position as a node
		// with its left range to find media as left child node 
		// with its right range to find media as right child node
		
		// TODO O(?)
		
		return findMediaAsNode(array, 0, array.length-1);
	}
	
	private Node findMediaAsNode(int[] array, int start, int end){
		if(start>end)
			return null;
		
		int mid = (start+end)/2;
		Node root = new Node(array[mid]);		
		root.setLeft(findMediaAsNode(array,start, mid -1 ));
		root.setRight(findMediaAsNode(array,mid +1, end ));
		
		return root;
		
	}
}
