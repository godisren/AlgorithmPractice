import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * Question:
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * Return a deep copy of the list. 
 *
 */
public class A4_05_CopyRandomList {
	static class RandomListNode{
		int label;
		RandomListNode next, random;
		RandomListNode(int x){this.label = x;};
	}
	
	@Test
	public void test1(){
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		node1.random = node3;
		node2.random = node4;
		node3.random = node2;
		node4.random = node1;
		
		RandomListNode copyNode = copyRandomList(node1);
		assertEqaulsListNode(copyNode, node1);
	}
	
	@Test
	public void test2(){
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		//node1.random = node3;
		node2.random = node4;
		node3.random = node2;
		node4.random = node1;
		
		RandomListNode copyNode = copyRandomList(node1);
		assertEqaulsListNode(copyNode, node1);
	}
	
	@Test
	public void test3(){
		RandomListNode node1 = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		
		node1.next = node2;
		
		//node1.random = node3;
		node1.random = node2;
		node2.random = node2;
		
		RandomListNode copyNode = copyRandomList(node1);
		assertEqaulsListNode(copyNode, node1);
	}
	
	public static RandomListNode copyRandomList(RandomListNode head){
		//return copyRandomListByMap(head);
		return copyRandomListByNewStructure(head);
	}
	
	// faster than the other
	public static RandomListNode copyRandomListByNewStructure(RandomListNode head){
		RandomListNode c = head; 
		while(c!=null){
			RandomListNode tmpNext = c.next;
			c.next = new RandomListNode(c.label);
			c.next.next = tmpNext;			
			c = c.next.next; 
		}
		
		c = head;
		while(c!=null){
			if(c.random!=null)
				c.next.random = c.random.next;			
			c = c.next.next;
		}
		
		RandomListNode dummyHead = new RandomListNode(0);
		RandomListNode n = dummyHead; 
		c = head;
		while(c!=null){
			n.next = c.next;
			c.next = c.next.next;
			
			c = c.next;
			n = n.next;
		}
		
		return dummyHead.next;
	}
	
	public static RandomListNode copyRandomListByMap(RandomListNode head){
		if(head==null)
			return null;
		
		Map<RandomListNode, RandomListNode> old2NewMap = new HashMap<RandomListNode, RandomListNode>();
		
		RandomListNode dummyHead = new RandomListNode(0);
		RandomListNode cur = dummyHead;
		while(head!=null){
			RandomListNode newCopyNode = new RandomListNode(head.label);
			cur.next = newCopyNode;
			
			// old to new
			if(!old2NewMap.containsKey(head)){
				old2NewMap.put(head, newCopyNode);
			}
			
			if(head.random!=null){
				if(!old2NewMap.containsKey(head.random)){
					RandomListNode tmpNewRandomNode = new RandomListNode(head.random.label);
					old2NewMap.put(head.random, tmpNewRandomNode);
				}
				
				newCopyNode.random = old2NewMap.get(head.random);
			}
						
			head = head.next;
			cur = cur.next;
		}
				
		return dummyHead.next;
	}
	
	private void assertEqaulsListNode(RandomListNode list1, RandomListNode list2){
		while(list1!=null && list2!=null){
			System.out.println(String.format("node comparison\n%s:%d\n%s:%d", list1, list1.label , list2, list2.label));
			System.out.println(String.format("node random comparison\n%s:%d\n%s:%d", 
							list1.random, getLabel(list1.random) 
						, list2.random, getLabel(list2.random)));
			
			Assert.assertTrue("node refernce must not be the same", list1 != list2);
			Assert.assertTrue("node value must be the same", list1.label == list2.label);
			if((list1.random ==null && list2.random ==null)){
				// it's right, nothing to do
			}else{
				Assert.assertTrue("random refernce must not be the same", list1.random != list2.random);
				Assert.assertTrue("random value must be the same", getLabel(list1.random) == getLabel(list2.random));
			}			
			
			list1 = list1.next;
			list2 = list2.next;
		}
		
		Assert.assertTrue(list1==null && list2==null);
	}
	
	private static Integer getLabel(RandomListNode listNode){
		if(listNode==null)
			return null;
		
		return listNode.label;
	}
}
