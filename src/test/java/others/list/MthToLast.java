package others.list;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import others.list.MthToLast.ListElement;

/**
 * Mth-to-Last element of a Linked List
 * 
 * ProbLem 
 * Given a singly linked list, devise a time- and space-effcient algorithm
 * to find the mth-to-last element of the list. Implement your algorithm, taking care
 * to handle relevant error conditions. Define mth to last such that when m = 0 the
 * last element of the list is returned.
 *
 */
public class MthToLast {

	/*
	Ex. 
	0 -> 1 -> 2 -> 3 -> 4 -> 5
	*/
	
	ListElement head = null;
	
	@Before
	public void init(){
//		ListElement node6 = new ListElement(5, null);
//		ListElement node5 = new ListElement(4, node6);
		ListElement node4 = new ListElement(3, null);
		ListElement node3 = new ListElement(2, node4);
		ListElement node2 = new ListElement(1, node3);
		head = new ListElement(0, node2);
	}
	
	@Test
	public void test1(){
		int n = 3;
		ListElement e = findMToLastElement(head, n);
		Assert.assertEquals(e.data, 2);
	}
	
	@Test
	public void test2(){
		int n = 0;
		ListElement e = findMToLastElement(head, n);
		Assert.assertEquals(e.data, 5);
	}
	
	@Test
	public void test3(){
		int n = 5;
		ListElement e = findMToLastElement(head, n);
		Assert.assertEquals(e.data, 0);
	}
	
	@Test
	public void test4(){
		int n = 1;
		ListElement e = findMToLastElement(head, n);
		Assert.assertEquals(e.data, 2);
	}
	
//	@Test
	public void testError(){
		try {
			findMToLastElement(head, -1);
		} catch (Exception e) {
			Assert.assertEquals("illegal param", e.getMessage());
		}
		
		try {
			findMToLastElement(null,3);
		} catch (Exception e) {
			Assert.assertEquals("head is null", e.getMessage());
		}
		
		try {
			findMToLastElement(head,6);
		} catch (Exception e) {
			Assert.assertEquals("nLast exceed total of list", e.getMessage());
		}
	}
	
	public ListElement findMToLastElement(ListElement head, int m){	
		// 0 -> 1 -> 2 -> 3
		// ex. m=0, return 3
		// ex. m=1, return 2
		// ex. m=3, return 0
		// m<0 || m=4 || head==null, return null
		// m > length of list , return null
		
		// assume n is a length of the list
		// m + x = n
		// x = n - m (1st) current reference is a counter
		// m = n - x (2rd)
		
		// 1st. find x
		// ex. m = 4
		// move from 0 to 1
		ListElement current = head;
		for(int i = 0;i<m;i++){
			if(current.next!=null)
				current = current.next;
			else 
				return null;
			
			
		}
		// current = 1 , the rest(2,3) 'x' length = 2
		
		// 2nd. find m position through x
		// current: 0 
		// move on 1,2,3 (3 times)
		// findM:0
		// move on 1,2,3
		ListElement findM = head;
		while(current.next!=null){
			current = current.next;
			findM = findM.next;
		}
		
		// findM = 3
		return findM;
	}
	
	class ListElement{
		ListElement next;
		int data;
		
		public ListElement(int data, ListElement next) {
			super();
			this.data = data;
			this.next = next;
		}	
	}
}
