package linkedList;

import java.awt.List;

public class ReverseAList implements Cloneable {

	private static LinkedList reverseList(LinkedList list) {
		Node current = list.head;
		Node prev = null;
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		l1.add(5);
		l1.print();
		
		
		LinkedList l2 = new LinkedList<>();
		try {
			l2 = l1.clone();
		} catch(CloneNotSupportedException e) {
			
		}
		System.out.println("reversed list");
		
		l2 = reverseList(l2);
		l1.print();  ///  need to check for deep copy of a linked list
		l2.print();
		
	}

}
