package linkedList;

public class DeleteMultipleOccurence {

	private static Node<Integer> deleteMultipleOccurence(Node<Integer> head, int val) {
		Node<Integer> current = head;
		while(current != null && current.next != null) {
			if(current.next.data == val) {
				current.next = current.next.next;
			} else {
			current = current.next;
			}
		}
		
		if(head.data == val) {
			return head.next;
		} else {
			return head;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.add(6);
		l1.add(6);
		l1.add(2);
		l1.add(7);
		l1.add(6);
		
		l1.print();
		l1.head = deleteMultipleOccurence(l1.head, 6);
		l1.print();
	}

}
