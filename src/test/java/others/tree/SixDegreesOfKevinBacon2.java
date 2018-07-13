package others.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class SixDegreesOfKevinBacon2 {

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
		List<ActorNode> movie2 = Arrays.asList(new ActorNode[]{b,d});
		List<ActorNode> movie3 = Arrays.asList(new ActorNode[]{d,e,f});
		List<ActorNode> movie4 = Arrays.asList(new ActorNode[]{d,f,Bacon});
		
		buildActorsConnection(movie1);
		buildActorsConnection(movie2);
		buildActorsConnection(movie3);
		buildActorsConnection(movie4);
		
		// just call once for calculating each node's Bacon Number from Bacon node
		Bacon.precomputeBaconNumber();
		
		// then, we can get Bacon number from each node and just take O(1) time.
		System.out.println("a's Bacon Number:"+a.getBaconNumber());
		a.pirntBaconPath();
		Assert.assertEquals(2, a.getBaconNumber());
		
		System.out.println("b's Bacon Number:"+b.getBaconNumber());
		b.pirntBaconPath();
		Assert.assertEquals(1, b.getBaconNumber());
		
		System.out.println("e's Bacon Number:"+e.getBaconNumber());
		e.pirntBaconPath();
		Assert.assertEquals(1, e.getBaconNumber());
		
	}
	
	private void buildActorsConnection(List<ActorNode> actors) {		
		for(ActorNode cur:actors){
			List<ActorNode> linkedActors = new ArrayList(actors);
			linkedActors.remove(cur);
			cur.addLinkedActor(linkedActors);
		}
	}
	
	static public class ActorNode {
		private String name;
		private Set<ActorNode> linkedActors;
		private int baconNumber = -1; // minus number means unvisited, otherwise visited
		private ActorNode baconPath;

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
		
		public void setBaconPath(ActorNode actor) {
			baconPath = actor;
		}
		
		public ActorNode getBaconPath() {
			return baconPath;
		}

		public void pirntBaconPath(){
			if(baconPath==null){
				System.out.println("not found");
				return ;
			}
			
			System.out.print(this.getName() +" -> ");
			
			ActorNode cur = baconPath;
			while(cur!=null){
				System.out.print(cur.getName());
				cur = cur.getBaconPath();
				if(cur!=null)
					System.out.print(" -> ");
			}
			
			System.out.println("");
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

		// be called only on the Bacon node 
		public void precomputeBaconNumber(){
			Queue<ActorNode> q = new LinkedList();
			q.add(this);
			while(!q.isEmpty()){
				ActorNode cur = q.poll();
				
				for(ActorNode linkedActor:cur.getLinkedActors()){
					// Encountering visited node and Bacon node won't continue to handle number and path  
					if(linkedActor.getBaconNumber()>=0 || linkedActor==this)
						continue;
					
					linkedActor.setBaconNumber(cur.getBaconNumber()+1);
					linkedActor.setBaconPath(cur);
					q.add(linkedActor);
				}
			}
		}
	}
}
