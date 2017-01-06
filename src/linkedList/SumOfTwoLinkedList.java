package linkedList;

public class SumOfTwoLinkedList {
	
	private static LinkedList reverse(LinkedList list) {
		Node prev = null;
		Node current = list.head;
		Node next;
		while(current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		list.head = prev;
		
		return list;
	}
	
	private static LinkedList sumOfTwoList(LinkedList list1, LinkedList list2) {
		//list1 = reverse(list1);
		//list2 = reverse(list2);
		LinkedList sumList = new LinkedList();
		Node head1 = list1.head;
		Node head2 = list2.head;
		int carry = 0;
		while(head1 != null && head2 != null) {
			int sum = 0;
			sum = (int)head1.data + (int)head2.data + carry;
			carry = sum/10;
			sum = sum%10;
			sumList.add(sum);
			head1 = head1.next;
			head2 = head2.next;
		}
		
		if(head1 != null) {
			while(head1 != null) {
				int sum = 0;
				sum = (int)head1.data + carry;
				carry = sum/10;
				sum = sum%10;
				sumList.add(sum);
				head1 = head1.next;
			}
		}
		
		if(head2 != null) {
			while(head2 != null) {
				int sum = 0;
				sum = (int)head2.data + carry;
				carry = sum/10;
				sum = sum%10;
				sumList.add(sum);
				head2 = head2.next;
			}
		}
		
		
		if(carry > 0) {
			sumList.add(carry);
		}
		
		return sumList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.add(7);
		l1.add(1);
		l1.add(6);
		LinkedList l2 = new LinkedList();
		l2.add(5);
		l2.add(9);
		l2.add(2);
		l1.print();
		l2.print();
		
		LinkedList l3 = sumOfTwoList(l1,l2);
		l3.print();
	}

}
