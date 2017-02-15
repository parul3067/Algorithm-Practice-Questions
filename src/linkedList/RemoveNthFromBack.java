package linkedList;

public class RemoveNthFromBack {

	private static Node<Integer> deleteNthFromBack(Node<Integer> head, int pos) {
		if(pos == 0) {
			return head;
		}
		int index = 1;
		Node<Integer> dummy = new Node<Integer>(0);
		dummy.next = head;
		Node<Integer> front = dummy;
		Node<Integer> back = dummy;
		while(index <= (pos+1)) {
			front = front.next;
			index++;
		}
		
		while(front != null) {
			front = front.next;
			back = back.next;
		}
		back.next = back.next.next;
			
		return dummy.next;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l1.print();
		
		LinkedList<Integer> l2 = new LinkedList<>();
		int n = 6;
		l2.head = deleteNthFromBack(l1.head, n);
		l2.print();
 
	}

}
