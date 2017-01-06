package linkedList;

public class SortALinkedList {
	
	static LinkedList sortedList = new LinkedList();
	static Node headSorted = sortedList.head;
	
	private static void addToSortedList( int value) {
		Node newNode = new Node(value);
		Node front;
		Node back;
		if(headSorted == null) {
			headSorted = newNode;
		} else if(headSorted.next == null) {
			if((int)newNode.data <= (int)headSorted.data) {
				newNode.next = headSorted;
				headSorted = newNode;
			} else {
				headSorted.next = newNode;
			}
		} else {
			front = headSorted.next;
			back = headSorted;
			while(front != null) {
				if((int)newNode.data <= (int)back.data) {
					newNode.next = headSorted;
					headSorted = newNode;
					break;
				} else {
					front = front.next;
					back = back.next;
				}
			}
				
		}
	}
	
	private static LinkedList sortedList(LinkedList list) {
		
		Node head1 = list.head;
		//Node headSorted = sortedList.head;
		while(head1 != null) {
			addToSortedList((int) head1.data);
			head1 = head1.next;
		}
		
		return sortedList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.add(5);
		l1.add(2);
		/*l1.add(3);
		l1.add(6);
		l1.add(1);
		*/
		LinkedList l2 = sortedList(l1);
		sortedList.print();
	}

}
