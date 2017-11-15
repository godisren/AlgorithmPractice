package bean;

public class ListNode {
	public int val;
	public ListNode next;

	public ListNode(int x) {
		val = x;
	}

	public static boolean eqaulsIntegerArrayValue(ListNode node, int[] intArr) {

		if (node == null && intArr.length > 0)
			return false;

		int i = 0;
		ListNode curNode = node;
		while (curNode != null) {

			if (i >= intArr.length || intArr[i] != curNode.val)
				return false;

			i++;
			curNode = curNode.next;
		}
		
		return i == intArr.length;
	}

	public static ListNode createNodeWithIntegerArray(int[] intArr) {
		ListNode firstNode = null;
		ListNode preNode = null;
		for (int i = 0; i < intArr.length; i++) {

			if (i == 0) {
				firstNode = new ListNode(intArr[i]);
				preNode = firstNode;
			} else {
				preNode.next = new ListNode(intArr[i]);
				preNode = preNode.next;
			}
		}

		return firstNode;
	}

	public static void printListNode(ListNode node) {
		ListNode curNode = node;
		while (curNode != null) {
			System.out.println(curNode.val);
			curNode = curNode.next;
		}
	}
}
