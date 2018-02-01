package misc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import org.junit.Assert;
import org.junit.Test;

public class A04_CloneGraph {

	@Test
	public void test1(){
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		
		n1.neighbors.add(n1);
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		
		n2.neighbors.add(n3);
		
		n3.neighbors.add(n1);
		
		UndirectedGraphNode cloneRoot = cloneGraph(n1);
		Assert.assertEquals(1, cloneRoot.label);
		
		UndirectedGraphNode cloneN1 = cloneRoot.neighbors.get(0);
		UndirectedGraphNode cloneN2 = cloneRoot.neighbors.get(1);
		UndirectedGraphNode cloneN3 = cloneRoot.neighbors.get(2);
		Assert.assertEquals(1, cloneN1.label);
		Assert.assertEquals(2, cloneN2.label);
		Assert.assertEquals(3, cloneN3.label);
		
		Assert.assertEquals(cloneN1, cloneRoot);
		Assert.assertEquals(cloneN3, cloneN2.neighbors.get(0));
		Assert.assertEquals(cloneRoot, cloneN3.neighbors.get(0));
	}
	
	public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
		return new SolutionDFS().cloneGraph(node);
//		return new SolutionBFS().cloneGraph(node);
	}
	
	public static class SolutionBFS {
		private Map<UndirectedGraphNode, UndirectedGraphNode> ori2newMap = new HashMap();
		private Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
		
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if(node==null)
	    		return null;
			
			UndirectedGraphNode cloneRoot = new UndirectedGraphNode(node.label);
			ori2newMap.put(node, cloneRoot);
			queue.add(node);
			
			while(!queue.isEmpty()){
				UndirectedGraphNode currentNode = queue.poll();
				UndirectedGraphNode currentCopyNode = ori2newMap.get(currentNode);
				for(UndirectedGraphNode child : currentNode.neighbors){
					if(ori2newMap.containsKey(child)){
						UndirectedGraphNode childCopy = ori2newMap.get(child);
						currentCopyNode.neighbors.add(childCopy);
					}else{
						UndirectedGraphNode childCopy = new UndirectedGraphNode(child.label);
						currentCopyNode.neighbors.add(childCopy);
						ori2newMap.put(child, childCopy);
						queue.add(child);
					}
				}
			}
			
			return cloneRoot;
		}
	}

	public static class SolutionDFS {
		private Map<UndirectedGraphNode, UndirectedGraphNode> ori2newMap = new HashMap();
		
		public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
			if(node==null)
	    		return null;
			
			if(ori2newMap.containsKey(node))
				return ori2newMap.get(node);
			
			UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
			ori2newMap.put(node, cloneNode);
			for(UndirectedGraphNode child:node.neighbors){
				cloneNode.neighbors.add(cloneGraph(child));
			}
			
			return cloneNode;
		}
	}
	
	static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;

		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	};
}
