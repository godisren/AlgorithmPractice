package others.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Test;

import org.junit.Assert;

public class SixDegreesOfKevinBacon {

	@Test
	public void test(){
		// a, b, c in movie1
		// b, c, d in movie2
		// d, e, f in movie3
		// d, f, Bacon in movie 4
		
		ActorNode a = new ActorNode("a");
		ActorNode b = new ActorNode("b");
		ActorNode c = new ActorNode("c");
		ActorNode d = new ActorNode("d");
		ActorNode e = new ActorNode("e");
		ActorNode f = new ActorNode("f");
		ActorNode Bacon = new ActorNode("Bacon");
		
		List<ActorNode> movie1 = Arrays.asList(new ActorNode[]{a,b,c});
		List<ActorNode> movie2 = Arrays.asList(new ActorNode[]{b,c,d});
		List<ActorNode> movie3 = Arrays.asList(new ActorNode[]{d,e,f});
		List<ActorNode> movie4 = Arrays.asList(new ActorNode[]{d,f,Bacon});
		
		buildActorsConnection(movie1);
		buildActorsConnection(movie2);
		buildActorsConnection(movie3);
		buildActorsConnection(movie4);
		
//		int n = computeBaconNumber(Bacon, a);
//		System.out.println("a's Bacon Number:"+n);
//		Assert.assertEquals(2, n);
		
		int n = computeBaconNumber(Bacon, b);
		System.out.println("b's Bacon Number:"+n);
		Assert.assertEquals(1, n);
		
	}
	
	// using BFS to find Bacon Number
	private int computeBaconNumber(ActorNode Bacon, ActorNode a) {
		Queue<ActorNode> q = new LinkedList();
		q.add(a);
		while(!q.isEmpty()){
			ActorNode cur = q.poll();
			if(cur == Bacon)
				return cur.getBaconNumber();
			
			for(ActorNode linkedActor:cur.getLinkedActors()){
				// already visited
				if(linkedActor.getBaconNumber()>=0)
					continue;
				
				linkedActor.setBaconNumber(cur.getBaconNumber()+1);
				q.add(linkedActor);
			}
		}
		
		throw new RuntimeException("not found");
	}

	private void buildActorsConnection(List<ActorNode> movie1) {
		
		for(ActorNode actor:movie1){
			List<ActorNode> linkedActors = new ArrayList(movie1);
			linkedActors.remove(actor);
			actor.addLinkedActor(linkedActors);
		}
	}

	static public class ActorNode {
		private String name;
		private Set<ActorNode> linkedActors;
		private int baconNumber = -1; // minus number means unvisited, otherwise visited	

		public ActorNode(String name) {
			super();
			this.name = name;
			linkedActors = new LinkedHashSet<ActorNode>();
		}

		public void addLinkedActor(ActorNode actor) {
			linkedActors.add(actor);
		}

		public void addLinkedActor(Collection<ActorNode> actor) {
			linkedActors.addAll(actor);
		}
		
		public Set<ActorNode> getLinkedActors() {
			return linkedActors;
		}

		public String getName() {
			return name;
		}

		public int getBaconNumber() {
			return baconNumber;
		}

		public void setBaconNumber(int baconNumber) {
			this.baconNumber = baconNumber;
		}

	}
}
